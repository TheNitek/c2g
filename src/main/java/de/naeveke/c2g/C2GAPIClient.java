package de.naeveke.c2g;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.naeveke.c2g.mapping.C2GMapper;
import java.io.IOException;
import java.util.List;

/**
 * Provides the (read-only) API to access car2go OpenAPI data
 * @author Claus Naeveke
 */
public class C2GAPIClient {

    final ObjectMapper mapper;

    final HttpApiClient http;

    /**
     * 
     * @param consumerKey Consumer key as provided by car2go (see
     * https://code.google.com/p/car2go/wiki/oauth#Registration_as_consumer for
     * details)
     */
    public C2GAPIClient(String consumerKey) {
        http = new HttpApiClient(consumerKey);
        mapper = new C2GMapper();
    }

    /**
     * Get a list of active car2go locations (required as input for other calls)
     * @return
     * @throws IOException 
     */
    public List<Location> getLocations() throws IOException {
        String response = http.getLocations();
        LocationRootNode root = mapper.readValue(response, LocationRootNode.class);
        return root.location;
    }

    /**
     * Get a list of all available vehicles in a car2go location
     * @param location car2go location of the vehicles
     * @return
     * @throws IOException 
     */
    public List<Vehicle> getVehicles(String location) throws IOException {
        String response = http.getVehicles(location);
        RootNode<Vehicle> root = mapper.readValue(response, new TypeReference<RootNode<Vehicle>>() {
        });
        return root.placemarks;
    }

    /**
     * Get a list of areas describing the car2go home area
     * @param location
     * @return
     * @throws IOException 
     */
    public List<Area> getOperatingAreas(String location) throws IOException {
        String response = http.getOperatingAreas(location);
        RootNode<Area> root = mapper.readValue(response, new TypeReference<RootNode<Area>>() {
        });
        return root.placemarks;
    }

    /**
     * Get a list of dedicated parking spots
     * @param location
     * @return
     * @throws IOException 
     */
    public List<ParkingSpot> getParkingSpots(String location) throws IOException {
        String response = http.getParkingSpots(location);
        RootNode<ParkingSpot> root = mapper.readValue(response, new TypeReference<RootNode<ParkingSpot>>() {
        });
        return root.placemarks;
    }

    /**
     * Get a list of gas stations that can be used for refueling a car2go
     * (will be empty for same locations, especially in NA)
     * @param location
     * @return
     * @throws IOException 
     */
    public List<GasStation> getGasStations(String location) throws IOException {
        String response = http.getGasstations(location);
        RootNode<GasStation> root = mapper.readValue(response, new TypeReference<RootNode<GasStation>>() {
        });
        return root.placemarks;
    }

    private static class LocationRootNode {

        public List<Location> location;

    }

    private static class RootNode<T> {

        public List<T> placemarks;

    }

}
