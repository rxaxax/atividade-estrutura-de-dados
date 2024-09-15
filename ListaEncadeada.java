import java.util.Objects;

public class ListaEncadeada<T> {

    private final int NAO_ENCONTRADO = -1;

    private class Celula {

        //ATRIBUTOS
        private T valor;

        private Celula apontaPara;

        //GETTERS E SETTERS
        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public Celula getApontaPara() {
            return apontaPara;
        }

        public void setApontaPara(Celula apontaPara) {
            this.apontaPara = apontaPara;
        }

        //CONSTRUTORES
        public Celula(T valor) {
            setValor(valor);
            setApontaPara(null);
        }

        //MÉTODOS
        public boolean equals(Object o) {
            if (this.valor == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Celula celula = ((Celula) o);
            return Objects.equals(valor, celula.valor);
        }

        @Override
        public String toString() {
            return "Celula: [" +
                    "valor = " + valor +
                    ']';
        }
        //FIM CELULA
    }

    //ATRIBUTOS
    private Celula inicio = null;

    private Celula fim = null;

    private int tamanhoLista = 0;

    //GETTERS E SETTERS
    private T getCelula(Celula celula) {
        return celula.getValor();
    }

    public int getTamanhoLista() {
        return tamanhoLista;
    }

    //CONSTRUTORES
    public ListaEncadeada() {}

    public ListaEncadeada(T item) {
        Celula novaCelula = new Celula(item);
        this.inicio = novaCelula;
        this.fim = novaCelula;
        this.tamanhoLista++;
    }

    //MÉTODOS
    public void addElemento(T item) {

        Celula novaCelula = new Celula(item);

        if (this.inicio == null) {
            this.inicio = novaCelula;
        } else {
            this.fim.apontaPara = novaCelula;
        }

        this.fim = novaCelula;
        this.tamanhoLista++;
    }

    public int getPos(T item) {

        Celula referencia = this.inicio;
        int pos = 0;

        while (referencia != null) {

            if (referencia.getValor().equals(item)) return pos;

            pos++;
            referencia = referencia.apontaPara;
        }

        return NAO_ENCONTRADO;
    }

    public int getPos(String item) {

        Celula referencia = this.inicio;
        int pos = 0;

        while (referencia != null) {

            if (referencia.getValor() instanceof Palavra) {

                Palavra palavra = (Palavra) referencia.getValor();
                if (palavra.getPalavra().equals(item.toUpperCase())) return pos;
            } else {
                if (referencia.getValor().equals(item)) {
                    return pos;
                }

            }

            pos++;
            referencia = referencia.apontaPara;
        }
        return NAO_ENCONTRADO;
    }

    private Celula buscaPos(int pos) {

        if (!(pos >= 0 && pos <= this.tamanhoLista)) {
            throw new NullPointerException("Posição buscada não existe na lista.");
        }

        Celula referencia = this.inicio;

        for (int i = 0; i < pos; i++) {
            referencia = referencia.apontaPara;
        }

        return referencia;
    }

    public T getElemento(int pos) {
        return this.buscaPos(pos).getValor();
    }

    public boolean existeNaLista(T item) {
        if (getPos(item) != -1) return true;
        return false;
    }

    public boolean existeNaLista(String item) {
        if (getPos(item) != -1) return true;
        return false;
    }

    @Override
    public String toString() {

        if (this.inicio == null) return "[]";

        StringBuilder palavras = new StringBuilder("[");
        Celula atual = this.inicio;

        for (int i = 0; i < tamanhoLista; i++) {

            while (atual.apontaPara != null) {

                palavras.append(atual.getValor() + ", ");
                atual = atual.apontaPara;
            }
        }

        palavras.append(atual.getValor() + "]");
        return palavras.toString();
    }

}
