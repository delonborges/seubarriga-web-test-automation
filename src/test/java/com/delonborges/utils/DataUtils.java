package com.delonborges.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtils {

    public static String obtemDataAtual() {
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        return format.format(calendar.getTime());
    }

    public static String obtemDataAtualEAdicionaDias(Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        return format.format(calendar.getTime());
    }
}