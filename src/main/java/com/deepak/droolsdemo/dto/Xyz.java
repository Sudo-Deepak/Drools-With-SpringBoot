package com.deepak.droolsdemo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Xyz {
    private List<User> users;
}
