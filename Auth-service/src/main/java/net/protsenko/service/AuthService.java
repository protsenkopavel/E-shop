package net.protsenko.service;

import net.protsenko.web.dto.auth.JwtRequest;
import net.protsenko.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);

}
