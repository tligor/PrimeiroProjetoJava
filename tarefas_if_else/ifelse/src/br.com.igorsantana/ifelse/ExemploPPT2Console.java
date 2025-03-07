/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author 45881410823
 */
public class ExemploPPT2Console {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número: ");

        int result = s.nextInt();
        
        if (result >= 1 && result < 5){
            System.out.println("Resultado maior ou igual a 1 e menor que 5");
        }else if(result >= 5 && result < 8){
            System.out.println("Resultado maior ou igual a 5 e menor que 8");
        }else{
            System.out.println("Resultado menor que 1");
        }
    }
}
