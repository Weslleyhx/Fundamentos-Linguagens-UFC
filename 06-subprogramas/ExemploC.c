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
