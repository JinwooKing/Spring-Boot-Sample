package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DynamicSchedulerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class DynamicSchedulerController {

    @Autowired
    private DynamicSchedulerService dynamicSchedulerService;

    @GetMapping("/start")
    public String start() {
        return dynamicSchedulerService.start();
    }

    @GetMapping("/stop")
    public String stop() {
        return dynamicSchedulerService.stop();
    }

    @GetMapping("/change")
    public String updateInterval(@RequestParam long interval, @RequestParam(defaultValue = "s") String timetype, @RequestParam(defaultValue = "false") boolean restart) {
        String rtnVal = dynamicSchedulerService.updateInterval(interval, timetype);
        
        if (restart) {
            dynamicSchedulerService.stop();
            dynamicSchedulerService.start();
        }
        return rtnVal;
    }

    @GetMapping("/status")
    public String status() {
        return dynamicSchedulerService.getStatus();
    }
}
