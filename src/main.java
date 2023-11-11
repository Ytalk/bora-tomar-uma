package src;

import estoque.*;

public class main {

  public static void main(String[] args) {
    

    Inventario estoque = new Inventario();
     
    fermento fermento = new fermento(100, 0,"fermento");

    estoque.adicionarItem(fermento);

    estoque.listarItens();
    
   
  }

    
}
