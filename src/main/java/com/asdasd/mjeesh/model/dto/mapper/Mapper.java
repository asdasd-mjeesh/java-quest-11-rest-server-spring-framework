package com.asdasd.mjeesh.model.dto.mapper;

import java.util.List;

public interface Mapper<T, F> {

    T map(F fromObject);

    List<T> map(List<F> fromCollection);
}
