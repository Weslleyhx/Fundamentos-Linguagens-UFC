# Desafio 3: Descrições Sintáticas e Semânticas

Este diretório explora os conceitos fundamentais de sintaxe e semântica em linguagens de programação, que definem como o código é estruturado e qual o seu significado. Para exemplificar, criei uma mini-linguagem fictícia e demonstro como o processo de análise léxica atua sobre ela.

## Sintaxe e Semântica

* **Sintaxe:** Refere-se ao conjunto de regras formais que determinam a estrutura e a combinação válida de elementos (como palavras-chave, operadores, identificadores) para formar sentenças ou programas bem-formados em uma linguagem. É análogo à gramática de uma linguagem natural. Erros de sintaxe impedem que o código seja processado.
* **Semântica:** Diz respeito ao significado das construções da linguagem que são sintaticamente corretas. Mesmo que um trecho de código siga todas as regras sintáticas, sua semântica pode ser ambígua, ineficaz ou incorreta (por exemplo, dividir por zero é um erro semântico, não sintático).

## Minha Linguagem Fictícia: "WHScript"

Para este desafio, desenvolvi uma mini-linguagem de script chamada **WHScript**. Ela é projetada para ser uma linguagem básica e intuitiva, ideal para demonstrar conceitos de variáveis, condicionais, laços de repetição e operações de entrada/saída simples.

**Características Principais da WHScript:**
* **Declaração de variáveis:** Utiliza a palavra-chave `var`.
* **Saída de dados:** O comando `imprimir` exibe valores ou mensagens.
* **Condicionais:** Estrutura `se (condicao) entao ... fimse`.
* **Laços de Repetição:** Estrutura `enquanto (condicao) faca ... fimenquanto`.
* **Operadores:** Suporte a operadores de atribuição, comparação e aritméticos.
