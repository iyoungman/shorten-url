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

	private String removeLastSlash(String originalUrl) {
		return StringUtils.removeEnd(originalUrl, "/");
	}

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
