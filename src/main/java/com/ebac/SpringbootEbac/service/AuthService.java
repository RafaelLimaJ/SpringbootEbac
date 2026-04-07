package com.ebac.SpringbootEbac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebac.repositories.UsuarioRepository;
import com.ebac.entities.Usuario;
import com.ebac.SpringbootEbac.dto.LoginResponse;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LoginResponse authenticate(String username, String password) {
        // Busca o usuário no banco de dados
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);

        // Verificar se o usuário existe
        if (!usuarioOptional.isPresent()) {
            return new LoginResponse(false, "Usuário não existe");
        }

        Usuario usuario = usuarioOptional.get();

        // Verificar se a senha está correta
        if (!usuario.getPassword().equals(password)) {
            return new LoginResponse(false, "Senha está errada");
        }

        // Autenticação bem-sucedida
        return new LoginResponse(true, "Autenticação realizada com sucesso", usuario.getId());
    }
}
