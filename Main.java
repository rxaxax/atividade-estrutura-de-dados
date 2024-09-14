public class Main {

    public static void main(String[] args) {
        ListaEncadeada listaTeste = new ListaEncadeada<>();

//        System.out.println(listaTeste);
//
//
        Palavra palavraUm = new Palavra("qualquer coisa", 1);
        Palavra palavraDois = new Palavra("outra coisa", 2);
        Palavra palavraTres = new Palavra("uma coisita", 2);
//        Palavra palavraQuatro = new Palavra("outra coisa", 2);
//        Palavra palavraCinco = new Palavra("qql coisu", 2);
//
//        listaTeste.addItem(palavraCinco);
//        System.out.println(listaTeste);
//
//        TabelaHash th = new TabelaHash<>(26);
//        th.addNaTabela("palavraCinco");
//        th.addNaTabela("palavraDois");
//        th.addNaTabela("palavraCinco");
//        System.out.println(th);
//
//        System.out.println(th.existeNaTabela("sdfsdfs"));
//        System.out.println(th.existeNaTabela("palavraCinco"));
//        System.out.println(th.tabela[0].getPos("palavraDois"));



      //  th.addNaTabela("palavraUm");
//        th.addNaTabela(palavraDois);
//        th.addNaTabela(palavraTres);
//        th.addNaTabela(palavraQuatro);
//        th.addNaTabela(palavraCinco);

//        palavraUm.setOcorrencia(3);
//        palavraUm.setOcorrencia(8);
//        palavraDois.setOcorrencia(5);
//        palavraTres.setOcorrencia(10);
//        palavraTres.setOcorrencia(12);
//        palavraQuatro.setOcorrencia(8);
//
//        System.out.println(palavraDois.getOcorrencias());

        //System.out.println(palavraTres);
        //System.out.println(palavraQuatro);
        //System.out.println(palavraCinco);


        ListaEncadeada teste = new ListaEncadeada<>();
        teste.addElemento("maçã");
        teste.addElemento("uva");
        teste.addElemento("banana");
        teste.addElemento("melão");
        teste.addElemento("limão");
        teste.addElemento("laranja");
        System.out.println(teste);
        System.out.println(teste.getElemento(4));

        ListaEncadeada palavras = new ListaEncadeada<>();
        palavras.addElemento(palavraUm);
        palavras.addElemento(palavraDois);
        palavras.addElemento(palavraTres);
        System.out.println(palavras);
        System.out.println(palavras.getPos("qualqur coisa"));


    }
}
