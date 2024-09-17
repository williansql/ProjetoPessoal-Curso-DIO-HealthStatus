package com.project_bootcamp_deal_dio.health_status.prontuary.prontuary.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GenerateProntuaryCode {

    public String generateCode() {
        LocalDateTime time = LocalDateTime.parse(LocalDateTime.now().toString());
        String code = "PR";
        return code
                + time.getDayOfMonth()
                + time.getMonthValue()
                + time.getYear()
                + time.getHour()
                + time.getMinute()
                + time.getSecond()
                + time.getNano();
    }
}
