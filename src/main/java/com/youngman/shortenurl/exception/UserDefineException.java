package com.youngman.shortenurl.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Getter
public class UserDefineException extends RuntimeException {

	private String originalErrorMessage;


	public UserDefineException(String message) {
		super(message);
	}

	@Builder
	public UserDefineException(String message, String originalErrorMessage) {
		super(message);
		this.originalErrorMessage = originalErrorMessage;
	}

}
