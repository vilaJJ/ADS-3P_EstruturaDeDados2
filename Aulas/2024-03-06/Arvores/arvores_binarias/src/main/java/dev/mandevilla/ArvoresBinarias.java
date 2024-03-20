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
        arvoreBinaria.inserir(10);

        List<Integer> listaPreOrdem = new ArrayList<Integer>();
        listaPreOrdem = arvoreBinaria.obterPreOrdem(arvoreBinaria.obterRaiz(), listaPreOrdem);
        
        System.out.println("\nLista normal: " + lista);
        System.out.println("Lista Pré-Ordem: " + listaPreOrdem);

        List<Integer> listaEmOrdem = new ArrayList<Integer>();
        listaEmOrdem = arvoreBinaria.obterEmOrdem(arvoreBinaria.obterRaiz(), listaEmOrdem);
        
        System.out.println("\nLista normal: " + lista);
        System.out.println("Lista Em-Ordem: " + listaEmOrdem);

        List<Integer> listaPosOrdem = new ArrayList<Integer>();
        listaPosOrdem = arvoreBinaria.obterPosOrdem(arvoreBinaria.obterRaiz(), listaPosOrdem);
        
        System.out.println("\nLista normal: " + lista);
        System.out.println("Lista Pós-Ordem: " + listaPosOrdem);
    }
}