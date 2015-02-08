# c2g Lib
The c2g lib provides easy access to the open parts of the car2go OpenAPI.
It allows you to access Locations, Vehicles, Home Areas, Parking Spots and Gas Stations without digging too deep in the API (and its inconsistencies).

# Usage
First you need to get a consumer key for the OpenAPI. Instructions can be found at https://code.google.com/p/car2go/wiki/oauth#Registration_as_consumer

```
C2GAPIClient client = new C2GAPIClient("car2go");

List<Location> locations = client.getLocations();
List<Area> areas = client.getOperatingAreas("Hamburg");
List<Vehicle> vehicles = client.getVehicles("Austin");
List<GasStation> gasstations = client.getGasStations("Hamburg");
List<ParkingSpot> parkingspots = client.getParkingSpots("Hamburg");
```

# Disclaimer
This product uses the car2go API but is not endorsed or certified by car2go. Please have a look at https://www.car2go.com/api/tou.htm before using this library.
