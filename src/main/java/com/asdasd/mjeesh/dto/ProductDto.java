package com.asdasd.mjeesh.dto;

import com.asdasd.mjeesh.model.Contact;
import com.asdasd.mjeesh.model.Producer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ProductDto(Long id,
                         String title,
                         BigDecimal cost,
                         LocalDate shelfLife,
                         Producer producer) {

}
