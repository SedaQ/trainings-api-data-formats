package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import json.dto.RestResource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Pavel Seda
 */
public class WriteJsonFile {

    private static ObjectMapper objMapper = new ObjectMapper();

    public static void main(String[] args) throws URISyntaxException, IOException {

        // write object to json data
        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objMapper.writeValue(new File("./trainings-json/src/main/resources/persons-write.json"), ReadJsonFile.readJsonFile("persons.json"));

    }

}
