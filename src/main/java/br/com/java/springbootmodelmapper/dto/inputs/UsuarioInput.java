package br.com.java.springbootmodelmapper.dto.inputs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

@ApiModel(value = "UsuarioInput")
public class UsuarioInput {

    @ApiModelProperty(example = "usuario@usuario.com", required = true)
    @NotEmpty
    private String usuarionome;

    @ApiModelProperty(example = "P@ssword", required = true)
    @NotEmpty
    private String password;

    @ApiModelProperty(example = "Usuario", required = true)
    private String nome;

    @ApiModelProperty(example = "Sobrenome", required = true)
    private String sobrenome;

    public String getUsuarionome() {
        return usuarionome;
    }

    public void setUsuarionome(String usuarionome) {
        this.usuarionome = usuarionome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
