package com.example.demo.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class DynamicSchedulerService {
   
    private ThreadPoolTaskScheduler taskScheduler;
    private ScheduledFuture<?> scheduledFuture;
    private long interval = 5; // 기본 주기 5초
    private long intervalMillis = 5000; // 기본 주기 5초
    private String timetype = "s"; // 기본 단위는 초
    private ZonedDateTime nextExecutionTime;


    @PostConstruct
    public void init() {
        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1);
        taskScheduler.setThreadNamePrefix("dynamic-scheduler-");
        taskScheduler.initialize();
        this.start(); // 초기화 후 즉시 시작
    }

    @PreDestroy
    public void shutdown() {
        stop();
        taskScheduler.shutdown();
    }

    private final Runnable task = () -> {
        ZonedDateTime now = Instant.ofEpochMilli(System.currentTimeMillis())
                                    .atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    
        // 현재 시간 출력
        System.out.println("작업 실행: " + now.format(formatter));
    
        // 다음 실행 시간 계산 (intervalMillis 후 시간)
        nextExecutionTime = now.plusNanos(intervalMillis * 1_000_000L); // millis → nanos
        System.out.println("다음 실행 예정: " + nextExecutionTime.format(formatter));
    };

    public String start() {
        stop(); // 중복 방지
        scheduledFuture = taskScheduler.scheduleAtFixedRate(task, intervalMillis);
        return "Scheduler started";
    }

    public String stop() {
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            scheduledFuture.cancel(false);
        }
        return "Scheduler stopped";
    }

    public String updateInterval(long interval, String timetype) {
        long intervalMillis = interval; // 기본 단위는 초

        if(timetype.equals("m")) {
            intervalMillis *= 1000 * 60; // minutes to milliseconds
        }else if(timetype.equals("h")) {
            intervalMillis *= 1000 * 60 * 60; // hours to milliseconds
        }else{
            intervalMillis *= 1000; // seconds to milliseconds
        }

        this.interval = interval;
        this.timetype = timetype;
        this.intervalMillis = intervalMillis;
        return "Scheduler interval updated to " + interval + (timetype == "s" ? "seconds" : timetype == "m" ? "minutes" : "hours");
    }

    public boolean isRunning() {
        return scheduledFuture != null && !scheduledFuture.isCancelled();
    }

    public String getStatus() {
        return isRunning() ? "Scheduler is running. "
                                + "interval: " + interval + (timetype == "s" ? "seconds" : timetype == "m" ? "minutes" : "hours")
                                + "nextExecutionTime: " + nextExecutionTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
                            : "Scheduler is stopped";
    }
}
