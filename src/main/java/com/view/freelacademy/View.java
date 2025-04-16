

package com.view.freelacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class View extends JFrame {
    
    public View() {
        setTitle("Freelancer App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout básico
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
         JLabel label = new JLabel("Bem-vindo ao Freelancer App!", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

    
        //botão para abrir a tela de login
        JButton btnOpenLogin = new JButton("Fazer login");
        btnOpenLogin.addActionListener((ActionEvent e) -> {
            new LoginView().setVisible(true);
            dispose();
        });
        panel.add(btnOpenLogin, BorderLayout.SOUTH);
        
        
        setContentPane(panel);
    }
    public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new View().setVisible(true));
        }
}
    

