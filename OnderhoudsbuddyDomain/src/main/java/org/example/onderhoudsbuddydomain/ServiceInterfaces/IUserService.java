package org.example.onderhoudsbuddydomain.ServiceInterfaces;

import org.example.onderhoudsbuddydomain.Dto.UserDto;
import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Integer id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    Boolean deleteUser(Integer id);
}

