package estoque;

public abstract class MateriaPrima {
    
 private int peso; // 
 private double custo;
 private String desc; // nome do item
    
 public MateriaPrima(int peso, double custo, String desc){
    this.peso = peso;
    this.custo = custo;
    this.desc = desc;
 }

   public String getDesc() {
       return desc;
   }

   public double getCusto() {
       return custo;
   }

   public int getPeso() {
       return peso;
   }

   

 public String toString(){
   return "PREÇO: " + custo + "R$" + "PESO: " + peso + "g " + desc;
  }

}
