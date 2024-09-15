public class Palavra {

    //ATRIBUTOS
    private String palavra;

    private ListaEncadeada<Integer> ocorrencias = new ListaEncadeada<>();

    //GETTERS E SETTERS
    public String getPalavra() {
        return palavra;
    }

    public ListaEncadeada<Integer> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencia(int numLinha) {
        if (!ocorrencias.existeNaLista(numLinha)) {
            this.ocorrencias.addElemento(numLinha);
        }
    }

    //CONSTRUTORES
    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    public Palavra(String palavra, int numLinha) {
        this.palavra = palavra;
        this.ocorrencias.addElemento(numLinha);
    }

    //MÉTODOS
    @Override
    public String toString() {
        return "Palavra: [" +
                "String = " + palavra + " |" +
                " Ocorrencias = " + ocorrencias +
                ']';
    }
}
