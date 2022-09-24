package trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Lista05.PilhaLista;
import Lista06.FilaVaziaException;


public class ValidadorHTML {

    String[] singleTonTags = {"meta", "base", "br", "col","command", "embed", "hr", "img", "input", "link", "param", "source", "!doctipe"};
    private File file;
    private PilhaLista pilha = new PilhaLista();

    ValidadorHTML(String path) throws FileNotFoundException {
        this.file = new File(path);
    }

    public void validarHTML() throws FileNotFoundException {

        Scanner sc = new Scanner(this.file);


        boolean verificandoNomeTag = false;

        boolean tagFoiFechada = true;
        // ^ Responsável por verificar se a tag anterior foi fechada
        // Utilizada pois a variável verificandoTag só é utilizada para validar o nome da tag,
        // não se ela foi fechada corretamente


        String tag = "";


        while (sc.hasNextLine()) {

            String linha = sc.nextLine();

            for (int i=0; i<linha.length();i++) {

                char c = linha.charAt(i);

                if (c == '<') {

                    if (!tagFoiFechada) {
                        throw new SintaxeInvalidaException("A tag " + tag + " não foi fechada corretamente antes de outra tag ser aberta");
                    }

                    verificandoNomeTag = true;

                    tagFoiFechada = false;

                } else if (c == '>') {

                    verificandoNomeTag = false;
                    tagFoiFechada = true;

                    System.out.print(c);

                    if (!tag.equals("") && tag.charAt(0) == '/') {
                        removerTagPilha(tag);
                    } else if (!tag.equals("")) {
                        inserirTagPilha(tag);
                    }

                    tag = "";

                } else if (c == ' ') {
                    verificandoNomeTag = false;
                } else if (verificandoNomeTag) {
                    tag += c;
                }


            }

        }

    }

    private void inserirTagPilha(String tag) {

        for (String singletonTag : singleTonTags) {
            if (singletonTag.equals(tag)) {
                break;
            }
        }

        pilha.push(tag);
    }

    private void removerTagPilha(String tag) {

        String tagPilha;

        try {
            tagPilha = pilha.pop();
        } catch (FilaVaziaException e) {
            throw new SintaxeInvalidaException("A tag " + tag + " ");
        }

        if (tagPilha.equals(tag.substring(1))) {
            System.out.println("removida tag " + tag);
        } else {
            System.out.println("não foi removida a tag " + tag.substring(1) + " | tag da pilha " + tagPilha);
            throw new SintaxeInvalidaException("A tag " + tag + " foi fechada ");
        }
    }

    //<a href>




}
