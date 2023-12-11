package app;

import estoque.MateriaPrima;
import estoque.CervejaArtesanal;
import estoque.Inventario;

import java.util.NoSuchElementException;


public class Financeiro{
    double saldo;
    Inventario estoque;

    public Financeiro(){
        this.saldo = 5000;
        this.estoque = new Inventario();
    }

    public void venderCerveja(String name){
        CervejaArtesanal cerveja;
        
        try{
            cerveja = this.estoque.getCerveja(name);
        } 
        catch(NoSuchElementException e) {
            cerveja = null;
        }

        if(cerveja != null){
            this.estoque.deletarCerveja(name);
            this.saldo += cerveja.getValor();
        }
        else{
            System.out.println("erro ao vender cerveja.\n");
        }
    }

    public void comprarItem(MateriaPrima item){
        if(saldo >= item.getCusto()){
            saldo -= item.getCusto();
            this.estoque.adicionarItem(item);
        }
        else
            System.out.println("saldo insuficiente.\n");
    }


}