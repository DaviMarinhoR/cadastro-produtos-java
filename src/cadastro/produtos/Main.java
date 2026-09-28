package cadastro.produtos.cadastro.produtos;

import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("\n=====MENU=====\n");
        System.out.println("1.Cadastrar os 20 produtos.");
        System.out.println("2.Classificar os registros por código.");
        System.out.println("3.Pesquisar por um produto.");
        System.out.println("4.Apresentar, de forma ordenada, os registros dos produtos com preço acima de R$ 100,00");
        System.out.println("5.Apresentar, de forma ordenada, os registros dos produtos com preço entre R$ 50,00 e R$ 100,00.");
        System.out.println("6.Apresentar, de forma ordenada, os registros dos produtos com preço abaixo de R$ 50,00");
        System.out.println("7.Apresentar todos os registros e informar o preço médio dos produtos cadastrados.");
        System.out.println("8.Sair do programa.\n");
    }

    public static void main(String[] args) {
        Product[] products = new Product[20];
        Scanner scanner = new Scanner(System.in);
        Product aux;

        int i, j;
        int opcao;
        String pesquisa;
        int cadastrado = 0, ordenado = 0;
        int inicio, meio = 0, fim, encontrou;
        int achouRegistro;
        double precoMedio = 0, somaPrecos;

        do {
            menu();
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {

                case 1:
                    somaPrecos = 0;
                    for (i = 0; i < products.length; i++) {
                        System.out.println("CADASTRO " + (i + 1));

                        System.out.println("Código: ");
                        String codigo = scanner.nextLine();

                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.println("Preço: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();

                        products[i] = new Product(codigo, nome, preco);
                    }

                    for (i = 0; i < products.length; i++) {
                        somaPrecos += products[i].getPreco();
                    }
                    precoMedio = somaPrecos / products.length;

                    cadastrado = 1;
                    ordenado = 0;
                    break;

                case 2:
                    if (cadastrado == 0) {
                        System.out.println("\nCadastre os produtos primeiro!.\n");
                        break;
                    }

                    for (i = 0; i < products.length - 1; i++) {
                        for (j = i + 1; j < products.length; j++) {
                            if (products[i].getCodigo().compareTo(products[j].getCodigo()) > 0) {
                                aux = products[i];
                                products[i] = products[j];
                                products[j] = aux;
                            }
                        }
                    }
                    System.out.println("\nOrdenação concluída.!\n");
                    ordenado = 1;
                    break;

                case 3:
                    if (cadastrado == 0) {
                        System.out.println("\nCadastre os produtos primeiro!.\n");
                        break;
                    }
                    if (ordenado == 0) {
                        System.out.println("\nUtilize a opção 2 para ordenar os registros.!\n");
                        break;
                    }
                    System.out.println("Pesquise por um produto (código): ");
                    pesquisa = scanner.nextLine();

                    encontrou = 0;
                    inicio = 0;
                    fim = products.length - 1;

                    while (inicio <= fim) {
                        meio = (inicio + fim) / 2;

                        if (products[meio].getCodigo().compareTo(pesquisa) == 0) {
                            encontrou = 1;
                            break;
                        } else if (pesquisa.compareTo(products[meio].getCodigo()) < 0) {
                            fim = meio - 1;
                        } else {
                            inicio = meio + 1;
                        }
                    }
                    if (encontrou == 1) {
                        System.out.println("\nCódigo: " + products[meio].getCodigo());
                        System.out.println("\nNome: " + products[meio].getNome());
                        System.out.println("\nPreço: " + products[meio].getPreco());
                    } else {
                        System.out.println("\nProduto não encontrado entre os registros.\n");
                    }
                    break;

                case 4:
                    if (cadastrado == 0) {
                        System.out.println("\nCadastre os produtos primeiro!.\n");
                        break;
                    }
                    if (ordenado == 0) {
                        System.out.println("\nUtilize a opção 2 para ordenar os registros.\n");
                        break;
                    }
                    achouRegistro = 0;
                    for (i = 0; i < products.length; i++) {
                        if (products[i].getPreco() > 100.0) {
                            System.out.println("Código: " + products[i].getCodigo());
                            System.out.println("Nome: " + products[i].getNome());
                            System.out.println("Preço: " + products[i].getPreco());
                            achouRegistro = 1;
                        }
                    }
                    if (achouRegistro == 0) {
                        System.out.println("\nSem registros.\n");
                    }
                    break;

                case 5:
                    if (cadastrado == 0) {
                        System.out.println("\nCadastre os produtos primeiro!.\n");
                        break;
                    }
                    if (ordenado == 0) {
                        System.out.println("\nUtilize a opção 2 para ordenar os registros.\n");
                        break;
                    }
                    achouRegistro = 0;
                    for (i = 0; i < products.length; i++) {
                        if (products[i].getPreco() >= 50.0 && products[i].getPreco() <= 100.0) {
                            System.out.println("Código: " + products[i].getCodigo());
                            System.out.println("Nome: " + products[i].getNome());
                            System.out.println("Preço: " + products[i].getPreco());
                            achouRegistro = 1;
                        }
                    }
                    if (achouRegistro == 0) {
                        System.out.println("\nSem registros.\n");
                    }
                    break;

                case 6:
                    if (cadastrado == 0) {
                        System.out.println("\nCadastre os produtos primeiro!.\n");
                        break;
                    }
                    if (ordenado == 0) {
                        System.out.println("\nUtilize a opção 2 para ordenar os registros.\n");
                        break;
                    }
                    achouRegistro = 0;
                    for (i = 0; i < products.length; i++) {
                        if (products[i].getPreco() < 50.0) {
                            System.out.println("Código: " + products[i].getCodigo());
                            System.out.println("Nome: " + products[i].getNome());
                            System.out.println("Preço: " + products[i].getPreco());
                            achouRegistro = 1;
                        }
                    }
                    if (achouRegistro == 0) {
                        System.out.println("\nSem registros.\n");
                    }
                    break;

                case 7:
                    if (cadastrado == 0) {
                        System.out.println("\nCadastre os produtos primeiro!.\n");
                        break;
                    }
                    for (i = 0; i < products.length; i++) {
                        System.out.println("\nCADASTRO " + (i + 1));
                        System.out.println("\nCódigo: " + products[i].getCodigo());
                        System.out.println("\nNome: " + products[i].getNome());
                        System.out.println("\nPreço: " + products[i].getPreco());
                    }
                    System.out.println("\nMÉDIA DO PREÇO DOS PRODUTOS: " + precoMedio);
                    break;

                case 8:
                    System.out.println("\nSaindo...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
                    break;
            }
        } while (opcao != 8);
    }
}