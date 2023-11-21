package estoque_classes;

import java.util.ArrayList;
import java.util.List;

public abstract class cervejaArtesanal{
    private int volume; // quantidade de cerveja produziada
    private double valor;
    private ArrayList<materiaPrima> rótulo;

    public cervejaArtesanal(receita receita){
        this.valor = receita.getCusto() + (receita.getCusto() * 0.25);//margem de lucro de 25%
        this.volume = receita.getPeso();//forma grosseira de calcular
    }

    public int getVolume(){
        return volume;
    }

    public double getValor(){
        return valor;
    }
}
