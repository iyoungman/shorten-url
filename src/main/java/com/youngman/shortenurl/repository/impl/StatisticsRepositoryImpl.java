package com.youngman.shortenurl.repository.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.shortenurl.model.Statistics;
import com.youngman.shortenurl.model.dto.StatisticsTempDto;
import com.youngman.shortenurl.model.enums.Unit;
import com.youngman.shortenurl.repository.custom.StatisticsRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.youngman.shortenurl.model.QStatistics.statistics;
import static com.youngman.shortenurl.model.QShorten.shorten;

/**
 * Created by YoungMan on 2019-05-29.
 */

public class StatisticsRepositoryImpl extends QuerydslRepositorySupport implements StatisticsRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public StatisticsRepositoryImpl() {
		super(Statistics.class);
	}


	@Override
	public List<StatisticsTempDto> fetchStatisticsByShortenUrl(String shortenUrl, Unit unit) {

		JPAQuery<StatisticsTempDto> jpaQuery = new JPAQuery<>(entityManager);

		jpaQuery = jpaQuery.select(Projections.constructor(StatisticsTempDto.class,
				statistics.accessTime, statistics.count())
		)
				.from(statistics)
				.innerJoin(statistics.shorten, shorten)
				.where(eqShortenUrl(shortenUrl));

		jpaQuery = groupByUnit(jpaQuery, unit).orderBy(statistics.accessTime.desc());

		return jpaQuery.fetch();
	}

	private BooleanExpression eqShortenUrl(String shortenUrl) {
		if (StringUtils.isEmpty(shortenUrl)) {
			return null;
		}
		return shorten.randomString.eq(shortenUrl);
	}

	private JPAQuery<StatisticsTempDto> groupByUnit(JPAQuery<StatisticsTempDto> jpaQuery, Unit unit) {
		if (unit.equals(Unit.month)) {
			return jpaQuery.groupBy(statistics.accessTime.year(), statistics.accessTime.month());
		}

		if (unit.equals(Unit.day)) {
			return jpaQuery.groupBy(statistics.accessTime.year(), statistics.accessTime.month(),
					statistics.accessTime.dayOfMonth());
		}

		if (unit.equals(Unit.hour)) {
			return jpaQuery.groupBy(statistics.accessTime.year(), statistics.accessTime.month(),
					statistics.accessTime.dayOfMonth(), statistics.accessTime.hour());
		}
		return null;
	}


}
