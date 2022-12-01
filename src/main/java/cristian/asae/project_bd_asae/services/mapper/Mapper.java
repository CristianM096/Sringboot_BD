package cristian.asae.project_bd_asae.services.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cristian.asae.project_bd_asae.model.DocentEntity;
import cristian.asae.project_bd_asae.model.StudentEntity;
import cristian.asae.project_bd_asae.model.SubjectEntity;
import cristian.asae.project_bd_asae.services.DTO.DocentDTO;
import cristian.asae.project_bd_asae.services.DTO.StudentDTO;
import cristian.asae.project_bd_asae.services.DTO.SubjectDTO;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        /* Control Student Mapping */
        TypeMap<StudentEntity, StudentDTO> studentMap = objMapper.emptyTypeMap(StudentEntity.class, StudentDTO.class);
        studentMap.addMappings(m -> m.skip(StudentDTO::setObjAddress)).implicitMappings();
        studentMap.addMappings(m -> m.skip(StudentDTO::setPhones)).implicitMappings();
        /* Control Docent Mapping */
        TypeMap<DocentEntity, DocentDTO> docentMap = objMapper.emptyTypeMap(DocentEntity.class, DocentDTO.class);
        docentMap.addMappings(m -> m.skip(DocentDTO::setUniversity)).implicitMappings();
        /* Control Subject Mapping */
        TypeMap<SubjectEntity, SubjectDTO> subjectMap = objMapper.emptyTypeMap(SubjectEntity.class, SubjectDTO.class);
        // subjectMap.addMappings(m -> m.skip(SubjectDTO::setDocents)).implicitMappings();
        subjectMap.addMappings(m -> m.skip(SubjectDTO::setObjCourse)).implicitMappings();

        return objMapper;
    }
}
