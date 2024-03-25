package dev.mandevilla.Exercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.mandevilla.Models.NoModel;
import dev.mandevilla.Services.ArvoreBinariaService;
import dev.mandevilla.Utils.Calculos;

public class ArvoreBinariaExercicio extends ArvoreBinariaService {
    final private static List<Integer> lista = Arrays.asList(
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

    // a. Crie um método que apresente a altura de uma árvore binária;
    public int obterAltura(NoModel no) {
        if (no == null) {
            return 0;
        }

        var alturaEsquerda = obterAltura(no.getEsquerdo());
        var alturaDireita = obterAltura(no.getDireito());

        if (alturaEsquerda > alturaDireita) {
            return alturaEsquerda + 1;
        }
        else {
            return alturaDireita + 1;
        }
    }

    // b. Crie um método que apresente a altura de determinado nó de uma árvore binária;
    public int obterAlturaPeloNo(NoModel no) {
        if (no == null || isFolha(no)) {
            return 0;
        }

        var alturaEsquerda = obterAlturaPeloNo(no.getEsquerdo());
        var alturaDireita = obterAlturaPeloNo(no.getDireito()) + 1;

        var maiorValor = Calculos.obterMaximo(alturaEsquerda, alturaDireita);
        return maiorValor;
    }

    // c. Crie um método que apresente os nós folha de uma árvore binária;
    public List<Integer> obterNosFolhas(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterNosFolhas(no.getEsquerdo(), lista);

            if (no != raiz && isFolha(no)) {
                lista.add(no.getValor());
            }
            
            lista = obterNosFolhas(no.getDireito(), lista);
        }

        return lista;
    }

    // d. Crie um método que apresente os nós internos de uma árvore binária;
    public List<Integer> obterNosInternos(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterNosInternos(no.getEsquerdo(), lista);

            if (no != raiz && isFolha(no) == false) {
                lista.add(no.getValor());
            }
            
            lista = obterNosInternos(no.getDireito(), lista);
        }

        return lista;
    }

    // e. Crie um método que apresente somente os valores ímpares e menores de 23 em ordem;
    public List<Integer> obterEmOrdemImparesAndMenores23(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterEmOrdemImparesAndMenores23(no.getEsquerdo(), lista);

            if (Calculos.isImpar(no.getValor()) && no.getValor() < 23) {
                lista.add(no.getValor());
            }
            
            lista = obterEmOrdemImparesAndMenores23(no.getDireito(), lista);
        }

        return lista;
    }

    // f. Crie um método que apresente somente os valores pares maiores que 14 em pós-ordem.
    public List<Integer> obterPosOrdemParesAndMaiores14(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterPosOrdemParesAndMaiores14(no.getEsquerdo(), lista);
            lista = obterPosOrdemParesAndMaiores14(no.getDireito(), lista);

            if (Calculos.isPar(no.getValor()) && no.getValor() > 14) {
                lista.add(no.getValor());
            }            
        }

        return lista;
    }

    // Executa todas as questões
    public static void executar() {
        var arvoreBinaria = new ArvoreBinariaExercicio();

        arvoreBinaria.inserir(lista);

        // a. Crie um método que apresente a altura de uma árvore binária;
        var alturaArvore = arvoreBinaria.obterAltura(arvoreBinaria.obterRaiz());
        System.out.println("\na. A altura da árvore binária é: " + alturaArvore);
        
        // b. Crie um método que apresente a altura de determinado nó de uma árvore binária;
        var valorProcurarAltura = 17;
        var no = arvoreBinaria.buscar(valorProcurarAltura);
        var alturaNo = arvoreBinaria.obterAlturaPeloNo(no);
        System.out.println("\nb. A altura do nó '" + valorProcurarAltura + "' é: " + alturaNo);

        // c. Crie um método que apresente os nós folha de uma árvore binária;
        List<Integer> nosFolhas = new ArrayList<>();
        nosFolhas = arvoreBinaria.obterNosFolhas(arvoreBinaria.obterRaiz(), nosFolhas);
        System.out.println("\nc. Os nós folhas da árvore binária é: " + nosFolhas);

        // d. Crie um método que apresente os nós internos de uma árvore binária;
        List<Integer> nosInternos = new ArrayList<>();
        nosInternos = arvoreBinaria.obterNosInternos(arvoreBinaria.obterRaiz(), nosInternos);
        System.out.println("\nd. Os nós internos da árvore binária é: " + nosInternos);

        // e. Crie um método que apresente somente os valores ímpares e menores de 23 em ordem;
        List<Integer> emOrdemImparesAndMenores23 = new ArrayList<>();
        emOrdemImparesAndMenores23 = arvoreBinaria.obterEmOrdemImparesAndMenores23(arvoreBinaria.obterRaiz(), emOrdemImparesAndMenores23);
        System.out.println("\ne. Os valores ímpares e menores que 23 da árvore binária é: " + emOrdemImparesAndMenores23);

        // f. Crie um método que apresente somente os valores pares maiores que 14 em pós-ordem.
        List<Integer> posOrdemParesAndMaiores14 = new ArrayList<>();
        posOrdemParesAndMaiores14 = arvoreBinaria.obterPosOrdemParesAndMaiores14(arvoreBinaria.obterRaiz(), posOrdemParesAndMaiores14);
        System.out.println("\nf. Os valores pares e maiores que 14 da árvore binária é: " + posOrdemParesAndMaiores14);
    }
}
