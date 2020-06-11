package com.jogsoft.apps.pnr.authservice.controller;

import com.jogsoft.apps.pnr.authservice.config.TokenService;
import com.jogsoft.apps.pnr.authservice.config.UserDetailsServiceImpl;
import com.jogsoft.apps.pnr.authservice.domain.AuthenticationRequest;
import com.jogsoft.apps.pnr.authservice.domain.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public String getInfo(){
        return "Authenticated";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception{
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }catch (BadCredentialsException ex){
            throw new Exception("Bad Credentials :" + request.getUsername(), ex);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = tokenService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @GetMapping("/user")
    public String getUserInfo(){
        return "User Info";
    }

    @GetMapping("/admin")
    public String getAdminInfo(){
        return "Admin Info";
    }
}
