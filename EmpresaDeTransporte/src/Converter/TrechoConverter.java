package Converter;

import java.util.ArrayList;
import java.util.List;

import DTO.TrechoDTO;
import Model.PontoParada;
import Model.Trecho;

public class TrechoConverter implements IConverter<TrechoDTO, Trecho> {
	
	public static TrechoConverter getInstance() {
		return new TrechoConverter();
	}

	@Override
	public List<TrechoDTO> convertToDTO(List<Trecho> listaEntity) {
		List<TrechoDTO> listaTrechoDto = new ArrayList<>();
		
		for (Trecho trecho : listaEntity) {
			TrechoDTO trechoDto = new TrechoDTO(trecho.getCodigo(), trecho.getOrigem().getNome(), 
					trecho.getDestino().getNome(), trecho.getIntervaloEstimado());
			
			listaTrechoDto.add(trechoDto);
		}
		
		return listaTrechoDto;
	}

	@Override
	public List<Trecho> convertToEntity(List<TrechoDTO> listaDto) {
		List<Trecho> listaTrecho = new ArrayList<>();
		
		for (TrechoDTO trechoDto : listaDto) {
			PontoParada origem = new PontoParada(trechoDto.getOrigem());
			PontoParada destino = new PontoParada(trechoDto.getOrigem());
			
			Trecho trecho = new Trecho(trechoDto.getCodigo(), origem, 
					destino, trechoDto.getIntervaloEstimado());
			
			listaTrecho.add(trecho);
		}
		
		return listaTrecho;
	}

}
