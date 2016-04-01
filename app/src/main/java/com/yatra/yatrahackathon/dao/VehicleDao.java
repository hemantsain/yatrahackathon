package com.yatra.yatrahackathon.dao;

/**
 * Created by ibm_admin on 4/1/2016.
 */
public class VehicleDao {

    private String VendorCode;
    private String AirConditioning;
    private String TransmissionType;
    private String VehicleClass;
    private String Category;
    private String DoorCount;
    private String Location;
    private String Description;
    private String ReturnAtPickup;
    private String VendorLocationKey;
    private VehicleRate vehicleRate;
    private VehicleApproximateRate vehicleApproximateRate;

    public VehicleApproximateRate getVehicleApproximateRate() {
        return vehicleApproximateRate;
    }

    public void setVehicleApproximateRate(VehicleApproximateRate vehicleApproximateRate) {
        this.vehicleApproximateRate = vehicleApproximateRate;
    }

    public String getVendorCode() {
        return VendorCode;
    }

    public void setVendorCode(String vendorCode) {
        VendorCode = vendorCode;
    }

    public String getAirConditioning() {
        return AirConditioning;
    }

    public void setAirConditioning(String airConditioning) {
        AirConditioning = airConditioning;
    }

    public String getTransmissionType() {
        return TransmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        TransmissionType = transmissionType;
    }

    public String getVehicleClass() {
        return VehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        VehicleClass = vehicleClass;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDoorCount() {
        return DoorCount;
    }

    public void setDoorCount(String doorCount) {
        DoorCount = doorCount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getReturnAtPickup() {
        return ReturnAtPickup;
    }

    public void setReturnAtPickup(String returnAtPickup) {
        ReturnAtPickup = returnAtPickup;
    }

    public String getVendorLocationKey() {
        return VendorLocationKey;
    }

    public void setVendorLocationKey(String vendorLocationKey) {
        VendorLocationKey = vendorLocationKey;
    }

    public VehicleRate getVehicleRate() {
        return vehicleRate;
    }

    public void setVehicleRate(VehicleRate vehicleRate) {
        this.vehicleRate = vehicleRate;
    }
}
