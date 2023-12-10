package src;

public class Fermento extends MateriaPrima {

    String descrição;

    public Fermento(int peso, double custo) {
        super(peso, custo);
        descrição = "Fermento";
        //TODO Auto-generated constructor stub
    }
    
    public String getDesc() {
        return descrição;
    }
}
