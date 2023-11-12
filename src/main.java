package src;

import estoque.*;

public class main {

  public static void main(String[] args) {
    

    Inventario estoque = new Inventario();
     
    fermento fermento = new fermento(100, 0,"fermento");
    malte malte = new malte(200,1,"malte");

    estoque.adicionarItem(fermento);
    estoque.adicionarItem(malte);

    estoque.listarItens();
    
   
  }

    
}
