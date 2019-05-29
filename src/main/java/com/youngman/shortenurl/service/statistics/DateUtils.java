package com.youngman.shortenurl.service.statistics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by YoungMan on 2019-05-29.
 */

public class DateUtils {

	//년 - 월 - 일 - 시간
	public static String convertToHour(LocalDateTime time) {
		return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH"));
	}

	//년 - 월  - 일
	public static String convertToDay(LocalDateTime time) {
		return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	//년 - 월
	public static String convertToMonth(LocalDateTime time) {
		return time.format(DateTimeFormatter.ofPattern("yyyy-MM"));
	}
}
