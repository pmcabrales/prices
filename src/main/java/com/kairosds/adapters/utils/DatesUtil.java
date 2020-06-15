package com.kairosds.adapters.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatesUtil {
    public static LocalDateTime dateFormat(String sDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return LocalDateTime.parse(sDate, formatter);
    }
}
