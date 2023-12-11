package estoque;

import java.util.ArrayList;


public class Receita{
    private String nome;
    private ArrayList<MateriaPrima> ingredientes;

    public Receita(String nome){
        this.nome = nome;
        this.ingredientes = new ArrayList<MateriaPrima>();
    }


    public void addIngrediente(MateriaPrima novoIngrediente){
        boolean existente = false;
        for(MateriaPrima ingrediente : ingredientes){
            if(novoIngrediente.getDesc().equals(ingrediente.getDesc())){
                ingrediente.setPeso(ingrediente.getPeso() + novoIngrediente.getPeso());
                existente = true;
            }
        }
        if(existente == false){
            ingredientes.add(novoIngrediente);
        }
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

    public ArrayList<MateriaPrima> getConteudo(){
        return ingredientes;
    }

    public double getPeso(){
        double pesoTotal = 0;

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

    public String[] listarIngredientes(){
 
        String [] itens= new String[ingredientes.size()];
      
        for(int i = 0 ; i < ingredientes.size(); i++){
            itens[i] = ingredientes.get(i).toString();
        }
        return itens;
    }


    @Override
    public String toString(){
        
        return getNome();
    }

}