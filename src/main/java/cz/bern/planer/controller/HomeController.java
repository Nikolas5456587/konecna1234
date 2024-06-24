package cz.bern.planer.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cz.bern.planer.service.MemberService;

@Controller
public class HomeController {

    protected final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        final var username = SecurityContextHolder.getContext().getAuthentication().getName();
        final var user = memberService.getMemberByUsername(username);
        return "redirect:/member/" + user.getId() + "/friends";
    }
}