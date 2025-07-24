# Desafio 9: Concorrência - Threads e Processos (Tarefas)

Este diretório aborda os conceitos de concorrência na execução de software, explicando a diferença fundamental entre threads (tarefas leves) e processos (tarefas pesadas), suas motivações e apresentando um exemplo prático de execução concorrente em Java.

## Introdução à Concorrência

A concorrência na execução de software pode ocorrer em diversos níveis, incluindo o nível de instrução, de sentença e de subprograma. As linguagens de programação oferecem suporte para o gerenciamento de unidades de programa que podem ser executadas concorrentemente.

## Diferença entre Threads e Processos (Tarefas)

Nas linguagens de programação, as unidades concorrentes são geralmente referenciadas como **tarefas**. Uma tarefa é uma unidade de um programa, similar a um subprograma, que pode ser executada concorrentemente com outras unidades do mesmo programa.

As tarefas são divididas em duas categorias principais, que ajudam a entender a distinção entre "threads" e "processos" no contexto da concorrência:

### Tarefas Pesadas (Heavyweight) / Processos
Uma tarefa pesada é aquela que executa em seu **próprio espaço de endereçamento**. Isso significa que cada tarefa tem sua própria memória isolada, e a comunicação entre elas geralmente é mais complexa. Um exemplo notável são as tarefas de Ada, que são consideradas tarefas pesadas. Tarefas pesadas podem ser distribuídas facilmente para processadores distintos, inclusive com memórias diferentes, que poderiam estar em computadores diversos. Isso as torna adequadas para sistemas distribuídos.

### Tarefas Leves (Lightweight) / Linhas de Execução (Threads)
As tarefas leves, comumente chamadas de **linhas de execução (threads)**, são todas executadas no **mesmo espaço de endereçamento**. Isso implica que elas **compartilham a mesma memória** e podem acessar os mesmos dados diretamente. A implementação de tarefas leves é mais fácil e elas podem ser mais eficientes do que as tarefas pesadas, pois exigem menos esforço para gerenciar sua execução. As linhas de execução em Java são um exemplo de tarefas leves, assim como as linhas de execução em C#. A comunicação entre threads em Java, por exemplo, ocorre através de dados compartilhados.

**Em resumo**, a principal diferença reside no compartilhamento de espaço de endereçamento: processos (ou tarefas pesadas) têm espaços de memória separados, enquanto threads (ou tarefas leves) compartilham o mesmo espaço de memória do processo que as contém.

## Motivações para o Uso da Concorrência

Existem várias razões para projetar sistemas de software concorrentes:

* **Velocidade de Execução:** Em máquinas com múltiplos processadores, a concorrência permite aumentar a velocidade de execução dos programas, aproveitando a capacidade do hardware.
* **Eficiência em Máquinas de Processador Único:** Mesmo em máquinas com um único processador, programas concorrentes podem ser mais rápidos se a versão sequencial não utilizar totalmente o processador (por exemplo, durante operações de E/S lentas, onde uma thread pode esperar a E/S enquanto outra processa).
* **Modelagem Natural de Problemas:** Muitos domínios de problemas se prestam naturalmente à concorrência, assim como a recursão é natural para alguns problemas. Isso inclui simulações de sistemas físicos com múltiplas entidades que operam simultaneamente.
* **Aplicações Distribuídas:** A concorrência é essencial para a programação de aplicações distribuídas por várias máquinas, como jogos online, servidores web e sistemas embarcados.

## Exemplo de Concorrência Personalizado em Java

Para ilustrar a concorrência, problemas como o Produtor-Consumidor são frequentemente utilizados. Nesse cenário, tarefas "produtoras" geram dados e os colocam em um buffer compartilhado, enquanto tarefas "consumidoras" removem dados desse buffer. Tal problema exige sincronização para evitar condições de corrida (quando múltiplas tarefas competem por um recurso compartilhado) e garantir a cooperação (evitar transbordamento de buffer cheio ou negativo de buffer vazio).

No entanto, para este desafio, foi realizado algo mais direto e simples, que foca na demonstração da execução concorrente de tarefas independentes, sem a complexidade da sincronização de recursos compartilhados, tornando a visualização da concorrência mais imediata.

O exemplo abaixo demonstra a concorrência através da execução "simultânea" de duas tarefas independentes: uma que conta números e outra que imprime letras.

* **`Contador`:** Uma thread que imprime números de 1 a 5, com pausas programadas.
* **`Letras`:** Uma thread que imprime letras de 'A' a 'E', com pausas ligeiramente diferentes.
* **`main`:** A thread principal que cria e inicia as threads `Contador` e `Letras`, e então espera por elas usando `join()` antes de finalizar sua própria execução.

A saída no console mostrará as mensagens de "Contador" e "Letra" intercaladas de forma não determinística, evidenciando que ambas as threads estão sendo executadas concorrentemente.

* **Arquivo:** `ExemploConcorrencia.java`

```java
public class ExemploConcorrencia {

    // Classe que estende Thread para contar números
    static class Contador extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Contador: " + i);
                try {
                    Thread.sleep(500); // pausa de 0,5 segundo
                } catch (InterruptedException e) {
                    System.out.println("Contador interrompido.");
                }
            }
            System.out.println("Contador terminou."); // Mensagem para indicar o fim da thread
        }
    }

    // Classe que estende Thread para imprimir letras
    static class Letras extends Thread {
        public void run() {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Letra: " + c);
                try {
                    Thread.sleep(700); // pausa de 0,7 segundo
                } catch (InterruptedException e) {
                    System.out.println("Letra interrompida.");
                }
            }
            System.out.println("Letras terminou."); // Mensagem para indicar o fim da thread
        }
    }

    public static void main(String[] args) {
        System.out.println("Início da execução concorrente...");

        Contador t1 = new Contador();
        Letras t2 = new Letras();

        t1.start(); // inicia a primeira thread
        t2.start(); // inicia a segunda thread

        try {
            // main() espera t1 e t2 terminarem antes de continuar
            t1.join(); 
            t2.join(); 
        } catch (InterruptedException e) {
            System.out.println("Main interrompida enquanto esperava threads.");
        }

        System.out.println("Fim da execução.");
    }
}
```
# Conclusão
A concorrência é essencial para sistemas modernos, permitindo que eles respondam a múltiplas solicitações e utilizem eficientemente os recursos de hardware. Compreender a diferença entre processos (unidades isoladas de execução) e threads (unidades de execução que compartilham recursos de um processo) é fundamental para projetar e implementar aplicações que aproveitem o paralelismo e a multitarefa de forma eficaz.
