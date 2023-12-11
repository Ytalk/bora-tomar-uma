package estoque;

public class Agua extends MateriaPrima{

    String descrição;

    public Agua(double peso, double custo){
        super(peso, custo);
        descrição = "Água";
        
    }

    @Override
    public String getDesc() {
        return descrição;
    }

}
    