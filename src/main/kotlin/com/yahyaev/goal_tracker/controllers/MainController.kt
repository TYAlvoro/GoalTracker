package com.yahyaev.goal_tracker.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MainController {

    @GetMapping("/")
    @ResponseBody
    fun home(): String {
        return ""
    }
}
