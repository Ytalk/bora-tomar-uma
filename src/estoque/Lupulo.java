package estoque;

public class Lupulo extends MateriaPrima{

    String descrição;
    Double peso;

    public Lupulo(double peso, double custo) {
        super(peso, custo);
        descrição = "Lupulo";
        
    }

    public void addAdicional(String adicional){
        descrição = descrição + " com " + adicional;
    }

    public String getDesc() {
        return descrição;
    }
 
}