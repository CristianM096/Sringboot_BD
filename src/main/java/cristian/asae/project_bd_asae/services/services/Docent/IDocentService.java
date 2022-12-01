package cristian.asae.project_bd_asae.services.services.Docent;

import java.util.List;

import cristian.asae.project_bd_asae.services.DTO.DocentDTO;


public interface IDocentService {
    public List<DocentDTO> findAll();

	public DocentDTO findById(Integer id);

	public DocentDTO save(DocentDTO docent);

	public DocentDTO update(Integer id, DocentDTO docent);

	public boolean delete(Integer id);
}
