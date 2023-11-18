
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
import javax.swing.event.ListSelectionListener;

import estoque.*;



public class GUI extends JFrame{
 Inventario estoque = new Inventario();
 String[] itens = {"ÁGUA","MALTE","LÚPULO","FERMENTO"};//
 JList<String> lista_loja = new JList<>(itens);
 JList<String> lista_estoque; 
 JList<String> lista_receita = new JList<>(itens);
 JLabel titulo_loja = new JLabel("LOJA");
 JLabel titulo_estoque = new JLabel("ESTOQUE");
 JButton botao_comprar = new JButton("COMPRAR");


    
 public GUI (){

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
        //add(botao_agua);


        JButton botao_receitas = new JButton("RECEITAS");
        botao_receitas.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_receitas.setBounds(400, 200 ,250, 70);
        botao_receitas.setForeground(new Color(237,241,238 ));
        botao_receitas.setBackground(new Color(0,0,0 ));
        //add(botao_malte);


        JButton botao_loja = new JButton("LOJA");
        botao_loja.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_loja.setBounds(250, 300 ,250, 70);
        botao_loja.setForeground(new Color(237,241,238 ));
        botao_loja.setBackground(new Color(0,0,0 ));
        //add(botao_criar);


       // botao_inventario.addActionListener(this::addAgua);
       // botao_receitas.addActionListener(this::addMalte);
        botao_loja.addActionListener(this::abrirLoja);
        botao_inventario.addActionListener(this::abrirEstoque);
        

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


        lista_estoque = new JList<>(estoque.listarItens());
        lista_estoque.setBounds(400,200,250,100);
        add(lista_estoque);
        lista_estoque.setVisible(false);

        titulo_estoque.setBounds(500,80,90,50);
        titulo_estoque.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        add(titulo_estoque);
        titulo_estoque.setVisible(false);
        
        
        
        
        
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
    

    }
    
    public void abrirLoja(ActionEvent e){
             
     lista_loja.setVisible(true);
     titulo_loja.setVisible(true);
     botao_comprar.setVisible(true);
    
        lista_estoque.setVisible(false);
        titulo_estoque.setVisible(false);
    }

     public void abrirEstoque(ActionEvent e){


        lista_loja.setVisible(false);
        titulo_loja.setVisible(false);
        botao_comprar.setVisible(false);

        lista_estoque.setVisible(true);
        titulo_estoque.setVisible(true);
        lista_estoque.setListData(estoque.listarItens());
    }

     private void comprarItem() {
        
        int indexSelecionado = lista_loja.getSelectedIndex();

        if (indexSelecionado != -1) {
            String itemSelecionado = itens[indexSelecionado];

            materiaPrima materiaPrima = criarMateriaPrima(itemSelecionado);

            estoque.adicionarItem(materiaPrima);

            // Agora você pode fazer algo com o item selecionado, por exemplo, exibir uma mensagem
            JOptionPane.showMessageDialog(this, "Você comprou: " + itemSelecionado);
        } else {
            // Caso nenhum item esteja selecionado
            JOptionPane.showMessageDialog(this, "Selecione um item antes de comprar");
        }  
 }

 

 private materiaPrima criarMateriaPrima(String tipo) {
    // Lógica para criar e retornar uma instância da classe MateriaPrima desejada
    // Aqui você pode ter um switch ou if-else para determinar o tipo e criar o objeto correspondente
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



}

        
    
    
    


