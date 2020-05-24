package ru.aprazdnikov.webcalc.calculate;

import ru.aprazdnikov.api.model.CalculateData;
import ru.aprazdnikov.api.model.CalculateResult;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GetPayments {
    private final Float amount;
    private final Float percent;
    private final Float months;
    private final String type;

    private final DecimalFormat f = new DecimalFormat("##.00");

    public GetPayments(CalculateData data) {
        this.amount = data.getSum().floatValue();
        this.percent = data.getPercent();
        this.months = data.getDate().floatValue();
        this.type = data.getType();
    }

    public CalculateResult getAnnuityPayment() {
        CalculateResult result = new CalculateResult();

        // Пример расчёта ежемесячного платежа:
        // T = 6 мес.; Кр = $10 000; Ст = 15% годовых/ 12 мес. = 0.0125
        // Пл = 10 000 * 0.0125 / (1 - 1/ (1.0125)^6) = 125 / 0.071825 = $1740
        // ПКр = 1740*6 - 10 000 = $440
        //
        // Пример расчёта суммы кредита:
        // Т = 6 мес.; Пл = $500; Ст = 15% годовых/ 12 мес. = 0.0125
        // Кр = 500 * 0.071825 / 0.0125 = $2873

        Float sT = percent / 100 / 12;
        float sT_m = (float)Math.pow(1+sT, months);

        Float payment = (amount * sT) / (1 - 1 / sT_m);
        Float totalPercent = payment * months - amount;
        float totalAmount = amount + totalPercent;

        result.setPayments(f.format(payment));
        result.setPercent(f.format(totalPercent));
        result.setAmount(f.format(totalAmount));

        return result;
    }

    public CalculateResult getDifferentiatedPayment() {
        CalculateResult result = new CalculateResult();

        // ПКр = Кр*Ст *(Т + 1) / 2
        //
        // Плi = Кр / T + Кр*(T-i+1)*Ст / Т
        //
        // Пример расчёта платежей и суммы процентов, выплаченных за период:
        // Т = 6 мес.; Кр = $10 000; Ст = 15% годовых/ 12 мес. = 0.0125
        // ПКр = 10000*0.0125*(6+1)/2 = $437,5
        // Пл1 = 10000/6 + 10000*6*0.0125/6 = $1791.7
        // …
        // Пл6 = 10000/6 + 10000*1*0.0125/6 = $1687,5

        Float sT = percent / 100 / 12;
        Float amountPercent = amount * sT * (months+1) / 2;
        Float totalAmount = amount + amountPercent;

        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < months; i++) {
            Float payment = amount / months + amount * (months-i) * sT / months;
            list.add(f.format(payment));
        }

        String res_payment = list.get(0).toString() + "..." + list.get(list.size() - 1).toString();

        result.setPayments(res_payment);
        result.setPercent(f.format(amountPercent));
        result.setAmount(f.format(totalAmount));

        return result;
    }

    public CalculateResult getResult() {
        CalculateResult result = null;

        switch (type) {
            case "1":
                result = getAnnuityPayment(); break;
            case "2":
                result = getDifferentiatedPayment(); break;
        }

        return result;
    }
}
