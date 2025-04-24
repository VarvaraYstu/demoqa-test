package ru.vpankova;

public class Building {
    int floorCount = 1;
    String city;
    String region;
    String street;
    String number;
    boolean isResidential;

    Building(String city, String street, String number, boolean isResidential) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.isResidential = isResidential;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        String fullAddress = city;
        if (region != null){
            fullAddress += ", " + region + ", " + street + ", " + number;
        }
        else {
            fullAddress += ", " + street + ", " + number;
        }
        return fullAddress;
    }

    public String buildingType() {
        if (isResidential){
            return "Жилое";
        }
        else {
            return "Не жилое";
        }
    }
}
