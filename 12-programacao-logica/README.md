# Desafio 12: Programação Lógica - Genealogia (Sintaxe Inspirada em Prolog)

Este diretório aborda o paradigma da Programação Lógica, que é fundamentalmente diferente dos paradigmas imperativo e funcional. Aqui, em vez de instruir o computador "como" resolver um problema, descrevemos "o que" sabemos (fatos) e "como" as coisas se relacionam (regras), e então fazemos perguntas para que o sistema infira as respostas.

A modelagem será apresentada usando uma sintaxe inspirada na linguagem **Prolog**, uma das mais conhecidas linguagens de programação lógica.

## O Que é Programação Lógica?

A Programação Lógica é um paradigma declarativo onde o programador define um conjunto de fatos e regras sobre um domínio de conhecimento. O "programa" é, na verdade, uma base de conhecimento. Para obter um resultado, o programador faz uma "consulta" (uma pergunta) a essa base de conhecimento, e o interpretador lógico tenta encontrar provas ou soluções que satisfaçam a consulta, usando inferência lógica.

### Conceitos Chave:

* **Fatos:** São as verdades básicas e incondicionais sobre o domínio. São como as "bases de dados" do sistema.
    * Sintaxe comum (Prolog): `predicado(argumento1, argumento2).`
    * Exemplo: `pai(joao, maria).` (Significa: João é pai de Maria.)
* **Regras:** Definem relacionamentos ou propriedades que podem ser inferidos a partir de fatos ou de outras regras. Elas expressam conhecimento condicional.
    * Sintaxe comum (Prolog): `cabeca :- corpo.` (Significa: "cabeça" é verdadeira SE "corpo" for verdadeiro). O `:-` é lido como "se". A vírgula `,` entre os elementos do corpo é lida como "e".
    * Exemplo: `avo(X, Z) :- pai(X, Y), pai(Y, Z).` (Significa: X é avô de Z SE X é pai de Y E Y é pai de Z.)
* **Consultas:** São as perguntas que fazemos ao sistema. O sistema tenta "satisfazer" a consulta encontrando valores para as variáveis que tornem a consulta verdadeira.
    * Sintaxe comum (Prolog): `?- consulta.`
    * Exemplo: `?- pai(joao, X).` (Significa: Quem é filho(a) de João?)

## Problema Modelado: Relações Genealógicas

Foi feito uma pequena árvore genealógica para demonstrar esses conceitos.
### 1. Fatos (Base de Conhecimento)

Aqui, definimos as relações básicas e os sexos de cada indivíduo.

```prolog
% Fatos sobre os indivíduos e seus sexos
homem(joao).
homem(pedro).
homem(carlos).
homem(rafael).
homem(luiz).

mulher(maria).
mulher(ana).
mulher(julia).
mulher(sofia).
mulher(beatriz).

% Fatos sobre parentesco (pai/mae de quem)
pai(joao, carlos).
pai(joao, julia).
mae(maria, carlos).
mae(maria, julia).

pai(carlos, ana).
pai(carlos, rafael).
mae(sofia, ana).
mae(sofia, rafael).

pai(pedro, luiz).
mae(beatriz, luiz).

% Fatos sobre casamento (quem é casado com quem)
casados(joao, maria).
casados(maria, joao). % Regra simétrica para facilitar consultas

casados(carlos, sofia).
casados(sofia, carlos).

casados(pedro, beatriz).
casados(beatriz, pedro).
```
### 2. Regras (Inferência de Novas Relações)
```prolog
% filho(Filho, PaiOuMae): Filho é filho(a) de PaiOuMae
filho(F, P) :- pai(P, F).
filho(F, P) :- mae(P, F).

% irmao(X, Y): X é irmão de Y
irmao(X, Y) :-
    pai(P, X), pai(P, Y), % Têm o mesmo pai
    mae(M, X), mae(M, Y), % Têm a mesma mãe
    homem(X),             % X é homem
    X \= Y.               % X e Y não são a mesma pessoa (X diferente de Y)

% irma(X, Y): X é irmã de Y
irma(X, Y) :-
    pai(P, X), pai(P, Y),
    mae(M, X), mae(M, Y),
    mulher(X),
    X \= Y.

% avo(Avo, NetoOuNeta): Avo é avô/avó de NetoOuNeta
avo(A, N) :-
    pai(A, P), % A é pai de P
    filho(N, P). % P é pai/mãe de N (usamos a regra filho aqui)

avo(A, N) :-
    mae(A, M), % A é mãe de M
    filho(N, M). % M é pai/mãe de N

% neto(Neto, Avo): Neto é neto(a) de Avo
neto(N, A) :- avo(A, N). % Neto é neto de Avo SE Avo é avô/avó de Neto

% tio(Tio, SobrinhoOuSobrinha): Tio é tio de SobrinhoOuSobrinha
tio(T, S) :-
    irmao(T, P), % T é irmão do pai/mãe de S
    pai(P, S).
tio(T, S) :-
    irmao(T, M), % T é irmão da mãe/pai de S
    mae(M, S).

% tia(Tia, SobrinhoOuSobrinha): Tia é tia de SobrinhoOuSobrinha
tia(T, S) :-
    irma(T, P), % T é irmã do pai/mãe de S
    pai(P, S).
tia(T, S) :-
    irma(T, M), % T é irmã da mãe/pai de S
    mae(M, S).

% progenitor(P, F): P é progenitor (pai ou mãe) de F
progenitor(P, F) :- pai(P, F).
progenitor(P, F) :- mae(P, F).

% parent_of(P, C): P é pai/mãe de C (outra forma de progenitor)
parent_of(P, C) :- pai(P, C).
parent_of(P, C) :- mae(P, C).

% sibling(S1, S2): S1 e S2 são irmãos (considerando pai/mãe em comum)
sibling(S1, S2) :-
    parent_of(P, S1),
    parent_of(P, S2),
    S1 \= S2. % Não são a mesma pessoa
```
## Conclusão
A Programação Lógica oferece uma perspectiva única sobre a resolução de problemas, focando na descrição do conhecimento e das relações. Ela é particularmente adequada para problemas onde a lógica de inferência é complexa, como sistemas especialistas, processamento de linguagem natural e inteligência artificial. Ao invés de escrever algoritmos passo a passo, o programador define as condições e regras, deixando o motor lógico do interpretador encontrar as soluções.
