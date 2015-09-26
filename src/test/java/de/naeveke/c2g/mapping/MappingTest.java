package de.naeveke.c2g.mapping;

import de.naeveke.c2g.Area;
import de.naeveke.c2g.BaseJsonTestCase;
import de.naeveke.c2g.GasStation;
import de.naeveke.c2g.Location;
import de.naeveke.c2g.ParkingSpot;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import de.naeveke.c2g.Vehicle;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author Nitek
 */
public class MappingTest extends BaseJsonTestCase {

    C2GMapper mapper;


    @Before
    public void setup() {
        mapper = new C2GMapper();
    }

    @Test
    public void testLocation() throws Exception {
        String austinRaw = this.readFile("locations/austin.json");
        
        Location austin = mapper.readValue(austinRaw, Location.class);
        
        assertEquals(2, austin.getId());
        assertEquals("Austin", austin.getName());
        assertEquals(TimeZone.getTimeZone("America/Chicago"), austin.getTimezone());
        assertEquals(new Locale.Builder().setLanguage("en").setRegion("US").build(), austin.getLocale());
        assertEquals(30.2794, austin.getCenter().getLatitude(), 0);
        assertEquals(-97.7434, austin.getCenter().getLongitude(), 0);
        assertEquals(30.160647, austin.getLowerRight().getLatitude(), 0);
        assertEquals(-97.604331, austin.getLowerRight().getLongitude(), 0);
        assertEquals(30.42769, austin.getUpperLeft().getLatitude(), 0);
        assertEquals(-97.918696, austin.getUpperLeft().getLongitude(), 0);
    }
    
    @Test
    public void testCEVehicle() throws Exception {
        String ceJson = this.readFile("vehicles/ce.json");
        
        Vehicle ce = mapper.readValue(ceJson, Vehicle.class);
        
        assertEquals("WMEEJ3BAXAK402951", ce.getVin());
        assertEquals("CK9 T400", ce.getPlate());
        assertEquals(true, ce.isSmartPhoneRequired());
        assertEquals(false, ce.isCharging());
        assertEquals(Vehicle.EngineType.CE, ce.getEngineType());
        assertEquals(Vehicle.Cleanliness.UNACCEPTABLE, ce.getInterior());
        assertEquals(Vehicle.Cleanliness.GOOD, ce.getExterior());
        assertEquals(93, ce.getFuel());
        assertEquals("Cresthaven Dr 1740, 78704 Austin", ce.getAddress());
        assertEquals(30.26035, ce.getPosition().getLatitude(), 0);
        assertEquals(-97.78191, ce.getPosition().getLongitude(), 0);
    }
    
    @Test
    public void testEDVehicle() throws Exception {
        String edJson = this.readFile("vehicles/ed.json");
        
        Vehicle ed = mapper.readValue(edJson, Vehicle.class);
        
        assertEquals("WMEEJ9BA7BK476722", ed.getVin());
        assertEquals("BCF 5535", ed.getPlate());
        assertEquals(false, ed.isSmartPhoneRequired());
        assertEquals(true, ed.isCharging());
        assertEquals(Vehicle.EngineType.ED, ed.getEngineType());
        assertEquals(Vehicle.Cleanliness.GOOD, ed.getInterior());
        assertEquals(Vehicle.Cleanliness.GOOD, ed.getExterior());
        assertEquals(96, ed.getFuel());
        assertEquals("NW Recreation Center Charging Station", ed.getAddress());
        assertEquals(30.33397, ed.getPosition().getLatitude(), 0);
        assertEquals(-97.75133, ed.getPosition().getLongitude(), 0);
    }
    
    @Test
    public void testAreaIncluded() throws Exception {
        String areaJson = this.readFile("areas/included.json");
        
        Area area = mapper.readValue(areaJson, Area.class);
        
        assertEquals("MILANO", area.getName());
        assertEquals(Area.Type.INCLUDED, area.getType());
        assertEquals(1364, area.getOutline().size());
        assertEquals(9.157288, area.getOutline().get(0).getLongitude(), 0);
        assertEquals(45.522465, area.getOutline().get(0).getLatitude(), 0);
        assertEquals(9.152029, area.getOutline().get(1).getLongitude(), 0);
        assertEquals(45.52143, area.getOutline().get(1).getLatitude(), 0);
    }

        
    @Test
    public void testAreaExcluded() throws Exception {
        String areaJson = this.readFile("areas/excluded.json");
        
        Area area = mapper.readValue(areaJson, Area.class);
        
        assertEquals("MILANO_ISLAND 1", area.getName());
        assertEquals(Area.Type.EXCLUDED, area.getType());
        assertEquals(31, area.getOutline().size());
    }
    
    @Test
    public void testAreaParking() throws Exception {
        String areaJson = this.readFile("areas/parking.json");
        
        Area area = mapper.readValue(areaJson, Area.class);
        
        assertEquals("MILANO_ISLAND 2", area.getName());
        assertEquals(Area.Type.PARKING, area.getType());
        assertEquals(29, area.getOutline().size());
    }
    
    @Test
    public void testGasstation() throws Exception {
        String gasstationJson = this.readFile("gasstations/gasstation.json");
        
        GasStation gasstation = mapper.readValue(gasstationJson, GasStation.class);
        
        assertEquals("Shell, Ahrensburger Str. 35", gasstation.getName());
        assertEquals(10.09325, gasstation.getCoordinates().getLongitude(), 0);
        assertEquals(53.57816, gasstation.getCoordinates().getLatitude(), 0);
    }

    @Test
    public void testParkingSpotNoCharging() throws Exception {
        String parkingSpotJson = this.readFile("parkspots/nocharging.json");
        
        ParkingSpot parkingSpot = mapper.readValue(parkingSpotJson, ParkingSpot.class);
        
        assertEquals("switchh - Berliner Tor", parkingSpot.getName());
        assertEquals(false, parkingSpot.isChargingPole());
        assertEquals(4, parkingSpot.getTotalCapacity());
        assertEquals(0, parkingSpot.getUsedCapacity());
        assertEquals(10.02377, parkingSpot.getCoordinates().getLongitude(), 0);
        assertEquals(53.55328, parkingSpot.getCoordinates().getLatitude(), 0);
    }
}
