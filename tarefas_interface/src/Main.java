package src;

import src.model.PessoaFisica;
import src.model.PessoaJuridica;

public class Main {
    public static void main(String[] args) {
        // Cadastro PF
        PessoaFisica pf = new PessoaFisica("Laércio Louis", "Rua A, 123", "91234-5678", "123.456.789-00");
        pf.exibirInformacoes();

        System.out.println(); // separar linhas

        // cadastro PJ
        PessoaJuridica pj = new PessoaJuridica("Burger King", "Av. do Hamburguer, 888", "8778-8778", "12.345.678/0001-99");
        pj.exibirInformacoes();
    }
}