package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.AuthentificationDTO;
import com.benjdiya.monoapp.service.CompteService;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class LoginRestController {
    CompteService compteService;

}
