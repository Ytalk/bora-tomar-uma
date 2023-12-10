package src;

public abstract class Adicional extends MateriaPrima {

    String descrição;

    public Adicional(int peso, double custo) {
        super(peso, custo);
        descrição = "adicional";
        //TODO Auto-generated constructor stub
    }

    public String getDesc() {
        return descrição;
    }
    
}
