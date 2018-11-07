package com.panther.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/uploads")
public class UploadFile {

    private Logger logger = LoggerFactory.getLogger(UploadFile.class);

    public String getProjectRootPath() throws FileNotFoundException {
        //获取根目录
        File path=new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()){
            path=new File("");
        }
        File upload=new File(path.getAbsolutePath(),"/uploadFile/");
        if(!upload.exists()){
            upload.mkdirs();
        }
        return upload.getAbsolutePath()+"\\";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public Map<String, String> upload1(@RequestParam("file") MultipartFile file) throws IOException {
        logger.info("[文件类型] - [{}]", file.getContentType());
        logger.info("[文件名称] - [{}]", file.getOriginalFilename());
        logger.info("[文件大小] - [{}]", file.getSize());
        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）

        file.transferTo(new File(getProjectRootPath() + file.getOriginalFilename()));
        Map<String, String> result = new HashMap<>();
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("path", getProjectRootPath());
        result.put("fileSize", file.getSize() + "");
        return result;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String, String>> upload2(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        List<Map<String, String>> results = new ArrayList<>();
        for(MultipartFile file : files){
            // TODO Spring Mvc 提供的写入方式
            file.transferTo(new File(getProjectRootPath() + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>();
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return results;
    }

    /**
     * Base64 上传
     * @param base64
     * @param session
     * @throws IOException
     */
    @PostMapping("/upload3")
    @ResponseBody
    public void upload3(String base64, HttpSession session) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）

        final File tempFile;
        if(!"".equals(session.getAttribute("user"))){
            tempFile = new File(getProjectRootPath() + session.getAttribute("user")+"_test.jpg");
        }else{
            return;
        }
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);
    }



}
