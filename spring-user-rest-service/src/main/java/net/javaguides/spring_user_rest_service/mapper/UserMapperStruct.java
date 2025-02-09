package net.javaguides.spring_user_rest_service.mapper;

import net.javaguides.spring_user_rest_service.dto.UserDto;
import net.javaguides.spring_user_rest_service.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperStruct {
    UserMapperStruct MAPPER = Mappers.getMapper(UserMapperStruct.class);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "fname", source = "firstName")
    @Mapping(target = "lname", source = "lastName")
    @Mapping(target = "email", source = "email")
    UserDto userToUserDto(User user);

    @InheritInverseConfiguration
    User userDtoToUser(UserDto userDto);
}
