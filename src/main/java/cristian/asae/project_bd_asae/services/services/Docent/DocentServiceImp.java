package cristian.asae.project_bd_asae.services.services.Docent;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cristian.asae.project_bd_asae.model.DocentEntity;
import cristian.asae.project_bd_asae.repository.DocentRepository;
import cristian.asae.project_bd_asae.services.DTO.DocentDTO;

@Service
public class DocentServiceImp implements IDocentService{

    @Autowired
	private DocentRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DocentDTO> findAll() {
		Iterable<DocentEntity> docentsEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
		List<DocentDTO> docentsDTO = this.modelMapper.map(docentsEntity, new TypeToken<List<DocentDTO>>() {}.getType());
		return docentsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public DocentDTO findById(Integer id) {
		Optional<DocentEntity> docentEntity = this.servicioAccesoBaseDatos.findById(id);
		System.out.println("antes de la consulta");
		DocentDTO docentDTO = this.modelMapper.map(docentEntity.get(), new TypeToken<DocentDTO>() {}.getType());
		return docentDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public DocentDTO save(DocentDTO docent) {
        DocentEntity docentEntity = this.modelMapper.map(docent, DocentEntity.class);
        DocentEntity docentEntitySaved = this.servicioAccesoBaseDatos.save(docentEntity);
        DocentDTO docentDTO = this.modelMapper.map(docentEntitySaved, DocentDTO.class);
        return docentDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public DocentDTO update(Integer id, DocentDTO docent) {
        Optional<DocentEntity> docentOptional  = this.servicioAccesoBaseDatos.findById(id);
        DocentDTO docentDTOUpdate = null;
        DocentEntity docentEntity = docentOptional.get();
        if(docentEntity != null){
            docentEntity.setDni(docent.getDni());
            docentEntity.setDniType(docent.getDniType());
            docentEntity.setId(docent.getId());
            docentEntity.setLastname(docent.getLastname());
            docentEntity.setName(docent.getName());
            docentEntity.setSalary(docent.getSalary());
            docentEntity.setTypeDocent(docent.getTypeDocent());
            docentEntity.setUniversity(docent.getUniversity());

            /* Save Docent */
            DocentEntity docentEntityUpdate = this.servicioAccesoBaseDatos.save(docentEntity);
            docentDTOUpdate = this.modelMapper.map(docentEntityUpdate, DocentDTO.class);
        }
        return docentDTOUpdate;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer id) {
        boolean request = false;
        Optional<DocentEntity> docentOptional = this.servicioAccesoBaseDatos.findById(id);
        DocentEntity docentEntity = docentOptional.get();
        if(docentEntity != null){
            this.servicioAccesoBaseDatos.delete(docentEntity);
            request = true;
        }
        return request;
    }
    
}
