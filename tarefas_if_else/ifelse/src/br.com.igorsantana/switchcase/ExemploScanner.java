/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package switchcase;

import java.util.Scanner;

/**
 *
 * @author 45881410823
 */
public class ExemploScanner {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idade = s.nextInt();
        System.out.println("Você tem " + idade + " anos.");
    }
}
