package com.panther.demo.kafka;

import java.util.Date;

public class Message {

    private Long id;    //id

    private int code;  //返回码

    private String msg; //消息

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    private Date startTime;  //时间戳

    private Date sendTime;  //时间戳

    private String logPath; //日志地址

    public Long getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public String getLogPath() {
        return logPath;
    }
}
