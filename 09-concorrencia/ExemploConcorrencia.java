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