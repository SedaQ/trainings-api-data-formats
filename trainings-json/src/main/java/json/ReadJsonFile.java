package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import json.dto.RestResource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Pavel Seda
 */
public class ReadJsonFile {

    private static ObjectMapper objMapper = new ObjectMapper();


    public static void main(String[] args) throws URISyntaxException, IOException {
        readJsonFile("persons.json");


        //get particular field from json
        getParticularFieldFromJson();

    }

    public static RestResource readJsonFile(String fileName) throws URISyntaxException, IOException {
        byte[] personsData = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("persons.json").toURI()));

        objMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        // read json data
        RestResource person = objMapper.readValue(personsData, RestResource.class);

        System.out.print(person);

        return person;
    }

    private static void getParticularFieldFromJson() throws IOException {
        String jsonString = "{\"content\":[{\"person_id\":\"1\",\"first_name\":\"Pavel\",\"last_name\":\"Seda\",\"address\":{\"street\":\"XYZ123\",\"zip_code\":\"91200\",\"house_number\":\"12\",\"city\":\"Brno\",\"country\":\"Czech Republic\"},\"group\":{\"name\":\"legends\",\"roles\":[{\"role\":\"CHIEF\"}]}}]}";

        JsonNode jsonRootNode = objMapper.readTree(jsonString);
        JsonNode content = jsonRootNode.get("content");
        JsonNode lastName = content.get("last_name");

        System.out.print("Person with id=1 last name is:.." + lastName);
    }


}
