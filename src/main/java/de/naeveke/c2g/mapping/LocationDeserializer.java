package de.naeveke.c2g.mapping;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import de.naeveke.c2g.Coordinates;
import de.naeveke.c2g.Location;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;

public class LocationDeserializer extends JsonDeserializer<Location> {

    @Override
    public Location deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("locationId")).numberValue();
        String countryCode = node.get("countryCode").asText();
        String defaultLanguage = node.get("defaultLanguage").asText();
        Locale locale = new Locale.Builder().setLanguage(defaultLanguage).setRegion(countryCode).build();
        String name = node.get("locationName").asText();
        
        JsonNode mapSection = node.get("mapSection");
        
        Coordinates center = new Coordinates(mapSection.get("center").get("latitude").asDouble(), mapSection.get("center").get("longitude").asDouble());
        Coordinates lowerRight = new Coordinates(mapSection.get("lowerRight").get("latitude").asDouble(), mapSection.get("lowerRight").get("longitude").asDouble());
        Coordinates upperLeft = new Coordinates(mapSection.get("upperLeft").get("latitude").asDouble(), mapSection.get("upperLeft").get("longitude").asDouble());
        
        TimeZone timezone = TimeZone.getTimeZone(node.get("timezone").asText());
        
        return new Location(id, locale, name, center, lowerRight, upperLeft, timezone);
    }

}
