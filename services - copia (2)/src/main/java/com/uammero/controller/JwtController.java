package com.uammero.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uammero.common.ResponseJwt;
import com.uammero.service.JwtService;
import com.uammero.common.RequestJwt;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public ResponseJwt createJwtToken(@RequestBody RequestJwt jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}
