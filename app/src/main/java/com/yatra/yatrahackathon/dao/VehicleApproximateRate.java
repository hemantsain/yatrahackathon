package com.yatra.yatrahackathon.dao;

/**
 * Created by XVTS8308 on 01/04/2016.
 */
public class VehicleApproximateRate {

    private String RateForPeriod;
    private String BaseRate;
    private String EstimatedTotalAmount;
    private String DropOffCharge;
    private String ExtraMileageCharge;

    public String getRateForPeriod() {
        return RateForPeriod;
    }

    public void setRateForPeriod(String rateForPeriod) {
        RateForPeriod = rateForPeriod;
    }

    public String getBaseRate() {
        return BaseRate;
    }

    public void setBaseRate(String baseRate) {
        BaseRate = baseRate;
    }

    public String getEstimatedTotalAmount() {
        return EstimatedTotalAmount;
    }

    public void setEstimatedTotalAmount(String estimatedTotalAmount) {
        EstimatedTotalAmount = estimatedTotalAmount;
    }

    public String getDropOffCharge() {
        return DropOffCharge;
    }

    public void setDropOffCharge(String dropOffCharge) {
        DropOffCharge = dropOffCharge;
    }

    public String getExtraMileageCharge() {
        return ExtraMileageCharge;
    }

    public void setExtraMileageCharge(String extraMileageCharge) {
        ExtraMileageCharge = extraMileageCharge;
    }
}
