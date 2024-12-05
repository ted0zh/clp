package com.learningPlatform.CLP.data.mapper;

import com.learningPlatform.CLP.data.dto.UserDto;
import com.learningPlatform.CLP.data.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;




@Mapper(componentModel = "spring")
public interface UserMapper {
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "createdAt", expression = "java(java.sql.Timestamp.from(java.time.Instant.now()))")
    Users toEntity(UserDto dto);

    UserDto toDto(Users entity);
}
