package edu.diplom.diplom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;


@Entity
public class Zakaz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long Number_of_order;
    private String Status;

    private Time time_to_order;

    public Zakaz() {
    }

    private Integer amount;

    public Zakaz(Long number_of_order, String status, Time time_to_order, Integer amount, Double sum) {
        Number_of_order = number_of_order;
        Status = status;
        this.time_to_order = time_to_order;
        this.amount = amount;
        this.sum = sum;
    }

    private Double sum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber_of_order() {
        return Number_of_order;
    }

    public void setNumber_of_order(Long number_of_order) {
        Number_of_order = number_of_order;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Time getTime_to_order() {
        return time_to_order;
    }

    public void setTime_to_order(Time time_to_order) {
        this.time_to_order = time_to_order;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
