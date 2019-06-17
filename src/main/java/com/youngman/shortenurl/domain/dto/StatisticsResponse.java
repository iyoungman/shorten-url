package com.youngman.shortenurl.domain.dto;

import com.youngman.shortenurl.domain.enums.UnitType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResponse {

	private String date;
	private Long clicks;


	@Builder
	public StatisticsResponse(String date, long clicks) {
		this.date = date;
		this.clicks = clicks;
	}

	public static StatisticsResponse of(StatisticsTemp statisticsTemp, UnitType unitType) {
		return StatisticsResponse.builder()
				.date(unitType.convertLocalDateTimeToStr(statisticsTemp.getDate()))
				.clicks(statisticsTemp.getClicks())
				.build();
	}
}
