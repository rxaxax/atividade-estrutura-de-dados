import java.util.Objects;

public class ListaEncadeada<T> {

    final int NAO_ENCONTRADO = -1;

    private class Celula {

        //atributos
        private T valor;
        private Celula apontaPara;

        //getters e setters
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

        //construtores
        public Celula(T valor) {
            setValor(valor);
            setApontaPara(null);
        }

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
    }

    //atributos
    private Celula inicio = null;
    private Celula fim = null;
    private int tamanhoLista = 0;

    //getters e setters
    public T getCelula(Celula celula) {
        return celula.getValor();
    }
    public Celula getInicio() {
        return inicio;
    }
    public void setInicio(Celula inicio) {
        this.inicio = inicio;
    }
    public Celula getFim() {
        return fim;
    }
    public void setFim(Celula fim) {
        this.fim = fim;
    }
    public int getTamanhoLista() {
        return tamanhoLista;
    }

    //construtores
    public ListaEncadeada() {}

    public ListaEncadeada(T item) {
        Celula novaCelula = new Celula(item);
        this.inicio = novaCelula;
        this.fim = novaCelula;
        this.tamanhoLista++;
    }

    //métodos
    public void addItem(T item) {
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
        //se encontrado, retorna a "posição"
        Celula referencia = this.inicio;
        int pos = 0;

        while (referencia != null) {
            if (referencia.getValor().equals(item)) return pos;
            else pos++;
            referencia = referencia.apontaPara;
        }
        return NAO_ENCONTRADO;
    }

    public boolean existeNaLista(T item) {
        if (getPos(item) != -1) return true;
        return false;
    }

//    public Celula getCelula (int pos) {
//        Celula referencia = this.inicio;
//        int pos = 0;
//
//        while (referencia.getApontaPara() != null) {
//            if (referencia.equals(item)) return pos;
//            else pos++;
//            referencia = referencia.apontaPara;
//        }
//        return NAO_ENCONTRADO;
//    }

    @Override
    public String toString() {
        if (this.getInicio() == null) {
            return "[]";
        }

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
