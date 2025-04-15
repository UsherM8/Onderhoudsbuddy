package org.example.onderhoudsbuddybusiness.Services;

import org.example.onderhoudsbuddydal.Entities.UserEntity;
import org.example.onderhoudsbuddydal.Repositories.UserRepository;
import org.example.onderhoudsbuddydomain.Dto.UserDto;
import org.example.onderhoudsbuddydomain.ServiceInterfaces.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        return userRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDto createUser(UserDto dto) {
        UserEntity entity = mapToEntity(dto);
        entity.setPassword(encoder.encode(dto.getPassword()));
        UserEntity saved = userRepository.save(entity);
        return mapToDto(saved);
    }

    public UserDto updateUser(UserDto dto) {
        UserEntity entity = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setBirthDate(dto.getBirthDate());
        entity.setEmail(dto.getEmail());
        entity.setType(dto.getType());

        return mapToDto(userRepository.save(entity));
    }


    public Boolean deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    private UserDto mapToDto(UserEntity entity) {
        return new UserDto(
                entity.getUserId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBirthDate(),
                entity.getEmail(),
                entity.getType(),
                entity.getPassword()
        );
    }
    private UserEntity mapToEntity(UserDto dto) {
        return UserEntity.builder()
                .userId(dto.getUserId()) // optional if generating in DB
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(dto.getBirthDate())
                .email(dto.getEmail())
                .type(dto.getType())
                .password(dto.getPassword())
                .build();
    }


}
