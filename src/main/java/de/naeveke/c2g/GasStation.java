package de.naeveke.c2g;

import de.naeveke.c2g.mapping.CoordinateConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class GasStation {
    
    @JsonDeserialize(converter = CoordinateConverter.class)
    private Coordinates coordinates;
    
    private String name;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

}
