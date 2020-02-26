package com.technology.reflection.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author chenguangxu
 * @create 2020/2/26 14:34
 */
public class DateNumFormatToObject implements Serializable {

//    String format = "YY-MM-dd HH:mm:ss";

    private final static Logger log = LoggerFactory.getLogger(DateNumFormatToObject.class);

    /**
     * 获取 num 数量的 times
     *
     * @param num    num前 times数量
     * @param times  时间类型 0秒,1分,2时,3天,4周,5月,6年
     * @param format 时间格式化方式 (HH:mm)
     * @return List<Map < String, Object>>
     */
    public static List<Map<String, Object>> dateNumFormatListMap(int num, int times, String format) {
        log.info("dateNumFormatListMap() 时间Map 调用", times, num, format);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        ChronoUnit unit = Arrays.asList(ChronoUnit.SECONDS, ChronoUnit.MINUTES, ChronoUnit.HOURS, ChronoUnit.DAYS, ChronoUnit.WEEKS, ChronoUnit.MONTHS, ChronoUnit.YEARS).get(times);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime endTime = LocalDateTime.now().withNano(0);
        Instant instantEnd = endTime.toInstant(ZoneOffset.of("+8"));
        //开始时间固定时间
        LocalDateTime startTime = endTime.minus(num, unit);
        LocalDateTime nextTime = startTime;
        Instant instantNext;
        while (true) {
            instantNext = nextTime.toInstant(ZoneOffset.of("+8"));
            if (instantNext.toEpochMilli() > instantEnd.toEpochMilli()) {
                break;
            }
            map = new LinkedHashMap<>();
            map.put("name", formatter.format(nextTime));
            map.put("value", 0);
            list.add(map);
            if (0 == times) {
                nextTime = nextTime.plusSeconds(1);
            } else if (1 == times) {
                nextTime = nextTime.plusMinutes(1);
            } else if (2 == times) {
                nextTime = nextTime.plusHours(1);
            } else if (3 == times) {
                nextTime = nextTime.plusDays(1);
            } else if (4 == times) {
                nextTime = nextTime.plusWeeks(1);
            } else if (5 == times) {
                nextTime = nextTime.plusMonths(1);
            } else if (6 == times) {
                nextTime = nextTime.plusYears(1);
            }
        }
        return list;
    }

    /**
     * 获取 num 数量的 times
     *
     * @param num    数量
     * @param times  时间类型 0秒,1分,2时,3天,4周,5月,6年
     * @param format 时间格式化方式 (HH:mm)
     * @return Map < String, Object>
     */
    public static Map<String, Object> dateNumFormatMap(int num, int times, String format) {
        log.info("dateNumFormatMap() 时间Map 调用", times, num, format);
        Map<String, Object> map = new LinkedHashMap<>();
        ChronoUnit unit = Arrays.asList(ChronoUnit.SECONDS, ChronoUnit.MINUTES, ChronoUnit.HOURS, ChronoUnit.DAYS, ChronoUnit.WEEKS, ChronoUnit.MONTHS, ChronoUnit.YEARS).get(times);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime endTime = LocalDateTime.now().withNano(0);
        Instant instantEnd = endTime.toInstant(ZoneOffset.of("+8"));
        //开始时间固定时间
        LocalDateTime startTime = endTime.minus(num, unit);
        LocalDateTime nextTime = startTime;
        Instant instantNext;
        while (true) {
            instantNext = nextTime.toInstant(ZoneOffset.of("+8"));
            if (instantNext.toEpochMilli() > instantEnd.toEpochMilli()) {
                break;
            }
            map.put(formatter.format(nextTime), 0);
            if (0 == times) {
                nextTime = nextTime.plusSeconds(1);
            } else if (1 == times) {
                nextTime = nextTime.plusMinutes(1);
            } else if (2 == times) {
                nextTime = nextTime.plusHours(1);
            } else if (3 == times) {
                nextTime = nextTime.plusDays(1);
            } else if (4 == times) {
                nextTime = nextTime.plusWeeks(1);
            } else if (5 == times) {
                nextTime = nextTime.plusMonths(1);
            } else if (6 == times) {
                nextTime = nextTime.plusYears(1);
            }
        }
        return map;
    }

    /**
     * 获取 num 数量的 times
     *
     * @param num   num前 times数量
     * @param times 时间类型 0秒,1分,2时,3天,4周,5月,6年
     * @param gap   返回值前后间隔时间数量
     * @return List<Map < String, Object>>
     */
    public static List<Map<String, Object>> dateNumListMap(int num, int times, int gap) {
        log.info("dateNumFormatListMap() 时间Map 调用", times, num);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        ChronoUnit unit = Arrays.asList(ChronoUnit.SECONDS, ChronoUnit.MINUTES, ChronoUnit.HOURS, ChronoUnit.DAYS, ChronoUnit.WEEKS, ChronoUnit.MONTHS, ChronoUnit.YEARS).get(times);
        LocalDateTime endTime = LocalDateTime.now().withNano(0);
        Instant instantEnd = endTime.toInstant(ZoneOffset.of("+8"));
        //开始时间固定时间
        LocalDateTime startTime = endTime.minus(num, unit)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        LocalDateTime nextTime = startTime;
        Instant instantNext;
        while (true) {
            instantNext = nextTime.toInstant(ZoneOffset.of("+8"));
            if (instantNext.toEpochMilli() > instantEnd.toEpochMilli()) {
                break;
            }
            map = new LinkedHashMap<>();
            map.put("name", nextTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
            map.put("value", 0);
            list.add(map);
            if (0 == times) {
                nextTime = nextTime.plusSeconds(gap);
            } else if (1 == times) {
                nextTime = nextTime.plusMinutes(gap);
            } else if (2 == times) {
                nextTime = nextTime.plusHours(gap);
            } else if (3 == times) {
                nextTime = nextTime.plusDays(gap);
            } else if (4 == times) {
                nextTime = nextTime.plusWeeks(gap);
            } else if (5 == times) {
                nextTime = nextTime.plusMonths(gap);
            } else if (6 == times) {
                nextTime = nextTime.plusYears(gap);
            }
        }
        return list;
    }

    /**
     * 每小时的值
     *
     * @param start 开始时间
     * @param stop  结束时间
     * @return
     */
    public static List<Map<String, Object>> dayHostToList(LocalDateTime start, LocalDateTime stop) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-HH");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH");
        //开始时间固定时间
        LocalDateTime startTime = start;
        Instant instantEnd = stop.toInstant(ZoneOffset.of("+8"));
        LocalDateTime nextTime = startTime;
        Instant instantNext;
        while (true) {
            instantNext = nextTime.toInstant(ZoneOffset.of("+8"));
            if (instantNext.toEpochMilli() > instantEnd.toEpochMilli()) {
                break;
            }
            map = new LinkedHashMap<>();
            map.put("week", String.valueOf(nextTime.getDayOfWeek()));
            map.put("time", formatter1.format(nextTime));
            map.put("value", 0);
            map.put("a", formatter.format(nextTime));
            list.add(map);
            nextTime = nextTime.plusHours(1);
        }
        return list;
    }

    /**
     * 获取一天的开始时间
     *
     * @param time
     * @return
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间
     *
     * @param time
     * @return
     */
    public static LocalDateTime getDayStop(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }
}
