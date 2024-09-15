import java.util.Arrays;

public class TabelaHash {

    //ATRIBUTOS
    private ListaEncadeada[] tabela;

    //GETTERS E SETTERS
    public String getTabela() {
        return Arrays.toString(this.tabela);
    }

    public ListaEncadeada getTabela(int indice) {
        return this.tabela[indice];
    }

    //CONSTRUTORES
    public TabelaHash(int numIndices) {
        this.tabela = new ListaEncadeada[numIndices];
    }

    //MÉTODOS
    public int hash(String chave) {

        int indice = chave.toUpperCase().charAt(0);
        indice = indice - 'A';

        return indice;
    }

    public void addNaTabela(Palavra item) {

        boolean ocorrenciaNaTabela = this.existeNaTabela(item.getPalavra());

        if (!ocorrenciaNaTabela) {

            int indice = hash(item.getPalavra());

            if (this.tabela[indice] == null) {
                this.tabela[indice] = new ListaEncadeada<>(item);
            } else {
                this.tabela[indice].addElemento(item);
            }
        }
    }

    public boolean existeNaTabela(String item) {

        int indice = hash(item);

        if (this.tabela[indice] == null) {
            return false;
        } else {
            return this.tabela[indice].existeNaLista(item);
        }
    }

    @Override
    public String toString() {
        return "TabelaHash: [" +
                "tabela = " + Arrays.toString(tabela) +
                ']';
    }
}


