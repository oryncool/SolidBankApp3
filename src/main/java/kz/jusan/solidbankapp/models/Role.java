package kz.jusan.solidbankapp.models;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class Role implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
