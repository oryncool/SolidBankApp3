package kz.jusan.solidbankapp.models;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
    private String role;
}
