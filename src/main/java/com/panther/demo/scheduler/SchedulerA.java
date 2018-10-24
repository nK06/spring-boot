package com.panther.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerA {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    @Scheduled(fixedDelay = 3000)
    public void reportCurrentTime(){
        System.out.println("现在时刻" + DATE_FORMAT.format(new Date()));
    }

    @Scheduled(fixedDelay = 1000)
    public void reportCurrentTimeA(){
        System.out.println("现在时刻A" + DATE_FORMAT.format(new Date()));
    }

}
