# Cadastro de Produtos

Sistema de console em Java para cadastro e consulta de 20 produtos (código, nome e preço), com menu interativo.

## Funcionalidades

- Cadastro dos 20 produtos
- Ordenação por código
- Pesquisa binária por código
- Listagem por faixa de preço:
  - acima de R$ 100
  - entre R$ 50 e R$ 100
  - abaixo de R$ 50
- Listagem completa com preço médio

## Como executar

Requisito: JDK instalado (Java 8 ou superior).

1. Clone o repositório:

```
git clone https://github.com/DaviMarinhoR/cadastro-produtos.git
```

2. Abra a pasta em uma IDE Java (IntelliJ, Eclipse, VS Code) ou compile pelo terminal com `javac`
3. Execute a classe `Main`

## Estrutura do projeto

- `Produto.java`: classe com código, nome e preço, construtor, getters e setters
- `Main.java`: menu, cadastro, ordenação, pesquisa binária, filtros por preço e cálculo da média

## Observações

- A pesquisa binária exige que os produtos estejam ordenados por código, então use a opção de ordenação antes de pesquisar.
- Os dados ficam apenas em memória: ao encerrar o programa, os cadastros são perdidos.

## Conceitos praticados

- Arrays de objetos
- Métodos estáticos
- Classes e objetos
- Encapsulamento (getters e setters)
- Algoritmo de ordenação
- Pesquisa binária

## Autor

Davi Marinho
