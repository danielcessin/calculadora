package br.com.calculadora.model;

import java.util.Date;

public class Anuncio {
	
	private String nomeAnuncio;
	private String cliente;
	private Date dataInicio;
	private Date dataFim;
	private Double investimentoPorDia;
	
	private Integer totalVisualizacoes = 0;
	private Integer quantidadeClicks;
	private Integer quantidadeCompartilhamentos;
	private Double valorInvestido;
	
	
	//construtores
	//construtor padrão
	public Anuncio() {
		super();
	}
	
	//construtor com parâmetro
	public Anuncio(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public Integer calcularClicks() {
		//12% das pessoas que visualizam, clicam
		return (this.totalVisualizacoes*12) /100;
	}
	
	public Integer calcularCompartilhamentos() {
		//15% das pessoas que clicam, compartilham
		return (this.quantidadeClicks*15) /100;
		
	}
	
	public void adicionarVisualizacoes(Integer qtdeVisualizacoes) {
		//this.totalVisualizacoes = this.totalVisualizacoes +qtdeVisualizacoes;
		this.totalVisualizacoes+=qtdeVisualizacoes;
	}
	

	// getters e setters
	public String getNomeAnuncio() {
		return "Anuncio:" + nomeAnuncio;
	}


	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public Double getInvestimentoPorDia() {
		return investimentoPorDia;
	}


	public void setInvestimentoPorDia(Double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}


	public Integer getTotalVisualizacoes() {
		return totalVisualizacoes;
	}


	public void setTotalVisualizacoes(Integer totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;
	}


	public Integer getQuantidadeClicks() {
		return quantidadeClicks;
	}


	public void setQuantidadeClicks(Integer quantidadeClicks) {
		this.quantidadeClicks = quantidadeClicks;
	}


	public Integer getQuantidadeCompartilhamentos() {
		return quantidadeCompartilhamentos;
	}


	public void setQuantidadeCompartilhamentos(Integer quantidadeCompartilhamentos) {
		this.quantidadeCompartilhamentos = quantidadeCompartilhamentos;
	}


	public Double getValorInvestido() {
		return valorInvestido;
	}


	public void setValorInvestido(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
	
	
	

}
