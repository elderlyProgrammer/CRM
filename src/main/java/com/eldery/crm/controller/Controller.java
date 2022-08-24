package com.eldery.crm.controller;

import com.eldery.crm.jwt.JwtAuthentication;
import com.eldery.crm.model.User;
import com.eldery.crm.service.AuthService;
import com.eldery.crm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Controller {

    private final AuthService authService;
    private final UserService userService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }


    @GetMapping("profile/{userName}")
    public ResponseEntity<User> getUserProfile(@PathVariable(name = "userName") String userName) {
        User user;
        final JwtAuthentication authInfo = authService.getAuthInfo();
        user = userService.getByLogin(authInfo.getUsername());
        return ResponseEntity.ok(user);
    }

}
