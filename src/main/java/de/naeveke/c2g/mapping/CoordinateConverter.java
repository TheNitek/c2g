package de.naeveke.c2g.mapping;

import com.fasterxml.jackson.databind.util.StdConverter;
import de.naeveke.c2g.Coordinates;

public class CoordinateConverter extends StdConverter<double[], Coordinates> {
    
    @Override
    public Coordinates convert(double[] in) {
        if(in.length != 3){
            throw new IllegalArgumentException("Invalid coordinate input: Expected 3 elements");
        }
        return new Coordinates(in[1], in[0]);
    }


}
