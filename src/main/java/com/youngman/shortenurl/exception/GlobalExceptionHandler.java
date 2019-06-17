package com.youngman.shortenurl.exception;

import com.youngman.shortenurl.domain.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * Created by YoungMan on 2019-05-29.
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Autowired
	private UrlPathHelper urlPathHelper;


	@ExceptionHandler(UserDefineException.class)
	public ResponseEntity handleUserDefineException(HttpServletRequest request, UserDefineException e) {
		String requestURL = urlPathHelper.getOriginatingRequestUri(request);

		logger.info("======================================");
		logger.info("예외 발생 시간 : " + LocalDateTime.now());
		logger.info("요청 HTTP 메소드 : " + request.getMethod());
		logger.info("요청 URL : " + requestURL);
		logger.info("클라이언트 : " + request.getRemoteHost());
		logger.info("사용자 정의 에러 메세지 : " + e.getMessage());
		logger.info("원본 에러 메세지 : " + e.getOriginalErrorMessage());
		logger.info("Cause : " + e.getCause());
		logger.info("======================================");

		return new ResponseEntity<>(ErrorResponse.builder()
				.userDefineErrorMessage(e.getMessage())
				.originalErrorMessage(e.getOriginalErrorMessage())
				.requestURL(requestURL)
				.build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(HttpServletRequest request, Exception e) {
		String requestURL = urlPathHelper.getOriginatingRequestUri(request);

		logger.info("======================================");
		logger.info("예외 발생 시간 : " + LocalDateTime.now());
		logger.info("요청 HTTP 메소드 : " + request.getMethod());
		logger.info("요청 URL : " + requestURL);
		logger.info("클라이언트 : " + request.getRemoteHost());
		logger.info("원본 에러 메세지 : " + e.toString());
		logger.info("Cause : " + e.getCause());
		logger.info("======================================");

		return new ResponseEntity<>(ErrorResponse.builder()
				.userDefineErrorMessage("예상치 못한 예외 발생")
				.originalErrorMessage(e.toString())
				.requestURL(requestURL)
				.build(),HttpStatus.BAD_REQUEST);
	}

}
