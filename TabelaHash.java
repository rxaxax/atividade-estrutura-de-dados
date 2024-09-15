import java.util.Arrays;

public class TabelaHash {

    //atributos
    public ListaEncadeada[] tabela;

    //getters e setters
    public String getTabela() {
        return Arrays.toString(this.tabela);
    }

    public ListaEncadeada getTabela(int indice) {
        return this.tabela[indice];
    }

    //construtores
    public TabelaHash(int numIndices) {

        this.tabela = new ListaEncadeada[numIndices];

    }

    //métodos
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

//        if (this.tabela[indice] == null) {
//            System.out.println(this.tabela[indice]);
//            this.tabela[indice].addItem(item);
//        } else {
//            if (this.tabela[indice].existeNaLista(item)) {
//                System.out.println(((Palavra)item).getPalavra() + " já existe na tabela.");
//
//                //IMPLEMENTAR
//            }
//        }


    public int hash(String chave) {

        int indice = chave.toUpperCase().charAt(0);
        indice = indice - 'A'; //A = 65, B = 66, C = 67... A = 65 - 65 = 0, B = 66 - 65 = 1, C = 67 - 65 = 2...
        return indice;
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


