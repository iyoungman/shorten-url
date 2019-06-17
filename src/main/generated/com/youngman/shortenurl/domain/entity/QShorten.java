package com.youngman.shortenurl.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShorten is a Querydsl query type for Shorten
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShorten extends EntityPathBase<Shorten> {

    private static final long serialVersionUID = 1928682399L;

    public static final QShorten shorten = new QShorten("shorten");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath originalUrl = createString("originalUrl");

    public final StringPath randomString = createString("randomString");

    public final ListPath<Statistics, QStatistics> statistics = this.<Statistics, QStatistics>createList("statistics", Statistics.class, QStatistics.class, PathInits.DIRECT2);

    public QShorten(String variable) {
        super(Shorten.class, forVariable(variable));
    }

    public QShorten(Path<? extends Shorten> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShorten(PathMetadata metadata) {
        super(Shorten.class, metadata);
    }

}

