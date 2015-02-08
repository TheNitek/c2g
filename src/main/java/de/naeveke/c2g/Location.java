package de.naeveke.c2g;

import java.util.Locale;
import java.util.TimeZone;

public class Location {

    private final int id;

    private final Locale locale;

    private final String name;

    private final Coordinates center;

    private final Coordinates lowerRight;

    private final Coordinates upperLeft;

    private final TimeZone timezone;
    
    public Location(int id, Locale locale, String name, Coordinates center, Coordinates lowerRight, Coordinates upperLeft, TimeZone timezone){
        this.id = id;
        this.locale = locale;
        this.name = name;
        this.center = center;
        this.lowerRight = lowerRight;
        this.upperLeft = upperLeft;
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCenter() {
        return center;
    }

    public Coordinates getLowerRight() {
        return lowerRight;
    }

    public Coordinates getUpperLeft() {
        return upperLeft;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

}
