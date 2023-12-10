package src;

public abstract class MateriaPrima {
    
 private double peso; // 
 private double custo;
 private String desc; // nome do item
    
 public MateriaPrima(int peso, double custo){
    this.peso = peso;
    this.custo = custo * ( (double) peso / 1000 );//preço em kg para g
 }

  public String getDesc() {
    return "null";
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
