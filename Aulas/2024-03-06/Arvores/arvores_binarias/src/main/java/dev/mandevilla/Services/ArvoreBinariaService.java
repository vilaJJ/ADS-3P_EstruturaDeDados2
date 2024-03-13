package dev.mandevilla.Services;

import java.util.List;

import dev.mandevilla.Models.NoModel;

public class ArvoreBinariaService {
    private NoModel raiz;

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

    public List<Integer> obterEmOrdem(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista = obterEmOrdem(no.getEsquerdo(), lista);
            lista.add(no.getValor());
            lista = obterEmOrdem(no.getDireito(), lista);
        }

        return lista;
    }

    public List<Integer> obterPreOrdem(NoModel no, List<Integer> lista) {
        if (no != null) {
            lista.add(no.getValor());
            lista = obterPreOrdem(no.getEsquerdo(), lista);
            lista = obterPreOrdem(no.getDireito(), lista);
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

    public void remover(int valor) {
        if (raiz == null) {
            return;
        }
        remover(valor, raiz);
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

    private void remover(int valor, NoModel noAtual) {
        if (valor == noAtual.getValor()) {
            // Nó folha
            if (noAtual.getEsquerdo() == null && noAtual.getDireito() == null) {
                noAtual = null;
            }
            // Nó com um filho
            else if (noAtual.getEsquerdo() == null) {
                noAtual = noAtual.getDireito();
            }
            else if (noAtual.getDireito() == null) {
                noAtual = noAtual.getEsquerdo();
            }
            // Nó com dois filhos
            else {
                NoModel noSubstituo = obterMenorNo(noAtual.getDireito());
                noAtual.setValor(noSubstituo.getValor());
                remover(noSubstituo.getValor(), noAtual.getDireito());
            }
        }
        else if (valor <= noAtual.getValor()) {
            if (noAtual.getEsquerdo() != null) {
                remover(valor, noAtual.getEsquerdo());
            }
        }
        else {
            if (noAtual.getDireito() != null) {
                remover(valor, noAtual.getDireito() );
            }
        }
    }

    private NoModel obterMenorNo(NoModel noAtual) {
        while (noAtual.getEsquerdo() != null) {
            noAtual = noAtual.getEsquerdo();
        }
        return noAtual;
    }
} 
