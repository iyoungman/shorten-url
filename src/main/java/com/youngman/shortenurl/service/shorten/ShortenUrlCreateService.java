package com.youngman.shortenurl.service.shorten;

import com.youngman.shortenurl.exception.UserDefineException;
import com.youngman.shortenurl.domain.entity.Shorten;
import com.youngman.shortenurl.repository.ShortenRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Service
@RequiredArgsConstructor
public class ShortenUrlCreateService {

	@Value("${app.path.local}")
	private String DEFAULT_PATH;
	private final ShortenRepository shortenRepository;


	/**
	 * OriginalURL 로 부터 단축 URL 생성
	 */
	public String createShortenUrl(String originalUrl) {

		try {
			String randomString = createRandomString();
			String shortenUrl = DEFAULT_PATH + randomString;

			shortenRepository.save(
					Shorten.of(removeLastSlash(originalUrl), randomString)
			);

			return shortenUrl;
		} catch (Exception e) {
			throw UserDefineException.builder()
					.message("단축 URL 생성 실패")
					.originalErrorMessage(e.toString())
					.build();
		}
	}


	/**
	 * https://eney.co.kr/ 처럼 OriginalURL 마지막에 슬래쉬가 있을 경우 제거
	 */
	private String removeLastSlash(String originalUrl) {
		return StringUtils.removeEnd(originalUrl, "/");
	}


	/**
	 * 랜덤 스트링 생성 함수
	 * Apache 라이브러리 사용
	 * 랜덤 스트링 생성 후 DB를 확인해 기존에 존재하는 랜덤 스트링인지 검사한다
	 */
	private String createRandomString() {

		String randomString = "";

		do {
			randomString = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
		} while (existsByRandomString(randomString));

		return randomString;
	}

	private boolean existsByRandomString(String randomString) {
		return shortenRepository.existsByRandomString(randomString);
	}

}
