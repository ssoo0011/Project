package com.example.yj.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTouristSpot is a Querydsl query type for TouristSpot
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTouristSpot extends EntityPathBase<TouristSpot> {

    private static final long serialVersionUID = -567400843L;

    public static final QTouristSpot touristSpot = new QTouristSpot("touristSpot");

    public final StringPath area = createString("area");

    public final StringPath tourSpot = createString("tourSpot");

    public final NumberPath<Long> visitNum = createNumber("visitNum", Long.class);

    public QTouristSpot(String variable) {
        super(TouristSpot.class, forVariable(variable));
    }

    public QTouristSpot(Path<? extends TouristSpot> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTouristSpot(PathMetadata metadata) {
        super(TouristSpot.class, metadata);
    }

}

