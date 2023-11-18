package src;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import estoque.*;



public class GUI extends JFrame{
 Inventario estoque = new Inventario();
 String[] itens = {"MALTE,ÁGUA,FERMENTO"};
 JList<String> lista = new JList<>(itens);

    
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


        botao_inventario.addActionListener(this::addAgua);
        botao_receitas.addActionListener(this::addMalte);
        botao_loja.addActionListener(this::abrirLoja);
        


        JPanel menu_lateral = new JPanel();
        menu_lateral.setLayout(new GridLayout(3,1));
        menu_lateral.setBounds(0,100,100,200);
        add(menu_lateral);
        menu_lateral.add(botao_inventario);
        menu_lateral.add(botao_receitas);
        menu_lateral.add(botao_loja);
 

        
        
        

        lista.setBounds(400,200,250,100);
        add(lista);
        lista.setVisible(false);
         


    }



    public void addAgua(ActionEvent e){
     
        agua agua = new agua(100, 0,"agua");
        estoque.adicionarItem(agua);
     
    }

    public void addMalte(ActionEvent e){
        malte malte = new malte(200,1,"malte");
        estoque.adicionarItem(malte);

    }
    
    public void abrirLoja(ActionEvent e){
        
    lista.setVisible(true);

        
    
    }
    

}
