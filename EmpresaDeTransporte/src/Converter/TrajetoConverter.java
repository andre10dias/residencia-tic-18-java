package Converter;

import java.util.ArrayList;
import java.util.List;

import DTO.TrajetoDTO;
import DTO.TrechoDTO;
import Model.PontoParada;
import Model.Trajeto;
import Model.Trecho;

public class TrajetoConverter implements IConverter<TrajetoDTO, Trajeto> {
	
	public static TrajetoConverter getInstance() {
		return new TrajetoConverter();
	}

	@Override
	public List<TrajetoDTO> convertToDTO(List<Trajeto> listaEntity) {
		List<TrajetoDTO> listaTrajetoDto = new ArrayList<>();
		
		for (Trajeto trajeto : listaEntity) {
			List<TrechoDTO> listaTrechoDto = new ArrayList<>(); 
			TrechoDTO trechoDto = null;
			
			for (Trecho trecho : trajeto.getListaTrechos()) {
				String origem = trecho.getOrigem().getNome();
				String destino = trecho.getDestino().getNome();
				Integer intervalo = trecho.getIntervaloEstimado();
				
				trechoDto = new TrechoDTO(trecho.getCodigo(), origem, destino, intervalo);
				listaTrechoDto.add(trechoDto);
			}
			
			TrajetoDTO trajetoDto = new TrajetoDTO(trajeto.getCodigo(), listaTrechoDto);
			listaTrajetoDto.add(trajetoDto);
		}
		
		return listaTrajetoDto;
	}

	@Override
	public List<Trajeto> convertToEntity(List<TrajetoDTO> listaDto) {
		List<Trajeto> listaTrajeto = new ArrayList<>();
		
		for (TrajetoDTO trajetoDto : listaDto) {
			List<Trecho> listaTrecho = new ArrayList<>(); 
			Trecho trecho = null;
			
			for (TrechoDTO trechoDto : trajetoDto.getListaTrechosDto()) {
				PontoParada origem = new PontoParada(trechoDto.getOrigem());
				PontoParada destino = new PontoParada(trechoDto.getDestino());

				trecho = new Trecho(trechoDto.getCodigo(), origem, destino, 
						trechoDto.getIntervaloEstimado());
				listaTrecho.add(trecho);
			}
			
			Trajeto trajeto = new Trajeto(trajetoDto.getCodigo(), listaTrecho);
			listaTrajeto.add(trajeto);
		}
		
		return listaTrajeto;
	}

}
