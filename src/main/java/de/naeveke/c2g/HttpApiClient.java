package de.naeveke.c2g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpApiClient {

    static final String BASE_URI = "https://www.car2go.com/api/v2.1/";

    private static final String USER_AGENT = "c2g lib";

    private static final String VEHICLE_PATH = "vehicles?loc=%s&oauth_consumer_key=%s&format=json";

    private static final String AREA_PATH = "operationareas?loc=%s&oauth_consumer_key=%s&format=json";

    private static final String LOCATION_PATH = "locations?oauth_consumer_key=%s&format=json";

    private static final String PARKING_PATH = "parkingspots?loc=%s&oauth_consumer_key=%s&format=json";

    private static final String GAS_PATH = "gasstations?loc=%s&oauth_consumer_key=%s&format=json";

    private final String consumerKey;

    public HttpApiClient(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getVehicles(String location) throws IOException {
        return this.get(String.format(VEHICLE_PATH, location, consumerKey));
    }

    public String getOperatingAreas(String location) throws IOException {
        return this.get(String.format(AREA_PATH, location, consumerKey));
    }

    public String getLocations() throws IOException {
        return this.get(String.format(LOCATION_PATH, consumerKey));
    }

    public String getParkingSpots(String location) throws IOException {
        return this.get(String.format(PARKING_PATH, location, consumerKey));
    }

    public String getGasstations(String location) throws IOException {
        return this.get(String.format(GAS_PATH, location, consumerKey));
    }

    private String get(String path) throws IOException {

        URL url;

        try {
            url = new URL(BASE_URI + path);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Given path is not valid", e);
        }

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {

            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());
            con.setConnectTimeout(30000);
            con.setReadTimeout(30000);

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }

        } finally {
            con.disconnect();
        }
    }
}
