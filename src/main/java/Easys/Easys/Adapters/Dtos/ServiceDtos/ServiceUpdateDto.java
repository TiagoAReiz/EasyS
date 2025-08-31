package Easys.Easys.Adapters.Dtos.ServiceDtos;

import java.math.BigDecimal;

import Easys.Easys.Core.Model.Professional;

public record ServiceUpdateDto(
    String name, 
    String description, 
    BigDecimal price, 
    String category, 
    int duration, 
    int rating,
    Professional provider, 
    String location, 
    String contact, 
    String image
) {
    
}