package repositories;

import java.io.PrintWriter;

import entities.Produto;
import interfaces.ProdutoRepository;

public class ProdutoRepositoryTxt implements ProdutoRepository {

	@Override
	public void exportarDados(Produto produto) {

		try {
			PrintWriter printWriter = new PrintWriter("c:\\temp\\produto.txt");

			printWriter.write("\nID DO PRODUTO....: " + produto.getId());
			printWriter.write("\nNOME.............: " + produto.getNome());
			printWriter.write("\nPREÇO............: " + produto.getPreco());
			printWriter.write("\nQUANTIDADE.......: " + produto.getQuantidade());
			printWriter.write("\nTIPO.............: " + produto.getTipo());
			printWriter.write("\nFORNECEDOR.......: " + produto.getFornecedor().getNome());
			printWriter.write("\nCNPJ.............: " + produto.getFornecedor().getCnpj());

			printWriter.flush();
			printWriter.close();
			System.out.println("\nARQUIVO TXT	GRAVADO COM SUCESSO!");

		} catch (Exception e) {
			System.out.println("\n FALHA AO CADASTRAR PRODUTO EM TXT !");
		}

	}

}
