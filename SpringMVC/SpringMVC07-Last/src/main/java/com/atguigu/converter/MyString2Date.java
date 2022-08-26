package com.atguigu.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyString2Date implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        try {
            return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
