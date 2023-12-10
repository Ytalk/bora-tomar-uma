package src;

public class Malte extends MateriaPrima {

    String descrição;

    public Malte(int peso, double custo) {
        super(peso, custo);
        descrição = "Malte";
        //TODO Auto-generated constructor stub
    }

    public String getDesc() {
        return descrição;
    }
    
}
