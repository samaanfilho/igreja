package listaFamilia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ListaCasamento {

	private static String splitter = "	";
	private static String diretorio = "./res/";
	private static String nomeArquivo = diretorio + "LISTA DE FAMILIAS 2016.txt";
	private static String nomeArquivoNovo = diretorio + "LISTA_CASAIS_2016.txt";

	public static void gerarArquivo() throws IOException {
		File arquivo = new File(nomeArquivo);
		File arquivoNovo = new File(nomeArquivoNovo);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "utf-16"));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(arquivoNovo), "utf-16"));

		String linha = reader.readLine();
		String marido = "", mulher = "", casamento = "";
		writer.write("Marido	Esposa	Casamento");
		writer.newLine();
		while ((linha = reader.readLine()) != null) {
			String[] campos = linha.split(splitter);

			if (campos.length == 0) {
				if (!casamento.equals("") && !marido.equals("")) {
					writer.write(marido + "	" + mulher + "	" + casamento);
					writer.newLine();
				}
				casamento = "";
				marido = "";
				mulher = "";
				continue;
			}

			if (campos.length < 4)
				continue;

			if (campos[1].equals("p")) {
				marido = campos[2];
			}

			if (campos[1].equals("m")) {
				mulher = campos[2];
			}

			if (campos.length < 6)
				continue;

			if (!campos[5].equals("")) {
				casamento = campos[5];
			}
		}

		if (!casamento.equals("")) {
			writer.write(marido + "	" + mulher + "	" + casamento);
			writer.newLine();
		}

		writer.flush();
		writer.close();
		reader.close();
	}
}
