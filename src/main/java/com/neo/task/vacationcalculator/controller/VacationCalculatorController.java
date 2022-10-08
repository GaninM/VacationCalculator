package com.neo.task.vacationcalculator.controller;

import com.neo.task.vacationcalculator.model.Vacation;
import com.neo.task.vacationcalculator.service.VacationCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculate")
    public String calculate(Model model) {
        model.addAttribute("vacation", new Vacation());
        return "calculate";
    }

    @PostMapping("/calculate")
    public String showResult(@ModelAttribute Vacation vacation, Model model) {
        vacation.setVacationPay(vacationCalculatorService.calculateVacationPay(vacation.getVacationsDays(), vacation.getAverageSalary()));
        model.addAttribute("vacation", vacation);
        return "/result";
    }

}
