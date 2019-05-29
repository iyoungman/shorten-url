package com.youngman.shortenurl.service.statistics;

import com.youngman.shortenurl.exception.UserDefineException;
import com.youngman.shortenurl.model.dto.StatisticsTempDto;
import com.youngman.shortenurl.model.dto.StatisticsResponseDto;
import com.youngman.shortenurl.model.enums.Unit;
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


	public List<StatisticsResponseDto> fetchStatisticsByShortenUrl(String shortenUrl, Unit unit) {

		try {
			List<StatisticsTempDto> statisticsTempDtos = statisticsRepository.
					fetchStatisticsByShortenUrl(shortenUrlToRandomString(shortenUrl), unit);

			return statisticsTempDtos.stream()
					.map(dto -> StatisticsResponseDto.of(dto, unit))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw UserDefineException.builder()
					.message("통계 조회 실패")
					.originalErrorMessage(e.toString())
					.build();
		}
	}

	private String shortenUrlToRandomString(String shortenUrl) {
		shortenUrl = removeLastSlash(shortenUrl);
		return StringUtils.right(shortenUrl, 10);
	}

	private String removeLastSlash(String shortenUrl) {
		return StringUtils.removeEnd(shortenUrl, "/");
	}

}
