import java.util.Scanner; // Importa a classe Scanner para ler a entrada do usuário

public class FatorialRecursivo {
    public static long calcularFatorial(int n) {
        // --- Caso Base da Recursão ---
        // Se n é 0, o fatorial é 1. Esta é a condição de parada da recursão.
        if (n == 0) {
            System.out.println("  Caso Base atingido: calcularFatorial(0) retorna 1");
            return 1;
        }
        // --- Condição de erro para números negativos ---
        else if (n < 0) {
            throw new IllegalArgumentException("Não é possível calcular o fatorial de um número negativo.");
        }
        // --- Passo Recursivo ---
        // Se n não é 0, o fatorial de n é n multiplicado pelo fatorial de (n-1).
        // A função chama a si mesma com um problema menor (n-1).
        else {
            System.out.println("  Chamada recursiva: calcularFatorial(" + n + ") chamando calcularFatorial(" + (n - 1) + ")");
            long resultadoAnterior = calcularFatorial(n - 1); // Chamada recursiva
            long resultadoAtual = n * resultadoAnterior;
            System.out.println("  Retornando de calcularFatorial(" + n + "): " + n + " * " + resultadoAnterior + " = " + resultadoAtual);
            return resultadoAtual;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Demonstração de Função Recursiva: Cálculo do Fatorial ---");
        System.out.print("Digite um número inteiro não negativo para calcular o fatorial: ");

        try {
            int numero = scanner.nextInt(); // Lê o número fornecido pelo usuário

            long fatorial = calcularFatorial(numero); // Chama a função recursiva
            System.out.println("\nO fatorial de " + numero + " é: " + fatorial);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
        } finally {
            scanner.close(); // Garante que o scanner seja fechado
        }
    }
}
