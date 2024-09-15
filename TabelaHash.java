import java.sql.Array;
import java.util.Arrays;

public class TabelaHash <T>{

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

    public void addNaTabela(String item) {

        boolean ocorrenciaNaTabela = this.existeNaTabela(item);

        if (!ocorrenciaNaTabela) {

            int indice = hash(item);

            if (this.tabela[indice] == null) {
                this.tabela[indice] = new ListaEncadeada<>(item);
            } else {
                this.tabela[indice].addElemento(item);
            }
        }
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
            return this.tabela[indice].existeNaLista(item.toUpperCase());
        }
    }

    public String[] converteParaListaEncadeada () {
        int numElementos = 0;

        for (ListaEncadeada cadaIndice : tabela) {
            if (cadaIndice != null) {
                numElementos += cadaIndice.getTamanhoLista();
            }
        }

        String[] arr = new String[numElementos];

        int indice = 0;
        for (ListaEncadeada cadaIndice : tabela) {
            if (cadaIndice != null) {
                for (int i = 0; i < cadaIndice.getTamanhoLista(); i++) {
                    arr[indice] = (String) cadaIndice.getElemento(i);
                    indice++;
                }
            }
        }

        return arr;
    }

    @Override
    public String toString() {
        return "TabelaHash: [" +
                "tabela = " + Arrays.toString(tabela) +
                ']';
    }
}


