
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 45881410823
 */
public class ExemploIdade {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a sua idade: ");
        int idade = s.nextInt();
        String idadeSt = getIdade(idade);
        System.out.println(idadeSt);
    }

    public static String getIdade(int idade) {
        if(idade >=0 && idade <=5){
            return "Você é um bebê";
        }else if (idade >= 6 && idade <= 10) {
            return "Você é uma criança";
        }else if (idade >= 10 && idade <=18){
            return "Você é um adolescente";
        }else {
            return "Você é um adulto";
        }
    }
}


