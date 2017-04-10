package com.sample.dong.mapper;

import com.sample.dong.domain.User;
import com.sample.dong.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    List<UserDTO> toDTOList(List<User> users);

    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "id1", ignore = true)
    User toEntity(UserDTO userDto);
}
