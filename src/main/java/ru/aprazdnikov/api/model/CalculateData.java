package ru.aprazdnikov.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateData {
    private Integer sum;
    private String type;
    private Float percent;
    private Integer date;

    public Integer getSum() { return sum; }
    public void setSum(Integer value) { this.sum = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public Float getPercent() { return percent; }
    public void setPercent(Float value) { this.percent = value; }

    public Integer getDate() { return date; }
    public void setDate(Integer value) { this.date = value; }
}