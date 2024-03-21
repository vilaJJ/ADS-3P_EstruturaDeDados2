package dev.mandevilla.Utils;

public class Calculos {
    public static boolean isImpar(int value) {
        return isPar(value) == false;
    }

    public static boolean isPar(int value) {
        return (value % 2) == 0;
    }

    public static int obterMaximo(int valor1, int valor2) {
        return valor1 > valor2
            ? valor1
            : valor2;
    }
}
