package com.panther.demo.test;

import com.panther.demo.utils.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void SendSimpleMailTest(){
        mailService.sendSimpleMail("982560443@qq.com","第一封测试邮件","测试邮件内容。");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content="<html>\n"+"<body>\n"+"<h3>测试HTML邮件</h3>\n"+"</body>\n"+"</html>";
        mailService.sendHtmlMail("982560443@qq.com","第二封测试HTML邮件",content);
    }

    @Test
    public void sendAttachmentsMailTest() throws MessagingException {
        String filePath = "C://Users//98256//Desktop//运动会分组.xlsx";
        mailService.sendAttachmentsMail("982560443@qq.com","测试带附件的邮件","带附件邮件内容。",filePath);
    }

    @Test
    public void sendInlineResourceMailTest(){
        String imgPath = "C://Users//98256//Desktop//a.png";
        String rscId = "aaaa";
        String content = "<html><body> 图片邮件：<img src=\'cid:"+rscId+"\'></img></body></html>";
        mailService.sendInlinResourceMail("982560443@qq.com","测试图片邮件",content,imgPath,rscId);
    }

    @Test
    public void testTemplateMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id","007");
        String emailContent=templateEngine.process("emailTemplate",context);
        mailService.sendHtmlMail("982560443@qq.com","模板邮件",emailContent);
    }
}
