package br.com.gamer.classes;

import java.util.ArrayList;

public class Pergunta {
    
    private int id;
    private int categoria_id;
    private String descricao;
    private String correta;
    
    private ArrayList<Escolha> escolhas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }
    
    

    public ArrayList<Escolha> getEscolhas() {
        return escolhas;
    }

    public void setEscolhas(ArrayList<Escolha> escolhas) {
        this.escolhas = escolhas;
    }
    
    
    
}
