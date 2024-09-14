public class Palavra {

    //atributos
    private String palavra;
    private ListaEncadeada<Integer> ocorrencias = new ListaEncadeada<>();

    //construtor
    public Palavra(String palavra, int numLinha) {
        this.palavra = palavra;
        this.ocorrencias.addItem(numLinha);
    }

    //getters e setters
    public String getPalavra() {
        return palavra;
    }

    public ListaEncadeada<Integer> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencia(int numLinha) {
        if (!ocorrencias.existeNaLista(numLinha)) this.ocorrencias.addItem(numLinha);

//        if (ocorrencias.existeNaLista(numLinha)) {
//            //vida que segue
//        } else {
//            this.ocorrencias.addItem(numLinha);
//        }
    }

    @Override
    public String toString() {
        return "Palavra: [" +
                "String = " + palavra + " |" +
                " Ocorrencias = " + ocorrencias +
                ']';
    }
}
