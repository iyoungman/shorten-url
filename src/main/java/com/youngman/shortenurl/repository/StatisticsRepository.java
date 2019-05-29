package com.youngman.shortenurl.repository;

import com.youngman.shortenurl.model.Statistics;
import com.youngman.shortenurl.repository.custom.StatisticsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-27.
 */

public interface StatisticsRepository extends JpaRepository<Statistics, Long>, StatisticsRepositoryCustom {
}
