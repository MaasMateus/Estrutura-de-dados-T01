package trabalho1;

public class OcorrenciaDeTag {

    String tag;
    int ocorrencias;


    OcorrenciaDeTag(String tag) {

        this.tag = tag;
        ocorrencias = 1;
    }


    public String getTag() {
        return tag;
    }

    public void addOcorrencia() {
        ocorrencias += 1;
    }

    @Override
    public String toString() {
        return "Tag: " + tag + " Ocorrências: " + ocorrencias + "\n";
    }

}
