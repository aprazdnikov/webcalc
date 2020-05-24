package ru.aprazdnikov.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aprazdnikov.api.model.CalculateData;
import ru.aprazdnikov.api.model.CalculateResult;
import ru.aprazdnikov.webcalc.calculate.GetPayments;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/calc")
    public CalculateResult getCalculateDate(@RequestBody CalculateData body) {
        CalculateResult result = null;

        if (body != null) {
            GetPayments payments = new GetPayments(body);
            result = payments.getResult();
        }

        return result;
    }
}