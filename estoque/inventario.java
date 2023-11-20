package estoque;

import java.util.ArrayList;
import java.util.List;

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

    public String[] listarItens() {
        String[] itens = new String[materias.size()];

        for (int i = 0; i < materias.size(); i++) {
            itens[i] = materias.get(i).getDesc(); // Supondo que sua classe materiaPrima tem um método getNome()
        }

        return itens;
    }

    public List<materiaPrima> getMaterias() {
        return materias;
    }


   public void adicionarCerveja(cervejaArtesanal cerveja){
    cervejas.add(cerveja);
   }



}
