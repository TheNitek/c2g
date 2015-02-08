package de.naeveke.c2g;

import de.naeveke.c2g.mapping.PolygonConverter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public class Area {

    @JsonProperty("zoneType")
    private Type type;

    @JsonProperty("coordinates")
    @JsonDeserialize(converter = PolygonConverter.class)
    private List<Coordinates> outline;

    private String name;

    public Type getType() {
        return type;
    }

    public List<Coordinates> getOutline() {
        return outline;
    }

    public String getName() {
        return name;
    }

    public enum Type {

        INCLUDED, EXCLUDED, PARKING;

        @JsonCreator
        public static Type newInstance(String key) {
            return Type.valueOf(key.toUpperCase());
        }
    }

}
