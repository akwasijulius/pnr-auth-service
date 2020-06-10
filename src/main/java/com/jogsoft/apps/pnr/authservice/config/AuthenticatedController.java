package com.jogsoft.apps.pnr.authservice.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatedController {

    @GetMapping("/")
    public String getInfo(){
        return "Authenticated";
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
