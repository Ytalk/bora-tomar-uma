package app;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import estoque.*;



public class tela extends JFrame{
 inventario estoque = new inventario();
 String[] itens = {"ÁGUA","MALTE","LÚPULO","FERMENTO"};//
 JList<String> lista_loja = new JList<>(itens);
 JList<String> lista_estoque; 
 JList<String> lista_receita = new JList<>(itens);;
 JLabel titulo_loja = new JLabel("LOJA");
 JLabel titulo_estoque = new JLabel("ESTOQUE");
 JPanel itemDetalhes = new JPanel();
 JButton botao_comprar = new JButton("COMPRAR");


    
 public tela (){

        setVisible(true); 
        setSize(800,500);
        setTitle("CERVEJARIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerrar programa ao clicar no "X"
        setLocationRelativeTo(null); // abrir no centro da tela
        setLayout(null);
        

        JButton botao_inventario = new JButton("INVENTÁRIO");
        botao_inventario.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_inventario.setBounds(100, 200 ,250, 70);
        botao_inventario.setForeground(new Color(237,241,238 ));
        botao_inventario.setBackground(new Color(0,0,0 ));
        


        JButton botao_receitas = new JButton("RECEITAS");
        botao_receitas.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_receitas.setBounds(400, 200 ,250, 70);
        botao_receitas.setForeground(new Color(237,241,238 ));
        botao_receitas.setBackground(new Color(0,0,0 ));
        


        JButton botao_loja = new JButton("LOJA");
        botao_loja.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_loja.setBounds(250, 300 ,250, 70);
        botao_loja.setForeground(new Color(237,241,238 ));
        botao_loja.setBackground(new Color(0,0,0 ));
        
       
       
        botao_loja.addActionListener(this::abrirLoja);
        botao_inventario.addActionListener(this::abrirEstoque);
        botao_receitas.addActionListener(this::abrirReceitas);
        

        JPanel menu_lateral = new JPanel();
        menu_lateral.setLayout(new GridLayout(3,1));
        menu_lateral.setBounds(0,100,100,200);
        add(menu_lateral);
        menu_lateral.add(botao_inventario);
        menu_lateral.add(botao_receitas);
        menu_lateral.add(botao_loja);
 


        lista_receita.setBounds(400,200,250,100);
        add(lista_receita);
        lista_receita.setVisible(false);

 
 
 
        // UI ESTOQUE //
        lista_estoque = new JList<>(estoque.listarItens());
        lista_estoque.setBounds(400,200,250,100);
        add(lista_estoque);
        lista_estoque.setVisible(false);
        
        // Adicione um ListSelectionListener à JList lista_estoque
        lista_estoque.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
        exibirDetalhesItemSelecionado();
        }
        });
        // Adicione um ListSelectionListener à JList lista_estoque

        titulo_estoque.setBounds(500,80,90,50);
        titulo_estoque.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        add(titulo_estoque);
        titulo_estoque.setVisible(false);
        
        // Crie um JPanel para exibir os detalhes dos produtos do estoque
    
        itemDetalhes.setLayout(new GridLayout(3, 2));
        itemDetalhes.setBounds(150, 200, 250, 100);
        itemDetalhes.setVisible(false);
        add(itemDetalhes);
        // UI ESTOQUE //
        
       // UI DA LOJA //  
       lista_loja.setBounds(400,200,250,100);
       add(lista_loja);
       lista_loja.setVisible(false);
       
       titulo_loja.setBounds(500,80,90,50);
       titulo_loja.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
       add(titulo_loja);
       titulo_loja.setVisible(false);

       botao_comprar.setBounds(650,200,120,50);
       botao_comprar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
       add(botao_comprar);
       botao_comprar.setVisible(false);
       botao_comprar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            comprarItem();
        }
    });
       // UI DA LOJA // 

    }
    
    public void abrirLoja(ActionEvent e){
     
     //remover elementos de outra tela     
     lista_loja.setVisible(true);
     titulo_loja.setVisible(true);
     botao_comprar.setVisible(true);
     itemDetalhes.setVisible(false);
     
     //exibir elementos da loja
     lista_estoque.setVisible(false);
     titulo_estoque.setVisible(false);
     
    }

     public void abrirEstoque(ActionEvent e){
        //remover elementos de outra tela
        lista_loja.setVisible(false);
        titulo_loja.setVisible(false);
        botao_comprar.setVisible(false);

        //exibir elementos do estoque
        lista_estoque.setVisible(true);
        titulo_estoque.setVisible(true);
        lista_estoque.setListData(estoque.listarItens());
    }

    public void abrirReceitas(ActionEvent e){
        lista_loja.setVisible(false);
        titulo_loja.setVisible(false);
        botao_comprar.setVisible(false);
        lista_estoque.setVisible(false);
        titulo_estoque.setVisible(false);

        lista_receita.setVisible(false);

    }

     private void comprarItem() {
     int indexSelecionado = lista_loja.getSelectedIndex();

            if (indexSelecionado != -1) {
            String itemSelecionado = itens[indexSelecionado];

            materiaPrima materiaPrima = criarMateriaPrima(itemSelecionado);

            estoque.adicionarItem(materiaPrima);

            // Mensagem de produto comprado
            JOptionPane.showMessageDialog(this, "Você comprou: " + itemSelecionado);
        } else {
            // Caso nenhum item esteja selecionado
            JOptionPane.showMessageDialog(this, "Selecione um item antes de comprar");
        }  
     }

 

    private materiaPrima criarMateriaPrima(String tipo) {
    // Lógica para criar e retornar uma instância da classe MateriaPrima desejada
    
     switch (tipo) {
        case "ÁGUA":
            return new agua(100,10,"Água");
        case "MALTE":
            return new malte(200,20,"Malte");
        case "LÚPULO":
            return new lupulo(300,15,"Lupulo");
        // Adicione outros casos conforme necessário
        case "FERMENTO":
        return new fermento(400, 25, "Fermento");
        
        default:
            throw new IllegalArgumentException("Tipo de matéria-prima desconhecido: " + tipo);
      }   
    }

    // Método para exibir os detalhes do item selecionado
    private void exibirDetalhesItemSelecionado() {
    int indexSelecionado = lista_estoque.getSelectedIndex();
    itemDetalhes.setVisible(true);
    //evitar duplição
    itemDetalhes.removeAll();

    if (indexSelecionado != -1) {
        materiaPrima itemSelecionado = estoque.getMaterias().get(indexSelecionado);
 

        // Adicione rótulos e valores ao JPanel
        itemDetalhes.add(new JLabel("NOME:"));
        itemDetalhes.add(new JLabel(itemSelecionado.getDesc()));

        itemDetalhes.add(new JLabel("QUANTIDADE:"));
        itemDetalhes.add(new JLabel(String.valueOf(itemSelecionado.getPeso())));

        itemDetalhes.add(new JLabel("PREÇO:"));
        itemDetalhes.add(new JLabel(String.valueOf(itemSelecionado.getCusto())));
        
       //atualizar tela
       repaint();
       revalidate();
    }
}


}

        
    
    
    


