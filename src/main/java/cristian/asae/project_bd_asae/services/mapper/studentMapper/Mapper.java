package cristian.asae.project_bd_asae.services.mapper.studentMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cristian.asae.project_bd_asae.model.StudentEntity;
import cristian.asae.project_bd_asae.services.DTO.StudentDTO;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        // TypeMap<StudentEntity, StudentDTO> mapa = objMapper.emptyTypeMap(StudentEntity.class, StudentDTO.class);
        // mapa.addMappings(m -> m.skip(StudentDTO::setObjAddress)).implicitMappings();
        // mapa.addMappings(m -> m.skip(ClienteDTO::setSolicitudes)).implicitMappings();
        // mapa.addMappings(m -> m.skip(StudentDTO::setLastname)).implicitMappings();
        return objMapper;
    }
}
