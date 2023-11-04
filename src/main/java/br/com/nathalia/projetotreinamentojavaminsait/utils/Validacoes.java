package br.com.nathalia.projetotreinamentojavaminsait.utils;

public class Validacoes {

    public boolean tipoValido(Integer tipo){
        if(tipo == 0 || tipo == 1){
            return true;
        }
        return false;
    }

    public boolean nomeValido(String nome){
        return nome.matches("[a-zA-Z\s]+");
    }

    public boolean tamanhoUf(String uf){
        if(uf.length() == 2){
            return true;
        }
        return false;
    }
}
