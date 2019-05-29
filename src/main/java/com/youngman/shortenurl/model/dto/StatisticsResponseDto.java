package com.youngman.shortenurl.model.dto;

import com.youngman.shortenurl.model.enums.Unit;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsResponseDto {

	private String date;
	private Long clicks;

	@Builder
	public StatisticsResponseDto(String date, long clicks) {
		this.date = date;
		this.clicks = clicks;
	}

	public static StatisticsResponseDto of(StatisticsTempDto statisticsTempDto, Unit unit) {
		return StatisticsResponseDto.builder()
				.date(unit.convertLocalDateTimeToStr(statisticsTempDto.getDate()))
				.clicks(statisticsTempDto.getClicks())
				.build();
	}
}
