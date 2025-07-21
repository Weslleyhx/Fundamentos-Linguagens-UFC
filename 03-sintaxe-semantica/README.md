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
**Exemplo de código em WHScript:**

```WHScript
var saldo = 100
imprimir "Saldo inicial:"
imprimir saldo

se (saldo > 50) entao
    imprimir "Você tem um bom saldo!"
fimse

var contador = 5
enquanto (contador > 0) faca
    imprimir "Contando..."
    imprimir contador
    saldo = saldo + 10 // Exemplo de operação aritmética
    contador = contador - 1
fimenquanto

imprimir "Saldo final:"
imprimir saldo
```
**Mini-Gramática de WHScript (Sintaxe):**

A seguir, a gramática simplificada da WHScript, utilizando uma notação inspirada em BNF para descrever as regras de formação de suas construções:
```
<programa>              ::= {<instrucao>}*

<instrucao>             ::= <declaracao_var>
                          | <condicional>
                          | <laco_repeticao>
                          | <chamada_imprimir>

<declaracao_var>        ::= "var" <identificador> "=" <expressao>

<condicional>           ::= "se" "(" <expressao_booleana> ")" "entao"
                            <programa>
                            "fimse"

<laco_repeticao>        ::= "enquanto" "(" <expressao_booleana> ")" "faca"
                            <programa>
                            "fimenquanto"

<chamada_imprimir>      ::= "imprimir" ( <identificador> | <literal_string> | <literal_numero> )

<expressao_booleana>    ::= <identificador> <operador_comparacao> <expressao>
                          | <literal_numero> <operador_comparacao> <expressao>
                          | <literal_string> <operador_comparacao> <expressao>

<expressao>             ::= <identificador>
                          | <literal_numero>
                          | <literal_string>
                          | <expressao_aritmetica>

<expressao_aritmetica>  ::= <termo_aritmetico> {<operador_aritmetico> <termo_aritmetico>}*

<termo_aritmetico>      ::= <identificador> | <literal_numero>


<identificador>         ::= (letra | "_") (letra | digito | "_")*
<literal_numero>        ::= digito+
<literal_string>        ::= "\"" (qualquer_caractere_exceto_aspas_e_quebra_de_linha)* "\""

<operador_comparacao>   ::= "==" | "!=" | "<" | ">" | "<=" | ">="
<operador_aritmetico>   ::= "+" | "-" | "*" | "/"
```
-***Legenda da Notação:***

* ```::=``` : "é definido como"

* ```|```: "ou" (alternativa)

* ```{ }*```: "zero ou mais ocorrências"

* ```()```  : agrupamento

* ```" "``` : terminal (símbolo literal, palavra-chave, operador)

**Análise Léxica em WHScript:**

A análise léxica é a primeira fase do processamento de um programa, onde o código-fonte é lido e dividido em uma sequência de "tokens". Cada token é uma unidade básica com significado, como palavras-chave, identificadores, operadores ou literais.

-***Exemplo de Análise Léxica para o trecho: ```var saldo = 100```***

| Ordem | Lexema | Tipo de Token | Descrição |
| :---- | :----- | :------------ | :-------- |
| 1     | `var` | PALAVRA\_CHAVE\_VAR | Indica declaração de variável |
| 2     | `saldo` | IDENTIFICADOR | Nome da variável |
| 3     | `=` | OPERADOR\_ATRIBUICAO | Símbolo de atribuição de valor |
| 4     | `100` | NUMERO\_INTEIRO | Valor numérico literal |

## Conclusão

Através da definição de sua sintaxe e da demonstração da análise léxica, fica claro como a WHScript é estruturada e processada. A análise léxica é o passo inicial crucial que transforma o texto bruto do código em uma sequência de tokens significativos, que posteriormente serão utilizados pelas fases sintática e semântica para construir a lógica completa do programa. Esse processo de decomposição e atribuição de significado é fundamental para o funcionamento de qualquer linguagem de programação.
