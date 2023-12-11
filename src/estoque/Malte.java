package estoque;

public class Malte extends MateriaPrima {

    String descrição;
    Double peso;

    public Malte(double peso, double custo) {
        super(peso, custo);
        descrição = "Malte";
        
    }

    public void addAdicional(String adicional){
        descrição = descrição + " com " + adicional;
    }

    public String getDesc() {
        return descrição;
    }
    
}