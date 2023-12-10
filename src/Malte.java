package src;

public class Malte extends MateriaPrima {

    String descrição;

    public Malte(int peso, double custo) {
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