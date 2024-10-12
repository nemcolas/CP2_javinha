package com.exampleCP2.diplomados.Service;


import com.exampleCP2.diplomados.DTO.LoginRequest;
import com.exampleCP2.diplomados.DTO.LoginResponse;
import com.exampleCP2.diplomados.Security.SecurityConfigurations;

import com.exampleCP2.diplomados.DTO.LoginRequest;
import com.exampleCP2.diplomados.DTO.LoginResponse;
import com.exampleCP2.diplomados.DTO.RegisterDiplomadoRequest;
import com.exampleCP2.diplomados.Model.Diplomado;
import com.exampleCP2.diplomados.Model.Role;
import com.exampleCP2.diplomados.Repository.DiplomadoRepository;
import com.exampleCP2.diplomados.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // Método para registrar um novo diplomado
    public String registerDiplomado(RegisterDiplomadoRequest registerRequest) {
        if (diplomadoRepository.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Nome de usuário já existe.");
        }

        // Codifica a senha e salva o novo diplomado com a role USER
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);

        Diplomado diplomado = new Diplomado(
                registerRequest.getNome(),
                registerRequest.getNacionalidade(),
                registerRequest.getNaturalidade(),
                registerRequest.getRg(),
                registerRequest.getUsername(),
                encodedPassword,
                roles
        );
        diplomadoRepository.save(diplomado);

        return "Diplomado registrado com sucesso.";
    }

    // Método para realizar o login e gerar o token JWT
    public LoginResponse login(LoginRequest loginRequest) {
        Diplomado diplomado = diplomadoRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Diplomado não encontrado."));

        if (passwordEncoder.matches(loginRequest.getPassword(), diplomado.getPassword())) {
            String token = jwtTokenProvider.generateToken(diplomado.getUsername());
            return new LoginResponse(token);
        } else {
            throw new RuntimeException("Credenciais inválidas.");
        }
    }
}
