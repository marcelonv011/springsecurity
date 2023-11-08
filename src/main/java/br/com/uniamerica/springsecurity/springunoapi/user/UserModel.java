package br.com.uniamerica.springsecurity.springunoapi.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String username;
    private String password;
    private String role;

}
