package cz.bern.planer.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cz.bern.planer.service.MemberNotFoundException;
import cz.bern.planer.service.MemberService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/member/{id}")
public class MemberController {

    protected final MemberService memberService;

    /**
     * Constructor.
     *
     * @param memberService {@link MemberService}
     */
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PreAuthorize("@securityService.isOwner(#id)")
    @GetMapping("/index")
    public String listFriends(@PathVariable long id, Model model) {
        final var member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "index";
    }






}
