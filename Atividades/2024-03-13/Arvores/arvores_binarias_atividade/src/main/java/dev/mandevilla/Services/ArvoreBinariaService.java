package dev.mandevilla.Services;

import java.util.List;

import dev.mandevilla.Models.NoModel;

public class ArvoreBinariaService {
    protected NoModel raiz;

    public ArvoreBinariaService() {
        raiz = null;
    }

    public NoModel obterRaiz() {
        return raiz;
    }

    public void inserir(int valorRaiz) {
        if (raiz == null) {
            raiz = new NoModel(valorRaiz);
        }
        else {
            inserir(valorRaiz, raiz);
        }        
    }

    public List<Integer> obterPreOrdem(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista.add(no.getValor());
            lista = obterPreOrdem(no.getEsquerdo(), lista);
            lista = obterPreOrdem(no.getDireito(), lista);
        }

        return lista;
    }

    public List<Integer> obterEmOrdem(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterEmOrdem(no.getEsquerdo(), lista);
            lista.add(no.getValor());
            lista = obterEmOrdem(no.getDireito(), lista);
        }

        return lista;
    }

    public List<Integer> obterPosOrdem(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterPosOrdem(no.getEsquerdo(), lista);
            lista = obterPosOrdem(no.getDireito(), lista);
            lista.add(no.getValor());
        }

        return lista;
    }

    public void inserir(List<Integer> valores) {
        for (Integer valor : valores) {
            inserir(valor);
        }
    }

    public NoModel buscar(int valor) {
        if (raiz == null) {
            return null;
        }
        return buscar(valor, raiz);
    }

    public boolean isFolha(NoModel no) {
        return no.getEsquerdo() == null && no.getDireito() == null;
    }

    // Métodos privados

    private void inserir(int valor, NoModel noAtual) {
        if (valor <= noAtual.getValor()) {
            if (noAtual.getEsquerdo() == null) {
                noAtual.setEsquerdo(valor);
            }
            else {
                inserir(valor, noAtual.getEsquerdo());
            }
        }
        else {
            if (noAtual.getDireito() == null) {
                noAtual.setDireito(valor);
            }
            else {
                inserir(valor, noAtual.getDireito());
            }
        }
    }

    private NoModel buscar(int valor, NoModel noAtual) {
        if (valor == noAtual.getValor()) {
            return noAtual;
        }
        else if (valor <= noAtual.getValor()) {
            if (noAtual.getEsquerdo() == null) {
                return null;
            }
            else {
                return buscar(valor, noAtual.getEsquerdo());
            }
        }
        else {
            if (noAtual.getDireito() == null) {
                return null;
            }
            else {
                return buscar(valor, noAtual.getDireito());
            }
        }
    }
} 
