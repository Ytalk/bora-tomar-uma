package src;

public class Agua extends MateriaPrima{

    String descrição;

    public Agua(int peso, double custo){
        super(peso, custo);
        descrição = "Água";
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getDesc() {
        return descrição;
    }
    
}
