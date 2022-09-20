package com.eldery.crm.controller;

import com.eldery.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/find")
    public ResponseEntity<List<Map<String, String>>> findUserByParams (@RequestBody Map<String, String> allParams) {
        List<Map<String, String>> list = new LinkedList<>();
        userService.search(allParams.get("person"))
                .forEach(x -> list.add(x.getSimple()));
        return ResponseEntity.ok(list);
    }
}
