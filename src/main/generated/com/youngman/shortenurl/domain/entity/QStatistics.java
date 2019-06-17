package com.youngman.shortenurl.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStatistics is a Querydsl query type for Statistics
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatistics extends EntityPathBase<Statistics> {

    private static final long serialVersionUID = 1934003561L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStatistics statistics = new QStatistics("statistics");

    public final DateTimePath<java.time.LocalDateTime> accessTime = createDateTime("accessTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QShorten shorten;

    public QStatistics(String variable) {
        this(Statistics.class, forVariable(variable), INITS);
    }

    public QStatistics(Path<? extends Statistics> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStatistics(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStatistics(PathMetadata metadata, PathInits inits) {
        this(Statistics.class, metadata, inits);
    }

    public QStatistics(Class<? extends Statistics> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shorten = inits.isInitialized("shorten") ? new QShorten(forProperty("shorten")) : null;
    }

}

