package com.youngman.shortenurl.service.statistics;

import com.youngman.shortenurl.exception.UserDefineException;
import com.youngman.shortenurl.domain.dto.StatisticsTemp;
import com.youngman.shortenurl.domain.dto.StatisticsResponse;
import com.youngman.shortenurl.domain.enums.UnitType;
import com.youngman.shortenurl.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YoungMan on 2019-05-29.
 */

@Service
@RequiredArgsConstructor
public class StatisticsFetchService {

	private final StatisticsRepository statisticsRepository;


	/**
	 * 단축 URL 과 UnitType Enum 값을 통해 접속 통계정보 조회
	 */
	public List<StatisticsResponse> fetchStatisticsByShortenUrl(String shortenUrl, UnitType unitType) {

		try {
			List<StatisticsTemp> statisticsTemps = statisticsRepository.
					fetchStatisticsByShortenUrl(shortenUrlToRandomString(shortenUrl), unitType);

			return statisticsTemps.stream()
					.map(dto -> StatisticsResponse.of(dto, unitType))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw UserDefineException.builder()
					.message("통계 조회 실패")
					.originalErrorMessage(e.toString())
					.build();
		}
	}


	/**
	 * DB 에서 통계정보를 가져오기 위해 단축 URL 을 랜덤스트링으로 변환
	 */
	private String shortenUrlToRandomString(String shortenUrl) {
		shortenUrl = removeLastSlash(shortenUrl);
		return StringUtils.right(shortenUrl, 10);
	}


	private String removeLastSlash(String shortenUrl) {
		return StringUtils.removeEnd(shortenUrl, "/");
	}

}
