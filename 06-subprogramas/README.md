# Desafio 6: Subprogramas - Passagem de Parâmetros (Valor vs. Referência)

Este diretório demonstra como a passagem de parâmetros funciona em subprogramas (funções/métodos), especificamente as diferenças entre **passagem por valor** e **passagem por referência (ou por valor da referência)**. Utilizo as linguagens C e Java para ilustrar esses conceitos cruciais.

## O que são Passagem por Valor e por Referência?

A forma como os argumentos são transmitidos para uma função/método afeta se as alterações feitas nesses argumentos dentro da função se refletem na variável original fora dela.

* **Passagem por Valor:** Uma **cópia** do valor do argumento é entregue à função. Qualquer modificação na cópia dentro da função **não afeta** a variável original.
* **Passagem por Referência (ou "por Valor da Referência" em Java):** A função recebe uma **referência** (como um endereço de memória) para a variável original. Isso permite que a função trabalhe diretamente com a variável original, e as alterações **afetam** o valor original. Em Java, todos os parâmetros são passados por valor; para objetos, o que é passado por valor é a **referência** para o objeto, permitindo modificar o conteúdo do objeto original.

## 1. Demonstração em Linguagem C

Em C, podemos demonstrar explicitamente a passagem por valor e simular a passagem por referência usando **ponteiros**. Arrays, por outro lado, são sempre passados como ponteiros para seu primeiro elemento, comportando-se como "por referência".

* **Arquivo:** `ExemploC.c`

```c
#include <stdio.h> // Inclui a biblioteca padrão de entrada e saída para funções

// --- Demonstração de Passagem por Valor ---
// Esta função recebe uma CÓPIA do valor de 'x'.
// Qualquer alteração feita em 'numero' aqui dentro NÃO afetará a variável original 'x' fora da função.
void dobrarValor(int numero) {
    printf("  Dentro de dobrarValor (antes): numero = %d\n", numero);
    numero = numero * 2; // Altera apenas a cópia local
    printf("  Dentro de dobrarValor (depois): numero = %d\n", numero);
}

// --- Demonstração de Passagem por Referência (usando ponteiros) ---
// Esta função recebe o ENDEREÇO de memória da variável original 'x'.
// O '*' antes de 'ponteiroNumero' indica que estamos trabalhando com o VALOR apontado por esse endereço.
// Qualquer alteração feita em '*ponteiroNumero' AFETARÁ a variável original 'x' fora da função.
void dobrarReferencia(int *ponteiroNumero) {
    printf("  Dentro de dobrarReferencia (antes): *ponteiroNumero = %d\n", *ponteiroNumero);
    *ponteiroNumero = *ponteiroNumero * 2; // Altera o valor no endereço de memória original
    printf("  Dentro de dobrarReferencia (depois): *ponteiroNumero = %d\n", *ponteiroNumero);
}

// --- Demonstração de Arrays (sempre passados por "referência" em C) ---
// Quando um array é passado como parâmetro em C, o que é realmente passado é o endereço
// de memória do seu primeiro elemento (um ponteiro para o tipo base do array).
// Isso significa que modificações dentro da função AFETAM o array original.
void modificarArray(int arr[], int tamanho) {
    printf("  Dentro de modificarArray (antes): arr[0] = %d\n", arr[0]);
    if (tamanho > 0) {
        arr[0] = 99; // Modifica o primeiro elemento do array original
    }
    printf("  Dentro de modificarArray (depois): arr[0] = %d\n", arr[0]);
}


int main() {
    printf("--- Demonstracao de Passagem de Parametros em C ---\n\n");

    // Exemplo 1: Passagem por Valor
    int meuValor = 5;
    printf("Main (antes de dobrarValor): meuValor = %d\n", meuValor);
    dobrarValor(meuValor); // Passando o valor de meuValor (uma cópia)
    printf("Main (depois de dobrarValor): meuValor = %d (não mudou!)\n\n", meuValor);

    // Exemplo 2: Passagem por Referência (usando ponteiro)
    int minhaReferencia = 10;
    printf("Main (antes de dobrarReferencia): minhaReferencia = %d\n", minhaReferencia);
    dobrarReferencia(&minhaReferencia); // Passando o ENDEREÇO de minhaReferencia usando '&'
    printf("Main (depois de dobrarReferencia): minhaReferencia = %d (mudou!)\n\n", minhaReferencia);

    // Exemplo 3: Arrays (sempre por "referência" em C)
    int meuArray[] = {1, 2, 3};
    int tamanhoArray = sizeof(meuArray) / sizeof(meuArray[0]); // Calcula o tamanho do array

    printf("Main (antes de modificarArray): meuArray[0] = %d\n", meuArray[0]);
    modificarArray(meuArray, tamanhoArray); // Passando o array (endereço do primeiro elemento)
    printf("Main (depois de modificarArray): meuArray[0] = %d (mudou!)\n\n", meuArray[0]);

    return 0; // Indica que o programa terminou com sucesso
}
```
## 2. Demonstração em Linguagem Java
Em Java utiliza apenas passagem por valor. No entanto, a distinção é importante:
* Para tipos primitivos (int, float, boolean, etc.), o valor é copiado.
* Para objetos, o valor da referência (o endereço de memória onde o objeto está) é copiado. Isso significa que a função acessa o mesmo objeto na memória e pode alterar seu estado interno, mas não pode fazer a variável original apontar para um novo objeto. Strings em Java são um caso especial, pois são objetos imutáveis.

* **Arquivo:** `ExemploJava.java`

```java
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
```
## Conclusão
A forma como parâmetros são passados para subprogramas é uma distinção crucial entre linguagens. C oferece controle explícito sobre a passagem por valor e a simulação de referência via ponteiros, permitindo manipulação direta de memória. Em contraste, Java sempre adota a passagem por valor. Contudo, para objetos, o valor da referência é passado, o que confere a capacidade de modificar o estado interno do objeto original, mantendo a robustez da tipagem da linguagem. Compreender essas pequenas diferenças é fundamental para prever o comportamento do código e evitar efeitos colaterais indesejados.
