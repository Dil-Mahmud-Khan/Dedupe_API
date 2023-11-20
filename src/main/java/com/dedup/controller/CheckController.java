package com.dedup.controller;

import com.dedup.exception.DuplicateUserException;
import com.dedup.model.UserInfo;
import com.dedup.response.dedupeResponse;
import com.dedup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserInfo userInfo) {
        try {
            UserInfo use = userService.addUser(userInfo);
            dedupeResponse response = new dedupeResponse("User Added", false);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (DuplicateUserException e) {
            dedupeResponse response = new dedupeResponse("Duplicate User", true);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
}
