package de.naeveke.c2g.mapping;

import com.fasterxml.jackson.databind.util.StdConverter;
import de.naeveke.c2g.Coordinates;
import java.util.ArrayList;
import java.util.List;

public class PolygonConverter extends StdConverter<double[], List<Coordinates>> {


    @Override
    public List<Coordinates> convert(double[] in) {
        if ((in.length % 3) != 0) {
            throw new IllegalArgumentException("coordinates have to be a multiple of 3");
        }
        
        int pointCount = in.length / 3;
        
        List<Coordinates> coordinates = new ArrayList<>(pointCount);
        
        for(int i = 0; i < pointCount; i+=3){
            coordinates.add(new Coordinates(in[i], in[i+1]));
        }

        
        return coordinates;
    }

}
