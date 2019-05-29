package com.youngman.shortenurl.controller;

import com.youngman.shortenurl.model.dto.StatisticsResponseDto;
import com.youngman.shortenurl.model.enums.Unit;
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
	public List<StatisticsResponseDto> fetchStatisticsByShortenUrl(@RequestParam("shortenUrl") String shortenUrl,
																   @RequestParam("unit") Unit unit) {

		return statisticsFetchService.fetchStatisticsByShortenUrl(shortenUrl, unit);
	}
}
