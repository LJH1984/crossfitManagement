package main.java.com.crossfitmanagement.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //  현재 날짜/시간을 기본 형식으로 변환
    public static String getCurrentDateTime(){
        return formatDate(new Date(), DEFAULT_FORMAT);
    }

    // 특정 형식으로 날짜를 포맷팅
    public static String formatDate(Date date, String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}
