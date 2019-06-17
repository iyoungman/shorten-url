package com.youngman.shortenurl.service.shorten;

import com.youngman.shortenurl.exception.UserDefineException;
import com.youngman.shortenurl.domain.entity.Shorten;
import com.youngman.shortenurl.domain.entity.Statistics;
import com.youngman.shortenurl.repository.ShortenRepository;
import com.youngman.shortenurl.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by YoungMan on 2019-05-27.
 */

@Service
@RequiredArgsConstructor
public class ShortenUrlFetchService {

	private final ShortenRepository shortenRepository;
	private final StatisticsRepository statisticsRepository;

	public String fetchOriginalUrl(String randomString) {

		try {
			Shorten shorten = findByRandomString(randomString);
			saveStatistics(shorten);
			return shorten.getOriginalUrl();
		} catch (Exception e) {
			throw UserDefineException.builder()
					.message("리다이렉팅 오류")
					.originalErrorMessage(e.toString())
					.build();
		}
	}

	private Shorten findByRandomString(String randomString) {
		return shortenRepository.findByRandomString(randomString).orElseThrow(
				() -> new RuntimeException("존재하지 않는 URL 입니다.")
		);
	}

	private void saveStatistics(Shorten shorten) {
		statisticsRepository.save(
				Statistics.of(shorten)
		);
	}


}
