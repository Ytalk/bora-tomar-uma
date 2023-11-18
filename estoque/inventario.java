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

    public String[] listarItens() {
        String[] itens = new String[materias.size()];

        for (int i = 0; i < materias.size(); i++) {
            itens[i] = materias.get(i).getDesc(); // Supondo que sua classe materiaPrima tem um método getNome()
        }

        return itens;
    }


   public void adicionarCerveja(cervejaArtesanal cerveja){
    cervejas.add(cerveja);
   }



}
