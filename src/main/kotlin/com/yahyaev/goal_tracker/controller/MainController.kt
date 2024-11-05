package com.yahyaev.goal_tracker.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("message", "Thymeleaf Hello world!")
        return "main"
    }
}
