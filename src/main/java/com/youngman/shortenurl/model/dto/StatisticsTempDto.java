package com.youngman.shortenurl.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StatisticsTempDto {

	private LocalDateTime date;
	private Long clicks;

	@Builder
	public StatisticsTempDto(LocalDateTime date, long clicks) {
		this.date = date;
		this.clicks = clicks;
	}

	public static StatisticsTempDto of(LocalDateTime date, long clicks) {
		return StatisticsTempDto.builder()
				.date(date)
				.clicks(clicks)
				.build();
	}


}
