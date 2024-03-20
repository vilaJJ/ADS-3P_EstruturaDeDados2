package dev.mandevilla.Models;

public class NoModel {
    private int _valor;
    private NoModel _esquerdo;
    private NoModel _direito;

    public NoModel(int valor) {
        _valor = valor;
        _esquerdo = null;
        _direito = null;
    }

    // _valor : int
    public int getValor() {
        return _valor;
    }

    public void setValor(int _valor) {
        this._valor = _valor;
    }

    // _esquerdo : NoModel
    public NoModel getEsquerdo() {
        return _esquerdo;
    }

    public void setEsquerdo(NoModel esquerdo) {
        this._esquerdo = esquerdo;
    }

    public void setEsquerdo(int valor) {
        this._esquerdo = new NoModel(valor);
    }

    // _direito : NoModel
    public NoModel getDireito() {
        return _direito;
    }

    public void setDireito(NoModel direito) {
        this._direito = direito;
    }

    public void setDireito(int valor) {
        this._direito = new NoModel(valor);
    }
}
