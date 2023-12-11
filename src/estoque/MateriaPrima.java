package estoque;

public abstract class MateriaPrima {
    
 private double peso; // 
 private double custo;
 private String desc; // nome do item
 
    
 public MateriaPrima(double peso, double custo){
    
    this.peso = peso;
    this.custo = custo * ( (double) peso / 1000 );//preço em kg para g
   
 }

 public void addAdicional(String adicional){
   desc = desc + " com " + adicional;
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
  public String toString() {
     return getDesc() + "  -  " + peso + "g " + " -  " + String.format("%.2f", getCusto()) + "R$";
  }
  

}
