package br.com.java.springbootmodelmapper.dto.outputs;

import javax.validation.constraints.*;

import io.swagger.annotations.ApiModelProperty;

public class UsuarioOutput {
    
    @ApiModelProperty(example = "1", required = true)
    @NotEmpty
    private Long id;

    @ApiModelProperty(example = "usuario@usuario.com", required = true)
    @NotEmpty
    @Email
    private String usuarionome;

    @ApiModelProperty(example = "Maria", required = true)
    private String nome;

    @ApiModelProperty(example = "Silva", required = true)
    private String sobrenome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuarionome() {
        return usuarionome;
    }

    public void setUsuarionome(String usuarionome) {
        this.usuarionome = usuarionome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
