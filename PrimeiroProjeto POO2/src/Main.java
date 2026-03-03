import dto.Estatistica;
//import repositorio.EstatisticaRepositorio;
import service.*;
import service.HtmlService;
import service.PersistenciaService;
import service.XmlService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            DadosService dadosService = new DadosService("dados_10000.txt");
            CalculadoraEstatistica calculadora = new CalculadoraEstatistica();
           // EstatisticaRepositorio repository = new EstatisticaRepositorio();
            PersistenciaService persistencia = new PersistenciaService();
            XmlService xmlService = new XmlService();
            HtmlService htmlService = new HtmlService();

            List<Double> dados = dadosService.buscarDados();

            Estatistica estatistica = calculadora.calcular(dados);

            //repository.salvar(estatistica);
            persistencia.salvar(estatistica);
            xmlService.gerar(estatistica);
            htmlService.gerar(estatistica);

            System.out.println("Processo concluído com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}