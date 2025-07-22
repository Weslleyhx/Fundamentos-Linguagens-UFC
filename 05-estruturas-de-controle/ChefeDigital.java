import java.util.Scanner; // Importa a classe Scanner para ler a entrada do usuário

public class ChefeDigital {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner
        boolean iniciarReceita = false; // Variável de controle para iniciar a receita

        System.out.println("----------------------------------------");
        System.out.println("           Bem-vindo ao Chef Digital!      ");
        System.out.println(" Vamos preparar uma deliciosa Sopa de Legumes Simples.");
        System.out.println("----------------------------------------");

        // --- Estrutura de Repetição (while) e Seleção (if/else if/else) ---
        // Loop para garantir que o usuário digite 'sim' ou 'nao' para começar a receita.
        while (!iniciarReceita) {
            System.out.print("Deseja começar a preparar a sopa? (sim/nao): ");
            String resposta = scanner.nextLine().trim().toLowerCase(); // Funções para ler a linha, remover espaços e converter para minúsculas
            
            if (resposta.equals("sim")) {
                iniciarReceita = true; // Altera a condição, saindo do loop
                System.out.println("\nÓtimo! Vamos começar a cozinhar.");
            } else if (resposta.equals("nao")) {
                System.out.println("Que pena! O Chef Digital fica por aqui. Até a próxima!");
                scanner.close(); // Fecha o scanner
                return; // Encerra o programa imediatamente (controle de fluxo)
            } else {
                System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'nao'.");
            }
        }

        System.out.println("\n--- Etapa 1: Preparação da Base ---");
        System.out.println("1. Adicione 1 litro de água na panela.");
        System.out.println("2. Adicione 2 cubos de caldo de legumes na água fervente.");
        // --- Estruturas de Seleção (if/else) e Repetição (while) para Ingredientes Opcionais ---
        System.out.println("\n--- Etapa 2: Ingredientes Opcionais ---");
        // Pergunta sobre a cebola
        boolean respostaValidaCebola = false;
            while (!respostaValidaCebola) { // Loop para validação da entrada
                System.out.print("Deseja adicionar cebola à sopa? (sim/nao): ");
                String respostaCebola = scanner.nextLine().trim().toLowerCase();

                if (respostaCebola.equals("sim")) {
                    System.out.println("Cebola adicionada! Um toque de sabor.");
                    respostaValidaCebola = true;
                } else if (respostaCebola.equals("nao")) {
                    System.out.println("Ok, sem cebola desta vez.");
                    respostaValidaCebola = true;
                } else {
                    System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'nao'.");
                }
            }
        // Pergunta sobre a cenoura
        boolean respostaValidaCenoura = false;
            while (!respostaValidaCenoura) { // Loop para validação da entrada
                System.out.print("Deseja adicionar cenoura à sopa? (sim/nao): ");
                String respostaCenoura = scanner.nextLine().trim().toLowerCase();

                if (respostaCenoura.equals("sim")) {
                    System.out.println("Cenoura adicionada! Para cor e doçura.");
                    respostaValidaCenoura = true;
                } else if (respostaCenoura.equals("nao")) {
                    System.out.println("Ok, a sopa será sem cenoura.");
                    respostaValidaCenoura = true;
                } else {
                    System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'nao'.");
                }
            }
        // --- Estrutura de Repetição (while) e Seleção (if) para Cozinhar ---
        System.out.println("\n--- Etapa 3: Cozinhar e Mexer ---");
        System.out.println("A sopa está fervendo. Precisamos mexer por alguns minutos.");

        int minutosMexendo = 0;
        boolean sopaPronta = false;
            while (!sopaPronta) { // Loop de repetição para simular o cozimento
                minutosMexendo++;
                System.out.println("Passaram-se " + minutosMexendo + " minuto(s) mexendo.");

                if (minutosMexendo >= 3) { // Estrutura de seleção: após 3 minutos, pergunta se está pronto
                    boolean respostaValidaPonto = false;
                    while (!respostaValidaPonto) { // Loop de validação para a resposta do ponto da sopa
                        System.out.print("A sopa está no ponto ideal? (sim/nao): ");
                        String respostaPonto = scanner.nextLine().trim().toLowerCase();

                        if (respostaPonto.equals("sim")) {
                            sopaPronta = true; // Altera a condição do loop externo, fazendo-o terminar
                            respostaValidaPonto = true;
                            System.out.println("Perfeito! A sopa atingiu o ponto ideal.");
                        } else if (respostaPonto.equals("nao")) {
                            respostaValidaPonto = true;
                            System.out.println("Ok, vamos mexer mais um pouco...");
                        } else {
                            System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'nao'.");
                        }
                    }
                } else {
                System.out.println("Continuando a mexer...");
                }
            }
        // --- Etapa Final ---
        System.out.println("\n--- Etapa 4: Finalização ---");
        System.out.println("Parabéns, Chef! Sua Sopa de Legumes Simples está pronta para servir!");
        System.out.println("Bom apetite!");

        scanner.close(); // Fecha o scanner para liberar recursos do sistema    
    }
}
