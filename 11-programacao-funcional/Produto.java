public class Produto {
    private final String nome;      // 'final' para garantir que não será alterado após a criação
    private final double preco;     // 'final' para garantir que não será alterado após a criação
    private final String categoria; // 'final' para garantir que não será alterado após a criação

    // Construtor
    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Métodos Getters: para acessar os valores dos atributos
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    //Método toString() para facilitar a impressão do objeto
    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", preco=" + preco +
               ", categoria='" + categoria + '\'' +
               '}';
    }
}
