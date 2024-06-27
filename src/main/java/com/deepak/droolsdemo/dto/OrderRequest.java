package com.deepak.droolsdemo.dto;

import com.deepak.droolsdemo.enums.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {
    private String customerNumber;
    private Integer age;
    private Integer amount;
    private CustomerType customerType;
}
