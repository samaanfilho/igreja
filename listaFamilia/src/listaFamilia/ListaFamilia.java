package listaFamilia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ListaFamilia {

	private static String splitter = "	";
	private static String diretorio = "./res/";
	private static String nomeArquivo = diretorio + "LISTA DE FAMILIAS 2016.txt";
	private static String nomeArquivoNovo = diretorio + "LISTA_FAMILIAS_2016.txt";
	
	public static void gerarArquivo() throws IOException {
		File arquivo = new File(nomeArquivo);
		File arquivoNovo = new File(nomeArquivoNovo);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "utf-16"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoNovo), "utf-16"));
		processarArquivo(reader, writer);
	}

	private static void processarArquivo(BufferedReader reader, BufferedWriter writer) throws IOException {
		String linha = reader.readLine();
		String novaLinha = linha + "	" + linha + "	" + linha + "	" + linha + "	" + linha + "	" + linha;
		writer.write(novaLinha);
		writer.newLine();
		novaLinha = "";
		while ((linha = reader.readLine()) != null) {
			if (linha.split(splitter).length == 0) {
				writer.write(novaLinha);
				writer.newLine();
				novaLinha = "";
				continue;
			}
			novaLinha += linha + "	";
		}
		if (novaLinha != "") {
			writer.write(novaLinha);
			writer.newLine();
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
}
