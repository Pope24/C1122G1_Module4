package com.timezone.service;

import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;
@Service
public class TimezoneService implements ITimezoneService {
    @Override
    public Date getTimezoneCity(String city) {
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);

        return date;
    }
}
