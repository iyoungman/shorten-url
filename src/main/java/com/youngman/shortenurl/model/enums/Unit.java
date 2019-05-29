package com.youngman.shortenurl.model.enums;


import com.youngman.shortenurl.service.statistics.DateUtils;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Getter
public enum Unit {

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
