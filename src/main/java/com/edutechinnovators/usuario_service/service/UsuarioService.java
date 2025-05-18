package com.edutechinnovators.usuario_service.service;

import com.edutechinnovators.usuario_service.model.Usuario;
import com.edutechinnovators.usuario_service.repository.UsuarioRepository;
import  jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuarioActualizado = usuarioExistente.get();
            usuarioActualizado.setRun(usuario.getRun());
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setApellido(usuario.getApellido());
            usuarioActualizado.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioActualizado.setCorreo(usuario.getCorreo());
            usuarioActualizado.setPassword(usuario.getPassword());
            usuarioActualizado.setRol(usuario.getRol());
            return usuarioRepository.save(usuarioActualizado);
        } else {
            return null;
        }
    }

    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Optional<Usuario> findByRun(String run) {
        return usuarioRepository.findByRun(run);
    }
}
