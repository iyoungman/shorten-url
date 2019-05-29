package com.youngman.shortenurl.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
@Setter
public class ErrorResponseDto {

	private String userDefineErrorMessage;
	private String originalErrorMessage;
	private String requestURL;

	@Builder
	public ErrorResponseDto(String userDefineErrorMessage, String originalErrorMessage, String requestURL) {
		this.userDefineErrorMessage = userDefineErrorMessage;
		this.originalErrorMessage = originalErrorMessage;
		this.requestURL = requestURL;
	}
}