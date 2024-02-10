package mockup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Cliente;
import models.Imovel;
import services.ClienteService;
import services.FaturaService;
import services.ImovelService;

public class Mock {
	
	public static void gerarDadosAleatorios() {
		Random random = new Random();
		
		gerarImoveisAleatorios(10);
		
		List<Imovel> imoveis = new ArrayList<>();
		for (int i = 0; i < 2; i++) {			
			Imovel imovel = ImovelService.getImoveis().get(random.nextInt(ImovelService.getImoveis().size()));
			imoveis.add(imovel);
		}
		
		gerarClientesAleatorios(5, imoveis);
		gerarFaturasAleatorias(15, imoveis);
	}

    private static void gerarImoveisAleatorios(int quantidade) {
		Random random = new Random();
		
        for (int i = 0; i < quantidade; i++) {
            String matricula = "Matricula" + i;
            String endereco = "Endereco" + i;
            
            Cliente cliente = ClienteService.getClientes()
            		.get(random.nextInt(ClienteService.getClientes().size()));
            
            ImovelService.salvarImovel(new Imovel(matricula, endereco, cliente));
        }
    }
	
	private static void gerarClientesAleatorios(int quantidade, List<Imovel> imoveis) {
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            String nome = "Cliente" + i;
            String cpf = String.valueOf(10000000000L + random.nextInt(900000000));
            Cliente cliente = new Cliente(nome, cpf);
            cliente.setImoveis(imoveis);
            ClienteService.salvarCliente(cliente);
        }
    }

    private static void gerarFaturasAleatorias(int quantidade, List<Imovel> imoveis) {
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            Imovel imovel = imoveis.get(random.nextInt(imoveis.size()));
            FaturaService.registraLeitura(imovel, random.nextDouble(100));
        }
    }

}
