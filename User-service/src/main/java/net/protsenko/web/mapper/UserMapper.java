package net.protsenko.web.mapper;

import net.protsenko.domain.User;
import net.protsenko.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}
