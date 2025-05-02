package com.view.freelacademy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Curriculo extends JFrame {
    // Lista para armazenar os currículos
    private final java.util.List<String[]> curriculos = new ArrayList<>();
    private final DefaultTableModel tableModel;

    public Curriculo() {
        setTitle("Currículo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba 1: Formulário de Cadastro
        JPanel painelCadastro = new JPanel(new GridLayout(4, 2));
        JTextField nomeField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextArea experienciaArea = new JTextArea();
        
        painelCadastro.add(new JLabel("Nome Completo:"));
        painelCadastro.add(nomeField);
        painelCadastro.add(new JLabel("Email:"));
        painelCadastro.add(emailField);
        painelCadastro.add(new JLabel("Telefone:"));
        painelCadastro.add(telefoneField);
        painelCadastro.add(new JLabel("Experiência:"));
        

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String[] dados = {
                nomeField.getText(),
                emailField.getText(),
                telefoneField.getText(),
                experienciaArea.getText()
            };
            curriculos.add(dados); // adiciona à lista
            atualizarTabela(); // atualiza a aba de currículos salvos
            JOptionPane.showMessageDialog(this, "Currículo salvo!");
            nomeField.setText("");
            emailField.setText("");
            telefoneField.setText("");
            experienciaArea.setText("");
        });

        JPanel painelCadastroComBotao = new JPanel(new BorderLayout());
        painelCadastroComBotao.add(painelCadastro, BorderLayout.CENTER);
        painelCadastroComBotao.add(btnSalvar, BorderLayout.SOUTH);
        tabbedPane.addTab("Novo Currículo", painelCadastroComBotao);

        // Aba 2: Currículos Salvos
        JPanel painelVisualizacao = new JPanel(new BorderLayout());
        String[] colunas = {"Nome", "Email", "Telefone", "Experiência"};
        tableModel = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(tableModel);
        painelVisualizacao.add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões de Editar e Deletar
        JPanel botoes = new JPanel();
        JButton btnEditar = new JButton("Editar");
        JButton btnDeletar = new JButton("Deletar");

        btnEditar.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                String[] dados = curriculos.get(selecionado);
                nomeField.setText(dados[0]);
                emailField.setText(dados[1]);
                telefoneField.setText(dados[2]);
                experienciaArea.setText(dados[3]);
                curriculos.remove(selecionado);
                atualizarTabela();
                tabbedPane.setSelectedIndex(0); // volta para aba de cadastro
            }
        });

        btnDeletar.addActionListener(e -> {
            int selecionado = tabela.getSelectedRow();
            if (selecionado >= 0) {
                curriculos.remove(selecionado);
                atualizarTabela();
            }
        });

        botoes.add(btnEditar);
        botoes.add(btnDeletar);
        painelVisualizacao.add(botoes, BorderLayout.SOUTH);

        tabbedPane.addTab("Currículos Salvos", painelVisualizacao);

        add(tabbedPane);
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0); // limpa
        for (String[] dados : curriculos) {
            tableModel.addRow(dados);
        }
    }
}
