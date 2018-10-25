package com.example.demo.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableResourceServer
@EnableAuthorizationServer
public class Oauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Application.class, args);
    }

    @RequestMapping("/user")
    public Map<String,Object> getUsers(OAuth2Authentication authentication){
        Map<String,Object> map = new HashMap<>();
        map.put("user",authentication.getUserAuthentication().getPrincipal()) ;
        map.put("authories", AuthorityUtils.authorityListToSet(authentication.getUserAuthentication().getAuthorities()));
        return map;
    }
}
