# Desafio 13: Linguagens para Scripts e Web - Roteiro de Organização de Arquivos

Para este Desafio 13, a proposta foi explorar o universo das linguagens de script através da criação de um **roteiro** para uma tarefa prática de automação. Em vez de apresentar um script de código completo (que seria a próxima etapa da implementação), este documento detalha o raciocínio e os passos lógicos que seriam seguidos para resolver um problema comum de manipulação de dados.

## Sobre Roteiros e Scripts

No contexto de linguagens de script e automação, um "roteiro" pode ser compreendido como:

1.  **O Planejamento da Automação:** Um guia detalhado, passo a passo, que descreve as ações necessárias para atingir um objetivo. Pode ser pensado como um mapa antes de iniciar a jornada de codificação.
2.  **A Lógica por Trás do Script:** É a essência do que um script fará. Toda a inteligência da automação está contida aqui, pronta para ser traduzida para uma linguagem específica (como Python, Bash, PowerShell, etc.).

Linguagens de script demonstram ser ferramentas eficazes para automatizar tarefas repetitivas, manipular arquivos e agilizar processos, otimizando a eficiência do trabalho.

## Problema Abordado: Organização de uma Pasta de Downloads

**O Cenário:** É comum que uma pasta de `Downloads` (ou qualquer outra pasta de trabalho) se torne desorganizada, contendo uma mistura de arquivos de diferentes tipos: documentos de texto, planilhas, imagens, vídeos, arquivos compactados, PDFs, entre outros. Isso pode dificultar a localização de arquivos específicos.

**O Objetivo Deste Roteiro:** O propósito é delinear um processo lógico para organizar esses arquivos em subpastas específicas, de acordo com sua extensão. Isso visa manter o diretório principal limpo e os arquivos facilmente acessíveis.

## Roteiro em Detalhes: Processo de Organização de Arquivos por Extensão

Este roteiro descreve as etapas lógicas para automatizar a organização de arquivos em um diretório.

### Passo 1: Definição do Diretório de Origem

Inicialmente, é preciso identificar qual pasta será objeto da organização.
* **Ação Essencial:** Determinar o caminho completo da pasta que contém os arquivos misturados (ex: `/home/usuario/Downloads` ou `C:\Users\SeuUsuario\Downloads`).

### Passo 2: Mapeamento de Extensões para Categorias de Pastas

Para cada tipo de arquivo, é necessário estabelecer sua pasta de destino.
* **Ação Essencial:** Criar um "mapa" ou uma lista de regras que associe extensões de arquivo a nomes de pastas.

| Extensão(ões)                 | Nome da Pasta de Destino     | Motivação                  |
| :---------------------------- | :--------------------------- | :------------------------- |
| `.jpg`, `.jpeg`, `.png`, `.gif` | `Imagens`                    | Para arquivos de imagem.   |
| `.mp4`, `.mov`, `.avi`        | `Vídeos`                     | Para arquivos de vídeo.    |
| `.pdf`                        | `Documentos_PDF`             | Para documentos PDF.       |
| `.doc`, `.docx`, `.txt`, `.rtf` | `Documentos_Texto`           | Para arquivos de texto.    |
| `.xls`, `.xlsx`, `.csv`       | `Planilhas`                  | Para arquivos de planilha. |
| `.zip`, `.rar`, `.7z`         | `Arquivos_Compactados`       | Para arquivos compactados. |
| `.exe`, `.msi`, `.dmg`        | `Executáveis_Instaladores`   | Para programas e instaladores. |
| *Qualquer outra extensão* | `Outros_Arquivos`            | Para arquivos não categorizados. |

### Passo 3: Listagem de Todos os Arquivos no Diretório de Origem

É fundamental obter a lista de todos os itens (arquivos e subpastas) dentro do diretório de origem.
* **Ação Essencial:** Percorrer o diretório de origem e identificar cada item.
* **Decisão Lógica Importante:** É crucial ignorar subdiretórios existentes (incluindo as próprias pastas de destino) e focar apenas nos arquivos soltos para o processo de movimentação.

### Passo 4: Processamento Individual de Cada Arquivo

Para cada arquivo encontrado, a lógica de organização será aplicada.
* **Para Cada Arquivo na Lista (Loop):**
    1.  **Obter a Extensão:** Extrair a extensão do nome do arquivo (ex: de `relatorio.pdf`, obter `.pdf`).
    2.  **Determinar a Pasta de Destino:** Utilizar o mapa do Passo 2 para encontrar a categoria de pasta correspondente à extensão. Caso a extensão não esteja no mapa, o arquivo será direcionado para a pasta "Outros_Arquivos".
    3.  **Criação da Pasta de Destino (se necessário):** Verificar a existência da pasta de destino (ex: `Imagens/`) dentro do diretório de origem.
        * **Decisão Lógica:** Se a pasta não existir, ela seria criada.
    4.  **Movimentação do Arquivo:** Mover o arquivo de sua localização atual para a subpasta correta.
        * **Tratamento de Conflito:** Se houver um arquivo com o mesmo nome na pasta de destino, é necessário definir uma estratégia (ex: renomear o novo arquivo adicionando um sufixo como `_copia` ou `_data_hora`, ignorar, ou substituir). A renomeação é geralmente a opção mais segura.
        * **Feedback:** Informar o usuário sobre qual arquivo foi movido e seu destino.

### Passo 5: Conclusão e Relatório Final

Após o processamento de todos os arquivos, um resumo é fornecido.
* **Ação Essencial:** Exibir uma mensagem de conclusão, indicando que a organização foi finalizada.
* **Ação Opcional:** Se aplicável, remover quaisquer pastas temporárias ou vazias criadas durante o processo.

## Da Concepção ao Código: A Transição para um Script

Este roteiro textual representa a base lógica para o desenvolvimento de um script de automação. Cada "Ação" e "Decisão Lógica" descritas podem ser traduzidas diretamente em linhas de código em uma linguagem de script.

* **Python:** Módulos como `os` e `shutil` seriam empregados para listar, criar pastas e mover arquivos. Estruturas de controle como laços `for` e condicionais `if/else` gerenciariam a lógica.
* **Bash (Linux/macOS):** Comandos de terminal como `ls`, `mkdir`, `mv` seriam combinados com estruturas de controle de shell (loops `for`, condicionais `if`).
* **PowerShell (Windows):** Cmdlets como `Get-ChildItem`, `New-Item`, `Move-Item` seriam utilizados para as operações.

A principal vantagem de transformar este roteiro em um script é a capacidade de automatizar todos esses passos, permitindo que a tarefa seja repetida de forma rápida e consistente com um único comando, o que otimiza o tempo e minimiza a ocorrência de erros manuais.
