package dev.mandevilla;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.mandevilla.Services.ArvoreBinariaService;

public class ArvoresBinarias {
    public static void main(String[] args) {
        var lista = Arrays.asList(15, 21, 4, 45, 23, 9, 43);

        var arvoreBinaria = new ArvoreBinariaService();

        arvoreBinaria.inserir(lista);

        List<Integer> listaEmOrdem = new ArrayList<Integer>();
        listaEmOrdem = arvoreBinaria.obterPreOrdem(arvoreBinaria.obterRaiz(), listaEmOrdem);

        System.out.println("Lista normal: " + lista);
        System.out.println("Lista Pré-Ordem: " + listaEmOrdem);
    }
}