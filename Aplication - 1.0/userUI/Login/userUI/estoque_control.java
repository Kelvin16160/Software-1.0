package Login.userUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class estoque_control extends JFrame implements ActionListener {
    private JTextField nomeField;
    private JTextField entradaField;
    private JTextField saidaField;
    private DefaultListModel<String> produtosListModel;
    private JList<String> produtosList;
    private ArrayList<Produto> produtos;

    public estoque_control() {
        setTitle("Controle de Estoque");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelNome = new JPanel(new GridLayout(1, 2));
        JLabel nomeLabel = new JLabel("Nome do Produto:");
        nomeField = new JTextField(10);
        panelNome.add(nomeLabel);
        panelNome.add(nomeField);
        add(panelNome, BorderLayout.NORTH);

        JPanel panelEntradaSaida = new JPanel(new GridLayout(2, 2));

        JLabel entradaLabel = new JLabel("Entrada:");
        entradaField = new JTextField(15);
        JLabel saidaLabel = new JLabel("Saída:");
        saidaField = new JTextField(15);

        panelEntradaSaida.add(entradaLabel);
        panelEntradaSaida.add(entradaField);
        panelEntradaSaida.add(saidaLabel);
        panelEntradaSaida.add(saidaField);

        add(panelEntradaSaida, BorderLayout.CENTER);

        JButton btnEntrada = new JButton("Registrar Entrada");
        btnEntrada.addActionListener(this);
        JButton btnSaida = new JButton("Registrar Saída");
        btnSaida.addActionListener(this);

        JPanel panelBotoes = new JPanel(new GridLayout(1, 2));
        panelBotoes.add(btnEntrada);
        panelBotoes.add(btnSaida);

        add(panelBotoes, BorderLayout.SOUTH);

        produtos = new ArrayList<>();
        produtosListModel = new DefaultListModel<>();
        produtosList = new JList<>(produtosListModel);

        JScrollPane scrollPane = new JScrollPane(produtosList);
        add(scrollPane, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = nomeField.getText();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do produto.");
            return;
        }

        if (e.getActionCommand().equals("Registrar Entrada")) {
            try {
                int quantidade = Integer.parseInt(entradaField.getText());
                adicionarProduto(nome, quantidade);
                atualizarListaProdutos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um número válido para a entrada.");
            }
        } else if (e.getActionCommand().equals("Registrar Saída")) {
            try {
                int quantidade = Integer.parseInt(saidaField.getText());
                removerProduto(nome, quantidade);
                atualizarListaProdutos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um número válido para a saída.");
            } catch (EstoqueInsuficienteException ex) {
                JOptionPane.showMessageDialog(this, "Estoque insuficiente para a saída.");
            }
        }
    }

    private void adicionarProduto(String nome, int quantidade) {
        Produto produto = buscarOuCriarProduto(nome);
        produto.aumentarEstoque(quantidade);
    }

    private void removerProduto(String nome, int quantidade) throws EstoqueInsuficienteException {
        Produto produto = buscarProduto(nome);
        if (produto != null) {
            produto.diminuirEstoque(quantidade);
        } else {
            throw new EstoqueInsuficienteException();
        }
    }

    private Produto buscarProduto(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    private Produto buscarOuCriarProduto(String nome) {
        Produto produto = buscarProduto(nome);
        if (produto == null) {
            produto = new Produto(nome);
            produtos.add(produto);
            produtosListModel.addElement(produto.toString());
        }
        return produto;
    }

    private void atualizarListaProdutos() {
        produtosListModel.clear();
        for (Produto p : produtos) {
            produtosListModel.addElement(p.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            estoque_control estoque = new estoque_control();
            estoque.setVisible(true);
        });
    }
}

class Produto {
    private String nome;
    private int estoque;

    public Produto(String nome) {
        this.nome = nome;
        this.estoque = 0;
    }

    public String getNome() {
        return nome;
    }

    public void aumentarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public void diminuirEstoque(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > estoque) {
            throw new EstoqueInsuficienteException();
        }
        estoque -= quantidade;
    }

    @Override
    public String toString() {
        return nome + " - Estoque: " + estoque;
    }
}

class EstoqueInsuficienteException extends Exception {
    // Exceção para indicar que o estoque é insuficiente para a saída solicitada
}
