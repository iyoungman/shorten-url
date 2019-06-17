package com.youngman.shortenurl.repository;

import com.youngman.shortenurl.domain.dto.StatisticsTemp;
import com.youngman.shortenurl.domain.enums.UnitType;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-29.
 */

public interface StatisticsRepositoryCustom {

	List<StatisticsTemp> fetchStatisticsByShortenUrl(String shortenUrl, UnitType unitType);
}
