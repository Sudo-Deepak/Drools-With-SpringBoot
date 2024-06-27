package com.deepak.droolsdemo.controller;

import com.deepak.droolsdemo.dto.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private final KieContainer kieContainer;

    public Controller(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @PostMapping("/get-discount")
    public ResponseEntity<Response> getDiscount(@RequestBody OrderRequest orderRequest) {
        List<User> users = new ArrayList<>();
        users.add(new User(101, 40509999, "D", new Date()));
        users.add(new User(103, 9999, "Test Passed", new Date()));
        users.add(new User(104, 940958340, "I", new Date()));
        users.add(new User(100, 939873200, "D", new Date()));
        users.add(new User(99, 439873200, "D", new Date()));
        Response response = new Response();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("res", response);
        User user = new User(100, 500, "I", new Date());
        Xyz xyz = new Xyz();
        xyz.setUsers(users);
        kieSession.insert(xyz);
        kieSession.insert(user);
        kieSession.fireAllRules();
        response = (Response) kieSession.getGlobal("res");
        System.out.println(response);
        kieSession.dispose();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
