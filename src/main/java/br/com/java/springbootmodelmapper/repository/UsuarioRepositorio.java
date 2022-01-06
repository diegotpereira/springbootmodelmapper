package br.com.java.springbootmodelmapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.springbootmodelmapper.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
    
}
