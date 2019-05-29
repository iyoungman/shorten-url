package com.youngman.shortenurl.repository.custom;

import com.youngman.shortenurl.model.dto.StatisticsTempDto;
import com.youngman.shortenurl.model.enums.Unit;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-29.
 */

public interface StatisticsRepositoryCustom {

	List<StatisticsTempDto> fetchStatisticsByShortenUrl(String shortenUrl, Unit unit);
}
