package json.bidirectionaldependency;

/**
 * @author Pavel Seda
 */
public class AddressDto {

    private String address;
    private UserDto userDto;

    public AddressDto() {
    }

    public AddressDto(String address, UserDto userDto) {
        this.address = address;
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "userDto=" + userDto +
                '}';
    }
}
