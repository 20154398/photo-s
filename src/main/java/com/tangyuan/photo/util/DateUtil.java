package com.tangyuan.photo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");

    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String getTime(Date date) {
        return sdf.format(date);
    }

    public String getTime(LocalDateTime createTime) {
        return df.format(createTime);
    }

    /**
     * 获取本月第一天
     *
     * @return
     */
    public String getFirstDayOfTheMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        return getTime(calendar.getTime());
    }

    private static class SingletonHolder {
        private static final DateUtil INSTANCE = new DateUtil();
    }

    public static DateUtil getInstance() {
        return DateUtil.SingletonHolder.INSTANCE;
    }
}
