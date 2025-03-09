package com.ebookmanager.service;

import com.ebookmanager.exceptions.BadRequestException;
import com.ebookmanager.model.Usuario;
import com.ebookmanager.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {

        if(pesquisaEmail(usuario.getEmail()) != null) throw new BadRequestException("Usuario já Cadastrado");

        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new BadRequestException("ID not Found"));
    }

    public List<Usuario> findAll() {

        var usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) throw new BadRequestException("Not Found Usuarios");

        return usuarios;

    }

    public void delete(Long id) {
        var usuario = findById(id);
        usuarioRepository.delete(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        findById(usuario.getIdUsuario());
        return usuarioRepository.save(usuario);

    }

    public Usuario pesquisaEmail(String email) {

        return usuarioRepository.findByEmail(email);

    }


}
