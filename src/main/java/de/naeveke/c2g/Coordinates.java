package de.naeveke.c2g;

public class Coordinates {

    private final double latitude;
    private final double longitude;
    
    public Coordinates(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(latitude);
        sb.append(", ");
        sb.append(longitude);
        sb.append("]");
        return sb.toString();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
}
