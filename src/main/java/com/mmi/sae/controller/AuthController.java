package com.mmi.sae.controller;

import com.mmi.sae.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "mmi2026";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        if (ADMIN_USER.equals(req.username()) && ADMIN_PASS.equals(req.password())) {
            return ResponseEntity.ok(new TokenResponse(jwtService.generateToken(req.username())));
        }
        return ResponseEntity.status(401).body("Identifiants invalides");
    }

    record LoginRequest(String username, String password) {}
    record TokenResponse(String token) {}
}