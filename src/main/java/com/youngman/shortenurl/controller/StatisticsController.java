package com.youngman.shortenurl.controller;

import com.youngman.shortenurl.domain.dto.StatisticsResponse;
import com.youngman.shortenurl.domain.enums.UnitType;
import com.youngman.shortenurl.service.statistics.StatisticsFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-29.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

	private final StatisticsFetchService statisticsFetchService;


	@GetMapping
	public List<StatisticsResponse> fetchStatisticsByShortenUrl(@RequestParam("shortenUrl") String shortenUrl,
																@RequestParam("unitType") UnitType unitType) {
		return statisticsFetchService.fetchStatisticsByShortenUrl(shortenUrl, unitType);
	}
}
