package br.com.primeiroprojeto;

public class PrimeiraClasse {

	public static void main(String[] args) {
		String ambiente = args[0];
		
		if(ambiente.equals("DEV")) {
			System.out.print("Hello World " + ambiente);
		}
	}

}
