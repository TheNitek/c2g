package de.naeveke.c2g;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.naeveke.c2g.mapping.CoordinateConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Vehicle {

    private String address;

    @JsonProperty("name")
    private String plate;

    private String vin;

    private EngineType engineType;

    private boolean charging = false;

    private Cleanliness interior;

    private Cleanliness exterior;

    private boolean smartPhoneRequired;

    private int fuel;

    @JsonDeserialize(converter = CoordinateConverter.class)
    @JsonProperty("coordinates")
    private Coordinates position;

    public String getAddress() {
        return address;
    }

    public String getPlate() {
        return plate;
    }

    public String getVin() {
        return vin;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public boolean isCharging() {
        return charging;
    }

    public Cleanliness getInterior() {
        return interior;
    }

    public Cleanliness getExterior() {
        return exterior;
    }

    public boolean isSmartPhoneRequired() {
        return smartPhoneRequired;
    }

    public int getFuel() {
        return fuel;
    }

    public Coordinates getPosition() {
        return position;
    }

    public enum EngineType {

        CE, ED;

    }

    public enum Cleanliness {

        GOOD, UNACCEPTABLE;

    }

}
