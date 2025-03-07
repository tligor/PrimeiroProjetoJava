/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author 45881410823
 */
public class ExemploPPT1Console {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um número: ");

        int result = s.nextInt();
        if (result >= 1){
            System.out.println("É maior ou igual a 1");
        }else{
            System.out.println("É menor que 1");
        }
    }
}
