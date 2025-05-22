package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LottoData(
    long totSellamnt,
    String returnValue,
    String drwNoDate,
    long firstWinamnt,
    int drwtNo6,
    int drwtNo4,
    int firstPrzwnerCo,
    int drwtNo5,
    int bnusNo,
    long firstAccumamnt,
    int drwNo,
    int drwtNo2,
    int drwtNo3,
    int drwtNo1
) {}