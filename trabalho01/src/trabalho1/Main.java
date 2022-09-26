package trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		String path = "C:\\Users\\maasm\\Documents\\Projetos\\Java\\Estrutura-de-dados-T01\\trabalho01\\arquivo.html";

		ValidadorHTML validador = new ValidadorHTML(path);

		validador.validarHTML();

		System.out.println(validador.getOcorrenciaTags());

	}

}
