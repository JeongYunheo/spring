package com.study.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MyBean332 {
    private String stringCol;
    private Integer intCol;
    private Double decCol;  //  근사치 저장하는 double과 달리 정확한 값 BigDecimal
    private LocalDate dateCol;
    private LocalDateTime dateTimeCol;
}
