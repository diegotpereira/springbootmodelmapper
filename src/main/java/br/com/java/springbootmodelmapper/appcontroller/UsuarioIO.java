package br.com.java.springbootmodelmapper.appcontroller;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.com.java.springbootmodelmapper.dto.inputs.UsuarioInput;
import br.com.java.springbootmodelmapper.model.Usuario;

@Component("UsuarioIO")
public class UsuarioIO {
    
    private ModelMapper modelMapper;

    final Converter<UsuarioInput, Usuario> usuarioConverter = new Converter<UsuarioInput, Usuario>() {
        
        @Override
        public Usuario convert(MappingContext<UsuarioInput, Usuario> context) {
            UsuarioInput usuarioInput = context.getSource();

            Usuario usuario = new Usuario();
            usuario.setUsuarionome(usuarioInput.getUsuarionome());
            usuario.setPassword(usuarioInput.getPassword());
            usuario.setNome(usuarioInput.getNome());
            usuario.setSobrenome(usuarioInput.getSobrenome());

            return usuario;
        }
    };

    public UsuarioIO(){
        modelMapper = new ModelMapper();
        modelMapper.addConverter(usuarioConverter);
    }

    public Usuario mapTo(UsuarioInput usuarioInput) {

        return this.modelMapper.map(usuarioInput, Usuario.class);
    }
}
