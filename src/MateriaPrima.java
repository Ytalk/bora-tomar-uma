package src;

public abstract class MateriaPrima {
    
 private double peso; // 
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

   public double getPeso() {
       return peso;
   }

  public void setPeso(double d){
    this.peso = d;
  }
 
  @Override
  public String toString(){
    return desc + "  -  " + peso + "g ";
   }

}
