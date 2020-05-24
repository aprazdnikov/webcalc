package ru.aprazdnikov.webcalc.calculate;

import ru.aprazdnikov.api.model.CalculateData;
import ru.aprazdnikov.api.model.CalculateResult;

public class GetPayments {
    private Integer amount;
    private Float percent;
    private Integer months;
    private String type;

    public GetPayments(CalculateData data) {
        this.amount = data.getSum();
        this.percent = data.getPercent();
        this.months = data.getDate();
        this.type = data.getType();
    }

    public CalculateResult getAnnuityPayment() {
        CalculateResult result = new CalculateResult();



        return result;
    }

    public CalculateResult getDifferentiatedPayment() {
        CalculateResult result = new CalculateResult();



        return result;
    }

    public CalculateResult getResult() {
        CalculateResult result = null;

        switch (type) {
            case "1":
                result =  getAnnuityPayment(); break;
            case "2":
                result = getDifferentiatedPayment(); break;
        }

        return result;
    }
}
