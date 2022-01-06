package br.com.java.springbootmodelmapper.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Entity
public class Usuario implements Serializable{

    private static final long serialVersionUID = 6846117438634217888L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "usuarionome")
    private String usuarionome;

    @Column(name = "password")
    private String password;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "datanascimento")
    private LocalDate datanascimento;

    public Usuario() {}

    public Usuario(Long id, String nome, String sobrenome, String usuarionome, String password, Integer idade,
            LocalDate datanascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.usuarionome = usuarionome;
        this.password = password;
        this.idade = idade;
        this.datanascimento = datanascimento;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuarionome());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId()) &&
                Objects.equals(getUsuarionome(), usuario.getUsuarionome());
    }

    @Override
    public String toString() {
        return "Usuario [datanascimento=" + datanascimento + ", id=" + id + ", idade=" + idade + ", nome=" + nome
                + ", password=" + password + ", sobrenome=" + sobrenome + ", usuarionome=" + usuarionome + "]";
    }
}
