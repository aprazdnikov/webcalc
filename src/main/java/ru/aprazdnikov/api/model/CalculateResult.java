package ru.aprazdnikov.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateResult {
    private String amount;
    private String percent;
    private String payments;

    public String getAmount() { return amount; }
    public void setAmount(String value) { this.amount = value; }

    public String getPercent() { return percent; }
    public void setPercent(String value) { this.percent = value; }

    public String getPayments() { return payments; }
    public void setPayments(String value) { this.payments = value; }

}
