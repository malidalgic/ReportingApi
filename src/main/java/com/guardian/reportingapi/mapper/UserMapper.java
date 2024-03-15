package com.guardian.reportingapi.mapper;

import com.guardian.reportingapi.dto.UserDTO;
import com.guardian.reportingapi.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
