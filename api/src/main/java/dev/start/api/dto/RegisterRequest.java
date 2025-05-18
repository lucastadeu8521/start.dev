package dev.start.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String nome;
    private String email;
    private String senha;


}