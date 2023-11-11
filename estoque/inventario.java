package estoque;

import java.util.ArrayList;

public class inventario {
    
    
    private ArrayList <materiaPrima> materias;
    private ArrayList <cervejaArtesanal> cervejas;
    
   public inventario(){
    this.materias = new ArrayList<materiaPrima>();
    this.cervejas = new ArrayList<cervejaArtesanal>();
   }

   public void adicionarItem(materiaPrima item){
    materias.add(item);
   }

   public void adicionarCerveja(cervejaArtesanal cerveja){
    cervejas.add(cerveja);
   }



}
