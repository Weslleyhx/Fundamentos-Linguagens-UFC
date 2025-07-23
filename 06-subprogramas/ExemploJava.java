public class ExemploJava {
    
    // --- Classe auxiliar para demonstrar passagem de objeto ---
    // Usaremos esta classe para criar objetos mutáveis (cujo estado pode ser alterado).
    static class MeuNumero {
        int valor;

        public MeuNumero(int valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "MeuNumero{" + "valor=" + valor + '}';
        }
    }

    // --- Demonstração de Passagem de Tipo Primitivo (por Valor) ---
    // 'numero' recebe uma CÓPIA do valor de 'x'.
    // Alterações em 'numero' aqui dentro NÃO afetam a variável original 'x' em main.
    public static void dobrarValorPrimitivo(int numero) {
        System.out.println("  Dentro de dobrarValorPrimitivo (antes): numero = " + numero);
        numero = numero * 2; // Altera apenas a cópia local
        System.out.println("  Dentro de dobrarValorPrimitivo (depois): numero = " + numero);
    }

    // --- Demonstração de Passagem de Objeto (por Valor da Referência) ---
    // 'objNumero' recebe uma CÓPIA do VALOR da REFERÊNCIA de 'meuObjeto' de main.
    // Isso significa que ambos 'objNumero' e 'meuObjeto' apontam para o MESMO objeto na memória.
    // Consequentemente, ALTERAÇÕES NO ESTADO INTERNO do objeto AFETAM o objeto original.
    public static void dobrarValorObjeto(MeuNumero objNumero) {
        System.out.println("  Dentro de dobrarValorObjeto (antes): objNumero.valor = " + objNumero.valor);
        objNumero.valor = objNumero.valor * 2; // Altera o valor dentro do objeto original
        System.out.println("  Dentro de dobrarValorObjeto (depois): objNumero.valor = " + objNumero.valor);

        // ATENÇÃO: Se tentarmos REATRIBUIR 'objNumero' para um NOVO objeto aqui,
        // isso NÃO afetará a variável original 'meuObjeto' em main, pois estamos
        // apenas mudando a CÓPIA da REFERÊNCIA que 'objNumero' possui.
        // objNumero = new MeuNumero(100); // Esta linha não afetaria 'meuObjeto' fora da função
    }

    // --- Demonstração com String (imutáveis) e ArrayList (mutáveis) ---
    // Strings em Java são IMUTÁVEIS. Isso significa que seus valores não podem ser alterados
    // após a criação. Métodos que "modificam" uma String na verdade criam uma NOVA String.
    public static void modificarString(String texto) {
        System.out.println("  Dentro de modificarString (antes): texto = \"" + texto + "\"");
        texto = texto.concat(" MUNDO!"); // Cria uma NOVA String e 'texto' aponta para ela
        System.out.println("  Dentro de modificarString (depois): texto = \"" + texto + "\"");
    }

    // ArrayLists são OBJETOS MUTÁVEIS. Passar um ArrayList significa passar o valor da referência.
    // Podemos adicionar, remover ou modificar elementos dentro do ArrayList original.
    public static void adicionarItemLista(java.util.ArrayList<String> lista) {
        System.out.println("  Dentro de adicionarItemLista (antes): lista = " + lista);
        lista.add("Item Adicionado"); // Modifica o ArrayList original
        System.out.println("  Dentro de adicionarItemLista (depois): lista = " + lista);
    }


    public static void main(String[] args) {
        System.out.println("--- Demonstração de Passagem de Parâmetros em Java ---\n");

        // Exemplo 1: Passagem de Tipo Primitivo (por Valor)
        int valorPrimitivo = 5;
        System.out.println("Main (antes de dobrarValorPrimitivo): valorPrimitivo = " + valorPrimitivo);
        dobrarValorPrimitivo(valorPrimitivo);
        System.out.println("Main (depois de dobrarValorPrimitivo): valorPrimitivo = " + valorPrimitivo + " (não mudou!)\n");

        // Exemplo 2: Passagem de Objeto (por Valor da Referência)
        MeuNumero meuObjeto = new MeuNumero(10);
        System.out.println("Main (antes de dobrarValorObjeto): meuObjeto = " + meuObjeto);
        dobrarValorObjeto(meuObjeto); // Passando a referência do objeto
        System.out.println("Main (depois de dobrarValorObjeto): meuObjeto = " + meuObjeto + " (o valor interno mudou!)\n");

        // Exemplo 3: String (Passagem por Valor, String é imutável)
        String minhaString = "OLÁ";
        System.out.println("Main (antes de modificarString): minhaString = \"" + minhaString + "\"");
        modificarString(minhaString);
        System.out.println("Main (depois de modificarString): minhaString = \"" + minhaString + "\" (não mudou!)\n");

        // Exemplo 4: ArrayList (Passagem por Valor da Referência, ArrayList é mutável)
        java.util.ArrayList<String> minhaLista = new java.util.ArrayList<>();
        minhaLista.add("Maçã");
        minhaLista.add("Banana");
        System.out.println("Main (antes de adicionarItemLista): minhaLista = " + minhaLista);
        adicionarItemLista(minhaLista);
        System.out.println("Main (depois de adicionarItemLista): minhaLista = " + minhaLista + " (o conteúdo mudou!)\n");
    }
}
