/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.igorsantana;

/**
 *
 * @author 45881410823
 */
public class Exercicio {
    public static void main(String[] args) {
        exemploInt(); // int e Integer
        exemploDouble(); // double e Double
        exemploChar(); // char e Character
        exemploBoolean(); // boolean e Boolean
    }

    // Método para trabalhar com int e Integer
    public static void exemploInt() {
        int primitivaInt = 14;
        Integer wrapperInt = primitivaInt;
        System.out.println(wrapperInt);
    }

    // Método para trabalhar com double e Double
    public static void exemploDouble() {
        double primitivaDouble = 3.14;
        Double wrapperDouble = primitivaDouble;
        System.out.println(wrapperDouble);
    }

    // Método para trabalhar com boolean e Boolean
    public static void exemploChar() {
        char primitivaChar = 'A';
        Character wrapperChar = primitivaChar;
        System.out.println(wrapperChar);
    }

    // Método para trabalhar com boolean e Boolean
    public static void exemploBoolean() {
        boolean primitivaBoolean = true;
        Boolean wrapperBoolean = primitivaBoolean;
        System.out.println(wrapperBoolean);
    }
}