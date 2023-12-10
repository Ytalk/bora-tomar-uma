package src;

public class Lupulo extends MateriaPrima{

    String descrição;

    public Lupulo(int peso, double custo) {
        super(peso, custo);
        descrição = "Lupulo";
        //TODO Auto-generated constructor stub
    }


    public String getDesc() {
        return descrição;
    }
 
}