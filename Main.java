public class Main {

    public static void main(String[] args) {
        ListaEncadeada listaTeste = new ListaEncadeada<>();

        System.out.println(listaTeste);


        Palavra palavraUm = new Palavra("qualquer coisa", 1);
        Palavra palavraDois = new Palavra("outra coisa", 2);
        Palavra palavraTres = new Palavra("uma coisita", 2);
        Palavra palavraQuatro = new Palavra("outra coisa", 2);
        Palavra palavraCinco = new Palavra("qql coisu", 2);

        listaTeste.addItem(palavraCinco);
        System.out.println(listaTeste);

        TabelaHash th = new TabelaHash<>(26);
        th.addNaTabela("palavraCinco");
        th.addNaTabela("palavraDois");
        th.addNaTabela("palavraCinco");
        System.out.println(th);

        System.out.println(th.existeNaTabela("sdfsdfs"));
        System.out.println(th.existeNaTabela("palavraCinco"));



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

    }
}
