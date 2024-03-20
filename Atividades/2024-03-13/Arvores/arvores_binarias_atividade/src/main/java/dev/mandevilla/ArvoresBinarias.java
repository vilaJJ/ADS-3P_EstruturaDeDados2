package dev.mandevilla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.mandevilla.Services.ArvoreBinariaService;

public class ArvoresBinarias {
    public static void main(String[] args) {
        System.out.println("Atividade avaliativa - Árvores binárias de busca\n");

        var lista = Arrays.asList(
            15,
            10,
            20,
            5,
            12,
            18,
            25,
            3,
            7,
            11,
            14,
            17,
            22,
            2,
            6,
            9,
            13,
            16,
            19,
            24,
            27,
            1,
            4,
            8,
            23,
            26,
            29,
            30,
            31,
            32
        );

        var arvoreBinaria = new ArvoreBinariaService();

        arvoreBinaria.inserir(lista);

        // a. Crie um método que apresente a altura de uma árvore binária;
        var alturaArvore = arvoreBinaria.obterAltura(arvoreBinaria.obterRaiz());
        System.out.println("A altura da árvore binária é: " + alturaArvore);

        // b. Crie um método que apresente a altura de determinado nó de uma árvore binária;

        // d. Crie um método que apresente os nós internos de uma árvore binária;
        List<Integer> nosInternos = new ArrayList<>();
        nosInternos = arvoreBinaria.obterNosInternos(arvoreBinaria.obterRaiz(), nosInternos);
        System.out.println(nosInternos);
    }
}