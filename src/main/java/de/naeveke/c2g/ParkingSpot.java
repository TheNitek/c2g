package de.naeveke.c2g;

import de.naeveke.c2g.mapping.CoordinateConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ParkingSpot {
    
    @JsonDeserialize(converter = CoordinateConverter.class)
    private Coordinates coordinates;

    private String name;
    private int totalCapacity;
    private int usedCapacity;
    private boolean chargingPole;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public boolean isChargingPole() {
        return chargingPole;
    }

}
