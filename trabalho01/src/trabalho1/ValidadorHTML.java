package trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import Lista03.ListaEncadeada;
import Lista03.NoLista;
import Lista05.PilhaLista;
import Lista06.FilaVaziaException;


public class ValidadorHTML {

    String[] singleTonTags = {"meta", "base", "br", "col","command", "embed", "hr", "img", "input", "link", "param", "source", "!doctype"};
    private File file;
    private PilhaLista pilha = new PilhaLista();
    private ListaEncadeada<OcorrenciaDeTag> ocorrenciaTags = new ListaEncadeada<>();

    private int indexLinha = 0;
    private int indexColuna =0;

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

            indexLinha++;

            String linha = sc.nextLine();

            for (int i=0; i<linha.length();i++) {

                indexColuna = i;

                char c = linha.charAt(i);

                if (c == '<') {

                    if (!tagFoiFechada) {
                        throw new SintaxeInvalidaException("A tag " + tag + " não foi fechada corretamente antes de outra tag ser aberta - Linha " + indexLinha + " Coluna " + indexColuna);
                    }

                    verificandoNomeTag = true;

                    tagFoiFechada = false;

                } else if (c == '>') {

                    verificandoNomeTag = false;
                    tagFoiFechada = true;

                    tag = tag.toLowerCase();

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
                    // Ignora comentários
                    if (tag.equals("!--")) {
                        verificandoNomeTag = false;
                        tag = "";
                    }
                }


            }

        }

        if (!pilha.estaVazia()) {
            throw new SintaxeInvalidaException("Existem tags que foram abertas, mas não foram fechadas");
        }
    }

    private void inserirTagPilha(String tag) {

        addOcorrenciaTag(tag);

        for (String singletonTag : singleTonTags) {

            if (singletonTag.equals(tag)) {
                return;
            }
        }

        pilha.push(tag);
    }

    private void removerTagPilha(String tag) {

        String tagPilha;

        try {
            tagPilha = pilha.pop();
        } catch (FilaVaziaException e) {
            throw new SintaxeInvalidaException("A tag " + tag + " foi fechada sem ser aberta - Linha " + indexLinha + " Coluna" + indexColuna);
        }

        if (tagPilha != null) {
            throw new SintaxeInvalidaException("A tag " + tag + " foi fechada, sem ter sido aberta.");
        }

        if (tagPilha.equals(tag.substring(1))) {
            System.out.println("removida tag " + tag);
        } else {
        System.out.println("Era esperado o fechamento da tag " + tagPilha + ", porém foi encontrado o fechamento da tag " + tag + "- Linha " + indexLinha + " Coluna" + indexColuna);
            throw new SintaxeInvalidaException("A tag " + tag + " foi fechada ");
        }
    }

    private void addOcorrenciaTag(String tag) {

        NoLista<OcorrenciaDeTag> no = ocorrenciaTags.getPrimeiro();
        OcorrenciaDeTag tagAtual;

        while (no != null) {

            tagAtual = no.getInfo();

            if (tagAtual.getTag().equals(tag)) {
                tagAtual.addOcorrencia();
                return;
            }

            no = no.getProximo();
        }

        ocorrenciaTags.inserir(new OcorrenciaDeTag(tag));

    }

    public ListaEncadeada<OcorrenciaDeTag> getOcorrenciaTags() {
        return ocorrenciaTags;
    }

}
