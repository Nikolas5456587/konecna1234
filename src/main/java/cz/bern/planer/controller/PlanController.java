package cz.bern.planer.controller;

import cz.bern.planer.entities.Plan;
import cz.bern.planer.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/")
    public String showPlans(Model model) {
        List<Plan> plans = planRepository.findAll();
        model.addAttribute("plans", plans);
        return "index";
    }

    @PostMapping("/addPlan")
    public String addPlan(@RequestParam String planDescription, @RequestParam String date, @RequestParam String time) {
        LocalDate localDate = LocalDate.parse(date);
        LocalTime localTime = LocalTime.parse(time);
        Plan plan = new Plan(planDescription, localDate, localTime);
        planRepository.save(plan);
        return "redirect:/";
    }}