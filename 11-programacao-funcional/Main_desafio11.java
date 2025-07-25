import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional; // Usado para o resultado de reduce, que pode ser vazio
import java.util.stream.Collectors; // Usado para coletar resultados de streams

public class Main_desafio11 {

    // --- Exemplo de Recursão: Cálculo de Fatorial ---
    // Uma função que chama a si mesma para resolver o problema.
    // Condição de parada (caso base): fatorial de 0 ou 1 é 1.
    // Passo recursivo: n * fatorial(n-1).
    public static long calcularFatorialRecursivo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fatorial não pode ser calculado para números negativos.");
        }
        if (n == 0 || n == 1) {
            return 1; // Caso base: condição de parada da recursão
        } else {
            return n * calcularFatorialRecursivo(n - 1); // Passo recursivo
        }
    }

    public static void main(String[] args) {
        System.out.println("--- DESAFIO 11: PROGRAMAÇÃO FUNCIONAL ---");

        // --- Demonstração de Recursão ---
        System.out.println("\n--- 1. Exemplo de Recursão (Cálculo de Fatorial) ---");
        int numeroParaFatorial = 5;
        long resultadoFatorial = calcularFatorialRecursivo(numeroParaFatorial);
        System.out.println("O fatorial de " + numeroParaFatorial + " é: " + resultadoFatorial); // Saída: 120

        // --- Demonstração de Funções de Alta Ordem com Stream API ---
        // Funções de alta ordem são métodos que recebem funções como argumento
        // (neste caso, as expressões lambda dentro de filter, map, reduce).

        // Lista de produtos para simular um inventário
        List<Produto> inventario = new ArrayList<>(Arrays.asList(
            new Produto("Laptop", 1200.00, "Eletrônicos"),
            new Produto("Mouse", 25.00, "Eletrônicos"),
            new Produto("Caderno", 15.50, "Papelaria"),
            new Produto("Caneta", 2.00, "Papelaria"),
            new Produto("Monitor", 300.00, "Eletrônicos"),
            new Produto("Mochila", 80.00, "Acessórios")
        ));

        System.out.println("\n--- 2. Funções de Alta Ordem (Filter, Map, Reduce) ---");

        // --- a) Filter: Filtrando produtos caros (preço > R$ 100.00) ---
        // filter() é uma função de alta ordem que recebe uma 'Predicate' (uma função que retorna true/false).
        // Ela "filtra" os elementos da stream que satisfazem a condição.
        System.out.println("\n--- Produtos Caros (Preço > R$100.00): ---");
        List<Produto> produtosCaros = inventario.stream()
                                                .filter(produto -> produto.getPreco() > 100.00) // Lambda expression (função)
                                                .collect(Collectors.toList()); // Coleta os resultados em uma nova lista
        produtosCaros.forEach(System.out::println); // Imprime cada produto caro

        // --- b) Map: Mapeando para obter apenas os Nomes dos produtos ---
        // map() é uma função de alta ordem que recebe uma 'Function' (uma função que transforma um tipo em outro).
        // Ela "mapeia" cada elemento da stream para um novo formato.
        System.out.println("\n--- Nomes dos Produtos (Mapeamento): ---");
        List<String> nomesDosProdutos = inventario.stream()
                                                  .map(Produto::getNome) // Method reference (outra forma concisa de função)
                                                  .collect(Collectors.toList());
        nomesDosProdutos.forEach(System.out::println); // Imprime cada nome

        // --- c) Reduce: Calculando o valor total do inventário ---
        // reduce() é uma função de alta ordem que combina os elementos de uma stream
        // em um único resultado (reduz a stream a um valor).
        // Recebe um valor inicial e uma 'BinaryOperator' (função que combina dois elementos).
        System.out.println("\n--- Valor Total do Inventário (Redução): ---");
        double valorTotalInventario = inventario.stream()
                                                 .mapToDouble(Produto::getPreco) // Mapeia para um stream de double (para soma)
                                                 .sum(); // Método de redução específico para soma em DoubleStream
                                                 // Alternativa com reduce genérico:
                                                 // .reduce(0.0, (subtotal, precoProduto) -> subtotal + precoProduto);
        System.out.println("Valor total do inventário: R$" + String.format("%.2f", valorTotalInventario));

        // --- Outro Exemplo de Reduce: Encontrando o produto mais caro ---
        // reduce() também pode ser usado para encontrar o máximo/mínimo.
        System.out.println("\n--- Produto Mais Caro (Redução): ---");
        Optional<Produto> produtoMaisCaro = inventario.stream()
                .reduce((prod1, prod2) -> prod1.getPreco() > prod2.getPreco() ? prod1 : prod2);

        if (produtoMaisCaro.isPresent()) {
            // CORREÇÃO AQUI: Usar produtoMaisCaro.get() para acessar o objeto Produto
            System.out.println("Produto mais caro: " + produtoMaisCaro.get().getNome() + " (R$" + produtoMaisCaro.get().getPreco() + ")");
        } else {
            System.out.println("Nenhum produto encontrado no inventário.");
        }

        System.out.println("\n--- Fim da demonstração de Programação Funcional ---");
    }
}
