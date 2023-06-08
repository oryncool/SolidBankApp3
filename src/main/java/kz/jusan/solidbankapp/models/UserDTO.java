package kz.jusan.solidbankapp.models;

import lombok.Data;

import java.util.Optional;

@Data
public class UserDTO {
    private String username;
    private String role;

    public UserDTO(Optional<User> user) {
        this.username = user.get().getUsername();
        this.role = user.get().getRole();
    }
}
