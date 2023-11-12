package estoque;

import java.util.ArrayList;

public class Inventario {
    
    
    private ArrayList <materiaPrima> materias;
    private ArrayList <cervejaArtesanal> cervejas;
    
   public Inventario(){
    this.materias = new ArrayList<materiaPrima>();
    this.cervejas = new ArrayList<cervejaArtesanal>();
   }

   public void adicionarItem(materiaPrima item){
    materias.add(item);
   }

   public void listarItens(){
    
    for(materiaPrima item : materias ){
        System.out.println(item);

    }
    
   }


   public void adicionarCerveja(cervejaArtesanal cerveja){
    cervejas.add(cerveja);
   }



}
