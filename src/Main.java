import br.com.compras.modelo.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Produto> listaProduto = new ArrayList<>();
        double limiteCartao = 0;

        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        System.out.println("Digite o valor limite do cartão: ");
        limiteCartao = scan.nextDouble();

        do {
            Produto produto = new Produto();
            System.out.println("Informe a descrição do produto: ");
            produto.setDescricao(scan.next());
            System.out.println("Informe o valor do produto: ");
            produto.setValor(scan.nextDouble());
            if(produto.getValor() > limiteCartao) {
                System.out.println("Valor do produto maior que o saldo do cartão (Saldo atual: R$ %.2f)".formatted(limiteCartao));
                break;
            }

            listaProduto.add(produto);
            limiteCartao -= produto.getValor();

            System.out.println("Quer continuar comprando? (1) Sim (0) Não");
            opcao = scan.nextInt();
        } while (opcao == 1);

        // Organiza os produtos por valor
        listaProduto.sort(Comparator.comparing(Produto::getValor));

        // Lista os produtos na fatura
        System.out.println("***************************\n");
        System.out.println("COMPRAS REALIZADAS:\n");
        listaProduto.forEach(item -> System.out.println(item.toString()));
        System.out.println("\n***************************");
        System.out.println("Saldo do cartão: R$ %.2f".formatted(limiteCartao));
    }
}