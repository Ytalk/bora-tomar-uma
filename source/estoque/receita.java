package estoque_classes;

import java.util.ArrayList;
import estoque_classes.materiaPrima;

public class receita{
    private String nome;
    private ArrayList<materiaPrima> ingredientes;

    public receita(String nome){
        this.nome = nome;
        this.ingredientes = new ArrayList<materiaPrima>();
    }

    public void addIngrediente(materiaPrima ingrediente){
        ingredientes.add(ingrediente);
    }

    public String getNome(){
        return nome;
    }

    public ArrayList<materiaPrima> getReceita(){
        return ingredientes;
    }

    public int getPeso(){
        int pesoTotal = 0;

        for(materiaPrima ingrediente : ingredientes){
            pesoTotal += ingrediente.getPeso();
        }
        return pesoTotal;
    }
    
    public double getCusto(){
        double custoDaReceita = 0;

        for(materiaPrima ingrediente : ingredientes){
            custoDaReceita += ingrediente.getCusto();
        }
        return custoDaReceita;
    }

    public String listarReceita(){
        String receita = "\n======================================================\n\t\tRECEITA" + nome.toUpperCase() + "======================================================\n\n";
        
        for(materiaPrima ingrediente : ingredientes){
            receita = receita + ingrediente.getPeso() + " gramas de " + ingrediente.getDesc() + "\t-\t" + ingrediente.getCusto() + "\n";
        }
        return receita;
    }
}