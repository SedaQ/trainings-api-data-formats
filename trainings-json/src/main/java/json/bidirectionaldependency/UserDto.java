package json.bidirectionaldependency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Seda
 */
public class UserDto {

    private String name;
    private String email;
    private List<AddressDto> address = new ArrayList<>();


    public UserDto() {
    }

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserDto(String name, String email, List<AddressDto> address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public List<AddressDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDto> address) {
        this.address = address;
    }

    public void addAddress(AddressDto addressDto) {
        this.address.add(addressDto);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "address=" + address +
                '}';
    }
}
