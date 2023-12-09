package estoque;

import java.util.ArrayList;


public class Receita{
    private String nome;
    private ArrayList<MateriaPrima> ingredientes;

    public Receita(String nome){
        this.nome = nome;
        this.ingredientes = new ArrayList<MateriaPrima>();
    }

    public void addIngrediente(MateriaPrima ingrediente){
        ingredientes.add(ingrediente);
    }

    public String getNome(){
        return nome;
    }

    public String getReceita(){
        
     for(MateriaPrima item : ingredientes){
         return item.getDesc();
     }
     return null;


    }

    public int getPeso(){
        int pesoTotal = 0;

        for(MateriaPrima ingrediente : ingredientes){
            pesoTotal += ingrediente.getPeso();
        }
        return pesoTotal;
    }
    
    public double getCusto(){
        double custoDaReceita = 0;

        for(MateriaPrima ingrediente : ingredientes){
            custoDaReceita += ingrediente.getCusto();
        }
        return custoDaReceita;
    }

    public String listarReceita(){
        String receita = "\n======================================================\n\t\tRECEITA" + nome.toUpperCase() + "\n======================================================\n\n";
        
        for(MateriaPrima ingrediente : ingredientes){
            receita = receita + ingrediente.getPeso() + " gramas de " + ingrediente.getDesc() + "\t-\t" + ingrediente.getCusto() + "\n";
        }
        return receita;
    }


    @Override
    public String toString() {
        
        return getNome();
    }

}