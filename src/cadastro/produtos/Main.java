package cadastro.produtos.cadastro.produtos;

import java.util.Scanner;

public class Main {
    static Produto[] produtos = new Produto[20];
    static Scanner scanner = new Scanner(System.in);
    static boolean cadastrado = false;
    static boolean ordenado = false;

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

    public static boolean verificarCadastro() {
        if (!cadastrado) {
            System.out.println("\nCadastre os produtos primeiro!\n");
            return false;
        }
        return true;
    }

    public static boolean verificarOrdenacao() {
        if (!ordenado) {
            System.out.println("\nVerifique a opção 2 para ordenar os registros.\n");
            return false;
        }
        return true;
    }

    public static void exibirProduto(Produto p) {
        System.out.println("Código: " + p.getCodigo());
        System.out.println("Nome: " + p.getNome());
        System.out.println("Preço: " + p.getPreco());
    }

    public static void cadastrarProduto() {
        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Código: ");
            String codigoProduto = scanner.nextLine();

            System.out.println("Nome: ");
            String nomeProduto = scanner.nextLine();

            System.out.println("Preco: ");
            double precoProduto = scanner.nextDouble();
            scanner.nextLine();

            produtos[i] = new Produto(codigoProduto, nomeProduto, precoProduto);
        }
        cadastrado = true;
        ordenado = false;
    }

    public static double calcularPrecoMedio() {
        double somaPrecos = 0;
        for (Produto p : produtos) {
            somaPrecos += p.getPreco();
        }
        return somaPrecos / produtos.length;
    }

    public static void ordenarProdutos() {
        if (!verificarCadastro()) return;
        for (int i = 0; i < produtos.length - 1; i++) {
            for (int j = i + 1; j < produtos.length; j++) {
                if (produtos[i].getCodigo().compareTo(produtos[j].getCodigo()) > 0) {
                    Produto aux = produtos[i];
                    produtos[i] = produtos[j];
                    produtos[j] = aux;
                }
            }
        }
        System.out.println("\nOrdenação concluída!\n");
        ordenado = true;
    }

    public static void pesquisarProduto() {
        if (!verificarCadastro()) return;
        if (!verificarOrdenacao()) return;

        System.out.println("Pesquise por um produto (código): ");
        String codigoPesquisa = scanner.nextLine();

        int inicio = 0;
        int fim = produtos.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = codigoPesquisa.compareTo(produtos[meio].getCodigo());

            if (comparacao == 0) {
                exibirProduto(produtos[meio]);
                return;
            } else if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        System.out.println("\nProduto não encontrado entre os registros.\n");
    }

    public static void listarAcimaDe100() {
        if (!verificarCadastro()) return;
        if (!verificarOrdenacao()) return;

        boolean achou = false;
        for (Produto p : produtos) {
            if (p.getPreco() > 100.0) {
                exibirProduto(p);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("\nSem registros.\n");
        }
    }

    public static void listarEntre50E100() {
        if (!verificarCadastro()) return;
        if (!verificarOrdenacao()) return;
        boolean achou = false;

        for (Produto p : produtos) {
            if (p.getPreco() >= 50.0 && p.getPreco() <= 100.0) {
                exibirProduto(p);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("\nSem registros.\n");
        }
    }

    public static void listarAbaixoDe50() {
        if (!verificarCadastro()) return;
        if (!verificarOrdenacao()) return;

        boolean achou = false;
        for (Produto p : produtos) {
            if (p.getPreco() < 50.0) {
                exibirProduto(p);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("\nSem registros.\n");
        }
    }

    public static void listarTodos() {
        if (!verificarCadastro()) return;
        for (int i = 0; i < produtos.length; i++) {
            System.out.println("\nCADASTRO " + (i + 1));
            exibirProduto(produtos[i]);
        }
        System.out.println("\nMÉDIA DO PREÇO DOS PRODUTOS: " + calcularPrecoMedio());
    }

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    ordenarProdutos();
                    break;

                case 3:
                    pesquisarProduto();
                    break;

                case 4:
                    listarAcimaDe100();
                    break;

                case 5:
                    listarEntre50E100();
                    break;

                case 6:
                    listarAbaixoDe50();
                    break;

                case 7:
                    listarTodos();
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