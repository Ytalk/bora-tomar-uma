package estoque;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import app.InvalidItemException;

import java.util.Iterator;

public class Inventario{
    private ArrayList <MateriaPrima> materias;
    private ArrayList <CervejaArtesanal> cervejas;
    private ArrayList <Receita> receitas;
    
    public Inventario(){
        this.materias = new ArrayList<MateriaPrima>();
        this.cervejas = new ArrayList<CervejaArtesanal>();
        this.receitas = new ArrayList<Receita>();
    }

    public void adicionarItem(MateriaPrima item){
        boolean existente = false;
        for(MateriaPrima itens : materias){
            if(item.getDesc().equals(itens.getDesc())){
                itens.setPeso(itens.getPeso() + item.getPeso());
                existente = true;
            }
        }
        if(existente == false){
            materias.add(item);
        }
    }

    public ArrayList<MateriaPrima> getMaterias() {
        return materias;
    }

    public MateriaPrima buscarMateriaPrima(String desc){
        for(MateriaPrima item : materias){
            if(item.getDesc().equals(desc)){
                return item;
            }
        }
        return null;
    }

    public String[] listarItens() {
        String[] itens = new String[materias.size()];

        for (int i = 0; i < materias.size(); i++) {
            itens[i] = materias.get(i).toString(); 
        }

        return itens;
    }
    public void adicionarCerveja(CervejaArtesanal cerveja) throws InvalidItemException{
        ArrayList<MateriaPrima> label = cerveja.getRótulo();
        boolean suficiente = true;
    
        for (MateriaPrima rótulo : label) {
            suficiente = false;
    
            for (MateriaPrima item : materias) {
                if (item.getDesc().equalsIgnoreCase(rótulo.getDesc()) && item.getPeso() >= rótulo.getPeso()) {
                    item.setPeso(item.getPeso() - rótulo.getPeso());
                    suficiente = true;
                    break;
                }
            }
    
            if (!suficiente) {
                break;
            }
        }
    }

    public void diminuirMateria(MateriaPrima item, double peso){

        for (MateriaPrima materiaPrima : materias) {
            if (materiaPrima.equals(item)) {
              item.usarMateria(peso);
              break;
            }
          }
    }


    public ArrayList<CervejaArtesanal> getCervejas(){
        return cervejas;
    }

    public String[] listarCervejas(){
       String[] itens = new String[cervejas.size()];
       for (int i = 0; i < cervejas.size(); i++) {
            itens[i] = cervejas.get(i).getNome(); 
        }

        return itens;
    }

    public void adicionarReceita(Receita receita){
        receitas.add(receita);
    }
    
    public void deletarReceita(String nome){
        Iterator<Receita> iterator = receitas.iterator();
    
        while(iterator.hasNext()){
            Receita receita = iterator.next();
            if(receita.getNome().equals(nome)){
                iterator.remove();
                System.out.println("Receita removida do estoque: " + receita.getNome()); 
            }
        }
    }

    public CervejaArtesanal getCerveja(String nome) throws NoSuchElementException{
        for(CervejaArtesanal cerveja: cervejas){
            if(cerveja.getNome() == nome)
                return cerveja;
        }
        throw new NoSuchElementException("cerveja não encontrada com o nome: " + nome);
    }

    public void deletarCerveja(String nome){
        Iterator<CervejaArtesanal> iterator = cervejas.iterator();
    
        while(iterator.hasNext()){
            CervejaArtesanal cerveja = iterator.next();
            if (cerveja.getNome().equals(nome)){
                iterator.remove();
                System.out.println("Cerveja removida do estoque: " + cerveja.getNome());
            }
        }
    }

    public Receita getReceita(String nome) throws NoSuchElementException{
        for(Receita receita: receitas){
            if(receita.getNome() == nome)
                return receita;
        }
        throw new NoSuchElementException("receita não encontrada com o nome: " + nome);
    }

}

