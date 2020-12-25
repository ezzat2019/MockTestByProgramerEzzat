package com.example.mocktestbyprogramerezzat.data.model;

public class RandomTestModel {
    private double RSRP, RSRQ, SINR;

    public RandomTestModel() {
    }

    public RandomTestModel(double RSRP, double RSRQ, double SINR) {
        this.RSRP = RSRP;
        this.RSRQ = RSRQ;
        this.SINR = SINR;
    }

    @Override
    public String toString() {
        return "RandomTestModel{" +
                "RSRP=" + RSRP +
                ", RSRQ=" + RSRQ +
                ", SINR=" + SINR +
                '}';
    }

    public double getRSRP() {
        return RSRP;
    }

    public void setRSRP(double RSRP) {
        this.RSRP = RSRP;
    }

    public double getRSRQ() {
        return RSRQ;
    }

    public void setRSRQ(double RSRQ) {
        this.RSRQ = RSRQ;
    }

    public double getSINR() {
        return SINR;
    }

    public void setSINR(double SINR) {
        this.SINR = SINR;
    }
}
