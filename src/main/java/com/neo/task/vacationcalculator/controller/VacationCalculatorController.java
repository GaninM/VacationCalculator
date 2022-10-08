package com.neo.task.vacationcalculator.controller;

import com.neo.task.vacationcalculator.model.Vacation;
import com.neo.task.vacationcalculator.service.VacationCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping("/calculate")
    public String calculate(@ModelAttribute Vacation vacation, Model model) {
        model.addAttribute("vacation", vacation);
        vacation.setVacationPay(vacationCalculatorService.calculateVacationPay(vacation.getVacationsDays(),
                vacation.getAverageSalary()));
        return "calculate";
    }

}
