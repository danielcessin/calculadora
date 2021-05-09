package br.com.calculadora.main;

import java.util.Scanner;

import br.com.calculadora.model.Anuncio;

public class CalculadoraApplication {

	public static void main(String[] args) {
		
		System.out.println("Digite o custo total da campanha");
		Scanner scanner = new Scanner(System.in);
		
		Double custoTotalCampanha = scanner.nextDouble();
		
		System.out.println("Resultado: " + calcularPotencialAlcance(custoTotalCampanha));
		
		
	}
	
		//"public" -> modificador de acesso -> public, private, protected..
		//"void" -> tipo de retorno do método
		private static Integer calcularPotencialAlcance(Double valoInvestido) {
			
			int quantidadeTotalVisualizacoes = 0;
			
			//calcular quantidade total de visualizacoes
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
