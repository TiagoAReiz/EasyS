package Easys.Easys.Adapters.Dtos.ServiceDtos;

import Easys.Easys.Core.Model.Professional;

public record ServiceCreateDto(
    String name, 
    String description, 
    double price, 
    String category, 
    double duration, 
    int rating,
    Professional provider, 
    String location, 
    String contact, 
    String image
) {
    
}
