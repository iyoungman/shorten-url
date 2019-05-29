package com.youngman.shortenurl.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortenUrlCreateRequestDto {

	private String originalUrl;

	@Builder
	public ShortenUrlCreateRequestDto(String originalUrl) {
		this.originalUrl = originalUrl;
	}
}
