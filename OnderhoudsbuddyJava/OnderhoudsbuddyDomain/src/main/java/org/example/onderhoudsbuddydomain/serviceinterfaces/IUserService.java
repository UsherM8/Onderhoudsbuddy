package org.example.onderhoudsbuddydomain.serviceinterfaces;

import org.example.onderhoudsbuddydomain.dto.UserDto;
import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Integer id);
    UserDto createUser(UserDto userDto, String password);
    UserDto updateUser(UserDto userDto);
    Boolean deleteUser(Integer id);
}

