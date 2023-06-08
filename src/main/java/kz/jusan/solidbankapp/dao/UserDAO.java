package kz.jusan.solidbankapp.dao;

import kz.jusan.solidbankapp.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
