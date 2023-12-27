package Login.userUI;

public class Estoque {
    private String produto;
    private int quantidade;

    // Construtor
    public Estoque(int quantidade, String produto) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
