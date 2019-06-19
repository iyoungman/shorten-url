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
 * 단축 URL 을 Original UTL 로 리다이렉팅시 사용
 */

@Service
@RequiredArgsConstructor
public class ShortenUrlFetchService {

	private final ShortenRepository shortenRepository;
	private final StatisticsRepository statisticsRepository;


	/**
	 * 리다이렉팅을 위해 단축 URL 의 randomString 으로부터 기존 URL 조회
	 */
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


	/**
	 * 리다이렉팅시 접속 정보 저장
	 */
	private void saveStatistics(Shorten shorten) {
		statisticsRepository.save(
				Statistics.of(shorten)
		);
	}


}
