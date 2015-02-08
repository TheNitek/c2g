package de.naeveke.c2g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class BaseJsonTestCase {

    public String readFile(String path) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine;
        StringBuilder data = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            data.append(inputLine);
        }

        return data.toString();
    }

}
