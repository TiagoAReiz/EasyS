package Easys.Easys.Adapters.Mappers;

import Easys.Easys.Adapters.Dtos.ServiceDtos.ServiceCreateDto;
import Easys.Easys.Core.Model.Service;

public class ServiceMapper {
    public Service toModel(ServiceCreateDto serviceCreateDto) {
        Service service = new Service();
            service.setName(serviceCreateDto.name());
            service.setDescription(serviceCreateDto.description());
            service.setPrice(serviceCreateDto.price());
            service.setCategory(serviceCreateDto.category());
            service.setDuration(serviceCreateDto.duration());
            service.setRating(serviceCreateDto.rating());
            service.setProvider(serviceCreateDto.provider());
            service.setLocation(serviceCreateDto.location());
            service.setContact(serviceCreateDto.contact());
            service.setImage(serviceCreateDto.image());
            return service;

    }


}
