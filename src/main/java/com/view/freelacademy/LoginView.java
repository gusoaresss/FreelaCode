package com.view.freelacademy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;




public class LoginView extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
    
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chkRemember;
    private JButton btnLogin;
    private Preferences prefs;
    
    
    
    public LoginView() {
        setTitle("Login");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
       
        //logo
   
        
        
        
        
        
        
        // Inicializa as preferências do sistema
        prefs = Preferences.userRoot().node(this.getClass().getName());

        // Componentes da tela
        
        JPanel panelCenter = new JPanel (new GridLayout(5,1,10,10));
        JLabel lblUsername = new JLabel("Usuário:");
        txtUsername = new JTextField(prefs.get("username", ""));
        JLabel lblPassword = new JLabel("Senha:");
        txtPassword = new JPasswordField(prefs.get("password", ""));
        chkRemember = new JCheckBox("Lembrar credenciais");
        
       
        
        // Adicionando componentes
        panelCenter.add(lblUsername);
        panelCenter.add(txtUsername);
        panelCenter.add(lblPassword);
        panelCenter.add(txtPassword);
        panelCenter.add(chkRemember);
      
        
        add(panelCenter, BorderLayout.CENTER);

        
        JPanel panelBottom = new JPanel();
    btnLogin = new JButton("Entrar");
    panelBottom.add(btnLogin);
    add(panelBottom, BorderLayout.SOUTH);
        
       
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

    }
