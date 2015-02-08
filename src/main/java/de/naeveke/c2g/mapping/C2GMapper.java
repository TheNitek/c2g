package de.naeveke.c2g.mapping;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import de.naeveke.c2g.Location;

public class C2GMapper extends ObjectMapper{
    
    public C2GMapper(){
        super();
        
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Location.class, new LocationDeserializer());
        this.registerModule(module);
    }

}
