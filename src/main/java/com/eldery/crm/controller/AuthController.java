package com.eldery.crm.controller;

import com.eldery.crm.exception.AuthException;
import com.eldery.crm.jwt.JwtRequest;
import com.eldery.crm.jwt.JwtResponse;
import com.eldery.crm.jwt.RefreshJwtRequest;
import com.eldery.crm.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody JwtRequest authRequest, HttpServletResponse response) {
        try {
            final JwtResponse token = authService.login(authRequest);
            return ResponseEntity.ok(token);
        } catch (AuthException exception) {
            Map<String, String> map = new HashMap<>();
            map.put("error", "Не верный логин или пароль");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

}
