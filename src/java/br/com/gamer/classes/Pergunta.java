package br.com.gamer.classes;

import java.util.ArrayList;

public class Pergunta {
    
    private int id;
    private String descricao;
    private int correta;
    
    private ArrayList<Escolha> escolhas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCorreta() {
        return correta;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

    public ArrayList<Escolha> getEscolhas() {
        return escolhas;
    }

    public void setEscolhas(ArrayList<Escolha> escolhas) {
        this.escolhas = escolhas;
    }
    
    
    
}
