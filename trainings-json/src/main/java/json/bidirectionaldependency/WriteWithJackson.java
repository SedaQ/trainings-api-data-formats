package json.bidirectionaldependency;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

/**
 * @author Pavel Seda
 */
public class WriteWithJackson {

    public static void main(String[] args) throws IOException {

        UserDto userDto = new UserDto("Pavel", "pavelseda@email.cz");
        AddressDto addressDto = new AddressDto("Brno-Stred", userDto);
        AddressDto addressDto1 = new AddressDto("Brno-Bystrc", userDto);

        userDto.addAddress(addressDto1); // bidirectional relationship, will leads to fail.

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        objectMapper.writeValue(new File("./trainings-json/src/main/resources/persons-write-bidirectional-dependency.json"), userDto);
    }
}
