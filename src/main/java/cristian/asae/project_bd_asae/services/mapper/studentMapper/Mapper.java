package cristian.asae.project_bd_asae.services.mapper.studentMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.unicauca.distribuidos.core.proyecto.models.ClienteEntity;
import co.edu.unicauca.distribuidos.core.proyecto.models.DireccionEntity;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.ClienteDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.DireccionDTO;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<ClienteEntity, ClienteDTO> mapa = objMapper.emptyTypeMap(ClienteEntity.class, ClienteDTO.class);
        // mapa.addMappings(m ->
        // m.skip(ClienteDTO::setObjDireccion)).implicitMappings();
        // mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        mapa.addMappings(m -> m.skip(ClienteDTO::setCreateAt)).implicitMappings();
        return objMapper;
    }
}
