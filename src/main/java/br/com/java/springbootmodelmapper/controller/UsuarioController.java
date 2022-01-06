package br.com.java.springbootmodelmapper.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.java.springbootmodelmapper.appcontroller.AppControllerBase;
import br.com.java.springbootmodelmapper.appcontroller.UsuarioIO;
import br.com.java.springbootmodelmapper.dto.inputs.UsuarioInput;
import br.com.java.springbootmodelmapper.dto.outputs.UsuarioOutput;
import br.com.java.springbootmodelmapper.model.Usuario;
import br.com.java.springbootmodelmapper.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/usuarios")
@Api(tags = "Usuarios")
@CrossOrigin
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    AppControllerBase appControllerBase;

    @Autowired
    UsuarioIO usuarioIO;

    @PostMapping({"/", ""})
    @ApiOperation(value = "Cirar um Usuario", notes = "Também retorna um link para recuperar o usuário salvo no cabeçalho do local")
    public ResponseEntity<Object> criarUsuario(@Valid @RequestBody UsuarioInput usuario) {
        Usuario usuarioModel = usuarioIO.mapTo(usuario);
        Usuario salvarUsuario = usuarioService.criar(usuarioModel);

        URI location = ServletUriComponentsBuilder
                       .fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(salvarUsuario.getId())
                       .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Obtenha um único usuário")
    @GetMapping({ "/{id}/", "/{id}"})
    public UsuarioOutput exibirUsuario(@PathVariable("id") Long id) {

        return appControllerBase.mapTo(usuarioService.exibir(id), UsuarioOutput.class);
    }

    @ApiOperation(value = "Ataulizar um Usuário")
    @PutMapping({ "/{id}/", "/{id}"})
    public ResponseEntity<?> atualizarUsuario(@Min(value = 1) @PathVariable("id") Long id, @RequestBody UsuarioInput usuario) throws Exception {
        Usuario usuario1 = usuarioIO.mapTo(usuario);
        usuarioService.atualizar(id, usuario1);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deletar um Usuario")
    @DeleteMapping({ "/{id}/", "/{id}" })
    public ResponseEntity<?> deletarUsuario(@PathVariable("id") Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.ok().build();
    }
}
