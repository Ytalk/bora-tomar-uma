package src;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import estoque.*;



public class GUI extends JFrame{
 Inventario estoque = new Inventario();
    
 public GUI (){

        setVisible(true); 
        setSize(800,500);
        setTitle("CERVEJARIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerrar programa ao clicar no "X"
        setLocationRelativeTo(null); // abrir no centro da tela
        setLayout(null);
        



        JButton botao_agua = new JButton("AGUA");
        botao_agua.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_agua.setBounds(100, 200 ,250, 70);
        botao_agua.setForeground(new Color(237,241,238 ));
        botao_agua.setBackground(new Color(0,0,0 ));
        add(botao_agua);


        JButton botao_malte = new JButton("MALTE");
        botao_malte.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_malte.setBounds(400, 200 ,250, 70);
        botao_malte.setForeground(new Color(237,241,238 ));
        botao_malte.setBackground(new Color(0,0,0 ));
        add(botao_malte);


        JButton botao_criar = new JButton("IMPRIMIR");
        botao_criar.setFont(new Font("Arial",Font.CENTER_BASELINE,15));
        botao_criar.setBounds(250, 300 ,250, 70);
        botao_criar.setForeground(new Color(237,241,238 ));
        botao_criar.setBackground(new Color(0,0,0 ));
        add(botao_criar);


        botao_agua.addActionListener(this::addAgua);
        botao_malte.addActionListener(this::addMalte);
        botao_criar.addActionListener(this::imprimir);


    }



    public void addAgua(ActionEvent e){

        agua agua = new agua(100, 0,"agua");
      
        estoque.adicionarItem(agua);
     
    }

    public void addMalte(ActionEvent e){
        malte malte = new malte(200,1,"malte");
        estoque.adicionarItem(malte);

    }
    
    public void imprimir(ActionEvent e){
        estoque.listarItens();
        
    
    }
    

}
