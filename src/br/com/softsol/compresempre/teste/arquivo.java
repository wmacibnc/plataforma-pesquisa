package br.com.softsol.compresempre.teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class arquivo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10;
		boolean resultado = i++ < 10 & i++ < 20;
		System.out.println(i++);
	
		File dir = new File("/home/kde/compresempre/tabelas");
		File arq = new File(dir, "agropecuaria.txt");

		try {
			// Indicamos o arquivo que será lido
			FileReader fileReader = new FileReader(arq);

			// Criamos o objeto bufferReader que nos
			// oferece o método de leitura readLine()
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// String que irá receber cada linha do arquivo
			String linha = "";

			// Fazemos um loop linha a linha no arquivo,
			// enquanto ele seja diferente de null.
			// O método readLine() devolve a linha na
			// posicao do loop para a variavel linha.
			PrintStream ps = new PrintStream(
					"/home/kde/compresempre/tabelas/agropecuaria2.txt");
			while ((linha = bufferedReader.readLine()) != null) {
				// Aqui imprimimos a linha
				// linha = linha.replaceAll("]", "");
				linha = linha.replaceAll("\"", "\'");
				System.out.println(linha);
				// ps.println(linha);
				// System.out.println("insert into Produto(codantigo,nome,ncmsh) values("+linha+");");
				ps.println("insert into Produto(codantigo,nome,unidade,fabricante,ncmsh,preço,aplicacao,data) values("
						+ linha + ",'21-12-2012');");

			}

			// liberamos o fluxo dos objetos ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
