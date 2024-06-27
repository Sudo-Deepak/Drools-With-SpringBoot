package com.deepak.droolsdemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    private int invested = 0;
    private String direction = "NA";
}
