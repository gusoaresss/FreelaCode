

package com.view.freelacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class View extends JFrame {
    
    public View() {
        setTitle("Freelancer App");
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout básico
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());       
       
            JPanel painelEsquerda = new JPanel(null);
            painelEsquerda.setPreferredSize(new Dimension(380, 300)); 
            painelEsquerda.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
                    
            JButton btnCurriculo = new JButton("Criar/Alterar Currículo");
            btnCurriculo.setBounds(20, 50, 180, 40); 
            btnCurriculo.addActionListener(e -> new Curriculo().setVisible(true));
            painelEsquerda.add(btnCurriculo);
            
            
            JButton btnVerCurriculos = new JButton("Ver seu currículo atual");
            btnVerCurriculos.setBounds(180, 50, 190, 40); 
            btnVerCurriculos.addActionListener(e -> new Curriculo().setVisible(true));
            painelEsquerda.add(btnVerCurriculos);
            
            
            panel.add(painelEsquerda, BorderLayout.WEST);
            setContentPane(panel);
    }
    
}
    

