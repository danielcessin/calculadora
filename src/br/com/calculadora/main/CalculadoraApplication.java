package br.com.calculadora.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.calculadora.model.Anuncio;


public class Calculadora {

List<Anuncio> listaAnuncios = new ArrayList<Anuncio>();


public static void main(String[] args) throws ParseException {

System.out.println("Criar anuncio \n");

System.out.println("Digite o nome do anúncio");
Scanner scanner = new Scanner(System.in);
String nomeAnuncio= scanner.nextLine();

System.out.println("Digite o nome do cliente");
String cliente= scanner.nextLine();

System.out.println("Digite a data de início");
String dataInicioS= scanner.nextLine();

Date dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioS);

System.out.println("Digite a data de término");
String dataFimS= scanner.nextLine();

Date dataFim = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicioS);

System.out.println("Digite o valor investido por dia");
Double investimentoPorDia = scanner.nextDouble();


Anuncio anuncio = new Anuncio();
anuncio.setNomeAnuncio(nomeAnuncio);
anuncio.setCliente(cliente);
anuncio.setDataInicio(dataInicio);
anuncio.setDataFim(dataFim);
anuncio.setInvestimentoPorDia(investimentoPorDia);

System.out.println("Anuncio criado com sucesso");
System.out.println(anuncio.toString());


scanner.close();



}

//"public" -> modificador de acesso -> public, private, protected..
//"void" -> tipo de retorno do método
private static Integer calcularPotencialAlcance(Double valoInvestido) {

int quantidadeTotalVisualizacoes = 0;

//calcular quantidade total de visualizacoess
Anuncio anuncioOriginal = new Anuncio(valoInvestido);

// 30 pessoas visualizam o anuncio original a cada 1 real investido
//cast -> conversão de valores
anuncioOriginal.adicionarVisualizacoes((int)(valoInvestido*30));

//calculo da quantidade de clicks (12% das visualizacoes)
int clicks =  anuncioOriginal.calcularClicks();
anuncioOriginal.setQuantidadeClicks(clicks);

//calculo quantidade de compartilhamentos (15% clicks)
int compartilhamentos = anuncioOriginal.calcularCompartilhamentos();
anuncioOriginal.setQuantidadeCompartilhamentos(compartilhamentos);

//cada compartilhamento gera 40 novas visualizacoes
anuncioOriginal.adicionarVisualizacoes(
anuncioOriginal.getQuantidadeCompartilhamentos()*40);

quantidadeTotalVisualizacoes += anuncioOriginal.getTotalVisualizacoes();

int novasVisualizacoes = (anuncioOriginal.getQuantidadeCompartilhamentos()*40);


//compartilhamento do anuncio, máximo 4 vezes
for(int i=0; i < 4;i++) {

Anuncio anuncioCompartilhado = new Anuncio();
anuncioCompartilhado.adicionarVisualizacoes(novasVisualizacoes);

//calculo da quantidade de clicks (12% das visualizacoes)
int clicksAnuncioCompartilhado =  anuncioCompartilhado.calcularClicks();
anuncioCompartilhado.setQuantidadeClicks(clicks);

//calculo quantidade de compartilhamentos (15% clicks)
int compartilhamentosAnuncioCompartilhado = anuncioCompartilhado.calcularCompartilhamentos();
anuncioCompartilhado.setQuantidadeCompartilhamentos(compartilhamentos);

//cada compartilhamento gera 40 novas visualizacoes
anuncioCompartilhado.adicionarVisualizacoes(
anuncioCompartilhado.getQuantidadeCompartilhamentos()*40);

quantidadeTotalVisualizacoes += anuncioCompartilhado.getTotalVisualizacoes();

}

return quantidadeTotalVisualizacoes;
}

}
