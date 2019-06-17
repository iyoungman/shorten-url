package com.youngman.shortenurl.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortenUrlCreateRequest {

	private String originalUrl;


	@Builder
	public ShortenUrlCreateRequest(String originalUrl) {
		this.originalUrl = originalUrl;
	}
}
