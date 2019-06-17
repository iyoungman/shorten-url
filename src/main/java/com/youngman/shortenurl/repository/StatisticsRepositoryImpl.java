package com.youngman.shortenurl.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.youngman.shortenurl.domain.dto.StatisticsTemp;
import com.youngman.shortenurl.domain.entity.Statistics;
import com.youngman.shortenurl.domain.enums.UnitType;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.youngman.shortenurl.domain.entity.QShorten.shorten;
import static com.youngman.shortenurl.domain.entity.QStatistics.statistics;

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
	public List<StatisticsTemp> fetchStatisticsByShortenUrl(String shortenUrl, UnitType unitType) {

		JPAQuery<StatisticsTemp> jpaQuery = new JPAQuery<>(entityManager);

		jpaQuery = jpaQuery.select(Projections.constructor(StatisticsTemp.class,
				statistics.accessTime, statistics.count())
		)
				.from(statistics)
				.innerJoin(statistics.shorten, shorten)
				.where(eqShortenUrl(shortenUrl));

		jpaQuery = groupByUnit(jpaQuery, unitType).orderBy(statistics.accessTime.desc());

		return jpaQuery.fetch();
	}

	private BooleanExpression eqShortenUrl(String shortenUrl) {
		if (StringUtils.isEmpty(shortenUrl)) {
			return null;
		}
		return shorten.randomString.eq(shortenUrl);
	}

	private JPAQuery<StatisticsTemp> groupByUnit(JPAQuery<StatisticsTemp> jpaQuery, UnitType unitType) {
		if (unitType.equals(UnitType.month)) {
			return jpaQuery.groupBy(statistics.accessTime.year(), statistics.accessTime.month());
		}

		if (unitType.equals(UnitType.day)) {
			return jpaQuery.groupBy(statistics.accessTime.year(), statistics.accessTime.month(),
					statistics.accessTime.dayOfMonth());
		}

		if (unitType.equals(UnitType.hour)) {
			return jpaQuery.groupBy(statistics.accessTime.year(), statistics.accessTime.month(),
					statistics.accessTime.dayOfMonth(), statistics.accessTime.hour());
		}

		return jpaQuery;
	}


}
