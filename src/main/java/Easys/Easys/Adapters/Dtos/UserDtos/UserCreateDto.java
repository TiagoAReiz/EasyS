package Easys.Easys.Adapters.Dtos.UserDtos;

public record UserCreateDto(String username, String email, String phone, String password,
                            String address, String city, String state, String country, String zip) {

}
