package com.rest.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Redirect to the swagger page.
 */
@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "redirect:http://localhost:8080/swagger-ui/index.html";
    }
}
