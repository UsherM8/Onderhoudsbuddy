package org.example.onderhoudsbuddyweb.Controllers;

import org.example.onderhoudsbuddydomain.dto.UserDto;
import org.example.onderhoudsbuddydomain.serviceInterfaces.IUserService;
import org.example.onderhoudsbuddyweb.Models.Requests.CreateUserRequest;
import org.example.onderhoudsbuddyweb.Models.Responses.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;
    private UUID id;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to OnderhoudsBuddy!";
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
        UserDto user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapToResponse(user));
    }


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserDto user =
                new UserDto(
                null,
                request.getFirstName(),
                request.getLastName(),
                request.getBirthDate(),
                request.getEmail(),
                request.getType(),
                request.getPassword()
        );
        UserDto created = userService.createUser( user );
        return new ResponseEntity<>(mapToResponse(created), HttpStatus.CREATED);
    }

    public ResponseEntity<UserResponse> updateUser(@RequestBody UserDto userDto) {
        UserDto updated = userService.updateUser(userDto);
        return new ResponseEntity<>(mapToResponse(updated), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@RequestBody int id) {
        UserDto user = userService.getUserById(id);
        userService.deleteUser(id);
        return new ResponseEntity<>(mapToResponse(user), HttpStatus.OK);
    }

    private UserResponse mapToResponse(UserDto dto) {
        return new UserResponse(
                dto.getUserId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getBirthDate(),
                dto.getEmail(),
                dto.getType(),
                dto.getPassword()
        );
    }
}
