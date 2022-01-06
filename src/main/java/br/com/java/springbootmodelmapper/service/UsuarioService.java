package br.com.java.springbootmodelmapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.springbootmodelmapper.model.Usuario;
import br.com.java.springbootmodelmapper.repository.UsuarioRepositorio;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> index() {

        return usuarioRepositorio.findAll();
    }

    public Usuario exibir(Long id) {

        return usuarioRepositorio.getOne(id);

    }

    public Usuario criar(Usuario usuario) {

        return usuarioRepositorio.save(usuario);
    }

    public void deletar(Long id) {

        usuarioRepositorio.deleteById(id);
    }

    public Usuario atualizar(Long id, Usuario novoUsuario) throws Exception {
        Usuario usuario = usuarioRepositorio.getOne(id);

        if (usuario == null) {
            
            throw new Exception();
        }

        if (usuario.getId() != id) {
            
            throw new IllegalArgumentException();
        }

        novoUsuario.setId(id);

        Usuario usuarioDB = usuarioRepositorio.save(novoUsuario);

        return usuarioDB;
    }
}
