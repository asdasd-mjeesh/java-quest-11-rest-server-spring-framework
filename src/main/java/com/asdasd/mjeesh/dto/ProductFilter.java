package com.asdasd.mjeesh.dto;

import java.math.BigDecimal;

public record ProductFilter(String title,
                            String producerName,
                            BigDecimal minCost,
                            BigDecimal maxCost) {
}
