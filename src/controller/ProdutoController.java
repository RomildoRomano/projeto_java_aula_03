package controller;

import java.util.Scanner;
import java.util.UUID;

import entities.Fornecedor;
import entities.Produto;
import enums.TipoProduto;
import interfaces.ProdutoRepository;
import repositories.ProdutoRepositoryTxt;
import repositories.ProdutoRepositoryXml;

public class ProdutoController {

	public void CadastrarPorduto() {

		Scanner scanner = new Scanner(System.in);

		try {
			Produto produto = new Produto();

			produto.setFornecedor(new Fornecedor());
			produto.setId(UUID.randomUUID());

			System.out.println("****** CADASTRAR PRODUTO******");

			System.out.print("NOME.......:");
			produto.setNome(scanner.nextLine());

			System.out.print("PRECO......:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));
			System.out.print("QUANTIDADE...:");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			System.out.print("DIGITE [1] PERECIVEL [2] NAO PERECIVEL :");

			Integer opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {
			case 1:
				produto.setTipo(TipoProduto.PERECIVEL);
				break;
			case 2:
				produto.setTipo(TipoProduto.NAO_PERECIVEL);
				break;
			default:
				throw new IllegalArgumentException(" OPCAO INVALIDA ! ");
			}

			System.out.print("NOME DO FORNECEDOR.....:");
			produto.getFornecedor().setNome(scanner.nextLine());
			System.out.print(" CNPJ.........:");
			produto.getFornecedor().setCnpj(scanner.nextLine());

			System.out.print(" ESCOLHA [1] PARA TXT [2] PARA XML:");
			Integer tipo = Integer.parseInt(scanner.nextLine());
			ProdutoRepository produtoRepository = null;

			switch (tipo) {
			case 1:
				produtoRepository = new ProdutoRepositoryTxt();
				break;

			case 2:
				produtoRepository = new ProdutoRepositoryXml();
				break;

			default:
				throw new IllegalArgumentException("FALHA AO CADASTRAR ARQUIVO ! ");

			}
			produtoRepository.exportarDados(produto);

		} catch (Exception e) {

			System.out.println("\n FALHA AO CADASTRAR PRODUTOS !");
			System.out.println(e.getMessage());

		} finally {
			scanner.close();
		}

	}

}
