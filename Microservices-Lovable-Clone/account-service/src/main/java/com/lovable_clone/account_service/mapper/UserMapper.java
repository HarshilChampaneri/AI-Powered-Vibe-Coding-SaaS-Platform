package com.lovable_clone.account_service.mapper;

import com.lovable_clone.account_service.dto.auth.SignupRequest;
import com.lovable_clone.account_service.dto.auth.UserProfileResponse;
import com.lovable_clone.account_service.entity.User;
import com.lovable_clone.common_library.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

    UserDto toUserDto(User user);

}
