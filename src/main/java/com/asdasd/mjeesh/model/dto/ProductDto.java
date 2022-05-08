package com.asdasd.mjeesh.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductDto(Long id,
                         String title,
                         BigDecimal cost,
                         LocalDate shelfLife,
                         ProducerDto producer) {

}
