package org.example.onderhoudsbuddydomain.serviceInterfaces;

import org.example.onderhoudsbuddydomain.dto.UserDto;
import java.util.List;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Integer id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    Boolean deleteUser(Integer id);
}

