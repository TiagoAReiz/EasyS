package Easys.Easys.Adapters.Dtos.ProfessionalDtos;

public record ProfessionalCreateDto(String username, String email, String phone, String password,
                            String address, String city, String state, String country, String zip,String cpf, String professionalType, String professionalDescription) {
    
}
