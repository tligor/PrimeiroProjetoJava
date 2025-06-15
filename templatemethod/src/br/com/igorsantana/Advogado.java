package br.com.igorsantana;

public class Advogado extends Trabalhador {

	@Override
	protected void trabalhar() {
	}
	
	@Override
	protected void voltarParaCasa() {
		System.out.println("Voltar para casa de carro...");
	}
}
