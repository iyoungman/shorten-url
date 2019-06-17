package com.youngman.shortenurl.domain.dto;

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
public class StatisticsTemp {

	private LocalDateTime date;
	private Long clicks;


	@Builder
	public StatisticsTemp(LocalDateTime date, long clicks) {
		this.date = date;
		this.clicks = clicks;
	}

	public static StatisticsTemp of(LocalDateTime date, long clicks) {
		return StatisticsTemp.builder()
				.date(date)
				.clicks(clicks)
				.build();
	}


}
