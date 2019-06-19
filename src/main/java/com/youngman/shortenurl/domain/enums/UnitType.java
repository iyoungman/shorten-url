package com.youngman.shortenurl.domain.enums;


import com.youngman.shortenurl.service.statistics.DateUtils;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-27.
 * 시간별, 날짜별, 월별 ENUM 클래스
 */

@Getter
public enum UnitType {

	hour {
		public String convertLocalDateTimeToStr(LocalDateTime time) {
			return DateUtils.convertToHour(time);
		}
	},
	day {
		public String convertLocalDateTimeToStr(LocalDateTime time) {
			return DateUtils.convertToDay(time);
		}
	},
	month {
		public String convertLocalDateTimeToStr(LocalDateTime time) {
			return DateUtils.convertToMonth(time);
		}
	};

	public abstract String convertLocalDateTimeToStr(LocalDateTime time);
}
