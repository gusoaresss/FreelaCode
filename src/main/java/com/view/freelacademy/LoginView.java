package com.view.freelacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class LoginView {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chkRemember;
    private JButton btnLogin;
    private Preferences prefs;
    
    public LoginView() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));
        
        // Inicializa as preferências do sistema
        prefs = Preferences.userRoot().node(this.getClass().getName());

        // Componentes da tela
        JLabel lblUsername = new JLabel("Usuário:");
        txtUsername = new JTextField(prefs.get("username", ""));
        JLabel lblPassword = new JLabel("Senha:");
        txtPassword = new JPasswordField(prefs.get("password", ""));
        chkRemember = new JCheckBox("Lembrar credenciais");
        chkRemember.setSelected(!txtUsername.getText().isEmpty());
        btnLogin = new JButton("Entrar");
        
        // Adicionando componentes
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(chkRemember);
        add(new JLabel()); // Espaço vazio
        add(btnLogin);

        // Evento de login
        
        btnLogin.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if (username.equals("admin") && password.equals("1234")) {
                    if (chkRemember.isSelected()) {
                        prefs.put("username", username);
                        prefs.put("password", password);
                    } else {
                        prefs.remove("username");
                        prefs.remove("password");
                    }
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    new View().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    private void add(JTextField lblUsername) {
        add(lblUsername);
    }

    private void add(JLabel lblUsername) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void add(JCheckBox chkRemember) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void add(JButton btnLogin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setTitle(String login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void setLayout(GridLayout gridLayout) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
