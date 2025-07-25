# Desafio 11: Programação Funcional - Recursão e Funções de Alta Ordem

Este diretório explora o paradigma da Programação Funcional, focando em conceitos como imutabilidade, recursão e funções de alta ordem. A solução implementada em Java demonstra como aplicar esses princípios utilizando a Stream API.

## O Que é Programação Funcional?

A Programação Funcional é um paradigma de programação que trata a computação como a avaliação de funções matemáticas e evita estados mutáveis e dados que mudam. Em vez de uma sequência de instruções que alteram o estado do programa, o foco está em "o que" calcular, aplicando funções a dados de entrada para produzir dados de saída.

### Conceitos Chave:

* **Funções Puras:**
    * Para a mesma entrada, sempre produzem a mesma saída.
    * Não possuem efeitos colaterais (não modificam estados externos ou dados fora de seu escopo).
    * São mais fáceis de testar e paralelizar.
* **Imutabilidade:**
    * Os dados, uma vez criados, não podem ser alterados.
    * Em vez de modificar um objeto existente, uma nova versão do objeto é criada com as alterações desejadas.
    * Simplifica o raciocínio sobre o programa e ajuda a evitar bugs em ambientes concorrentes.
* **Recursão:**
    * Uma função que chama a si mesma para resolver um problema.
    * Geralmente utilizada em substituição aos loops para iterar sobre estruturas de dados ou para resolver problemas que podem ser divididos em subproblemas menores da mesma natureza.
    * Sempre requer um "caso base" para evitar recursão infinita.
* **Funções de Alta Ordem (Higher-Order Functions - HOFs):**
    * Funções que podem:
        * Receber outras funções como argumentos.
        * Retornar outras funções como resultado.
    * São poderosas para criar abstrações, reutilizar lógica e compor operações. Métodos como `map`, `filter` e `reduce` (presentes na Stream API de Java) são exemplos clássicos de HOFs.

## Exemplo de Solução Funcional em Java

Este exemplo demonstra os conceitos acima através do processamento de um inventário de produtos. Utilizamos a Stream API do Java (introduzida no Java 8) para aplicar o estilo de programação funcional.

### Arquivos:

* **`Produto.java`**: Uma classe simples e imutável que representa um produto.
* **`Main_desafio11.java`**: A classe principal que demonstra a recursão e o uso de funções de alta ordem (`filter`, `map`, `reduce`) com uma lista de `Produto(s)`.

### Código Java:

**`Produto.java`**

```java
public class Produto {
    private final String nome;
    private final double preco;
    private final String categoria;

    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", preco=" + preco +
               ", categoria='" + categoria + '\'' +
               '}';
    }
}
```
**`Main_desafio11.java`**

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional; // Usado para o resultado de reduce, que pode ser vazio
import java.util.stream.Collectors; // Usado para coletar resultados de streams

public class Main_desafio11 {

    // --- Exemplo de Recursão: Cálculo de Fatorial ---
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

        // --- Filter: Filtrando produtos caros (preço > R$ 100.00) ---
        // filter() é uma função de alta ordem que recebe uma 'Predicate' (uma função que retorna true/false).
        // Ela "filtra" os elementos da stream que satisfazem a condição.
        System.out.println("\n--- Produtos Caros (Preço > R$100.00): ---");
        List<Produto> produtosCaros = inventario.stream()
                                                .filter(produto -> produto.getPreco() > 100.00) // Lambda expression (função)
                                                .collect(Collectors.toList()); // Coleta os resultados em uma nova lista
        produtosCaros.forEach(System.out::println); // Imprime cada produto caro

        // --- Map: Mapeando para obter apenas os Nomes dos produtos ---
        // map() é uma função de alta ordem que recebe uma 'Function' (uma função que transforma um tipo em outro).
        // Ela "mapeia" cada elemento da stream para um novo formato.
        System.out.println("\n--- Nomes dos Produtos (Mapeamento): ---");
        List<String> nomesDosProdutos = inventario.stream()
                                                  .map(Produto::getNome) // Method reference (outra forma concisa de função)
                                                  .collect(Collectors.toList());
        nomesDosProdutos.forEach(System.out::println); // Imprime cada nome

        // --- Reduce: Calculando o valor total do inventário ---
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
```
# COnclusão
A Programação Funcional, com seu foco em funções puras, imutabilidade e funções de alta ordem, oferece uma abordagem poderosa para escrever código mais modular, testável e muitas vezes mais conciso. A Stream API do Java é um excelente exemplo de como linguagens modernas incorporam esses conceitos, permitindo que os desenvolvedores escrevam código que expressa "o que" deve ser feito, em vez de "como", resultando em soluções mais elegantes e menos propensas a erros relacionados a estados mutáveis.
