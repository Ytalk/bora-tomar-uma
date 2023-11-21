package estoque_classes;

import java.util.ArrayList;
import java.util.List;

public abstract class cervejaArtesanal{
    private String nome;
    private int volume; // quantidade de cerveja produziada
    private double valor;
    private ArrayList<materiaPrima> rótulo;

    public cervejaArtesanal(receita receita){
        this.nome = receita.getNome();
        this.valor = receita.getCusto() + (receita.getCusto() * 0.25);//margem de lucro de 25%
        this.volume = receita.getPeso();//forma grosseira de calcular

        this.rótulo = new ArrayList<materiaPrima>();
        this.rótulo = receita.getReceita();
    }

    public String getNome(){
        return nome;
    }

    public int getVolume(){
        return volume;
    }

    public double getValor(){
        return valor;
    }

    public String listarRótulo(){
        StringBuilder resultado = new StringBuilder();
        
        for(materiaPrima item : this.rótulo){
            resultado.append(item.getDesc()).append("\n");
        }
        return resultado.toString();
    }
}
