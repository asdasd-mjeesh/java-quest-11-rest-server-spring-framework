package com.asdasd.mjeesh.util;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class QPredicates {
    private final List<Predicate> predicates = new ArrayList<>();

    private QPredicates() {  }

    public Predicate buildAnd() {
        return ExpressionUtils.allOf(predicates);
    }

    public <T> QPredicates add(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public static QPredicates builder() {
        return new QPredicates();
    }
}
