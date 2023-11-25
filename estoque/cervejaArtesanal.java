package estoque;

import java.util.ArrayList;


public abstract class CervejaArtesanal{
    private String nome;
    private int volume; // quantidade de cerveja produziada
    private double valor;
    private ArrayList<MateriaPrima> rótulo;

    public CervejaArtesanal(Receita receita){
        this.nome = receita.getNome();
        this.valor = receita.getCusto() + (receita.getCusto() * 0.25);//margem de lucro de 25%
        this.volume = receita.getPeso();//forma grosseira de calcular

        this.rótulo = new ArrayList<MateriaPrima>();
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
        
        for(MateriaPrima item : this.rótulo){
            resultado.append(item.getDesc()).append("\n");
        }
        return resultado.toString();
    }
}
