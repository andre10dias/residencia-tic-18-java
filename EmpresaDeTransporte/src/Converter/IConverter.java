package Converter;

import java.util.List;

public interface IConverter<DTO, Entity> {
	
	public List<DTO> convertToDTO(List<Entity> listaEntity);
	public List<Entity> convertToEntity(List<DTO> listaDto);
	
}
