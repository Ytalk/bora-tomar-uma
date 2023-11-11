package estoque;

public abstract class materiaPrima {
    
 private int peso; // 
 private double custo;
 private String desc; // nome do item
    
 public materiaPrima(int peso, double custo, String desc){
    this.peso = peso;
    this.custo = custo;
    this.desc = desc;
 }

 
 public String toString(){
   return "PREÇO: " + custo + "R$" + "PESO: " + peso + "g " + desc;
  }

}
