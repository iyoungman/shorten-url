package com.youngman.shortenurl.repository;

import com.youngman.shortenurl.domain.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-27.
 */

public interface StatisticsRepository extends JpaRepository<Statistics, Long>, StatisticsRepositoryCustom {
}
