package ru.aprazdnikov.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateResult {
    private Float amount;
    private Float pereplata;
    private Float payments;

    public Float getAmount() { return amount; }
    public void setAmount(Float value) { this.amount = value; }

    public Float getPereplata() { return pereplata; }
    public void setPereplata(Float value) { this.pereplata = value; }

    public Float getPayments() { return payments; }
    public void setPayments(Float value) { this.payments = value; }

}
