import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String enderecoArquivo = "C:\\Users\\Renato\\Desktop\\atividade-final-estrutura-de-dados\\in.txt";

        TabelaHash th = new TabelaHash(26);

        try (FileReader fr = new FileReader(enderecoArquivo);
             BufferedReader br = new BufferedReader(fr)) {


            String linha = br.readLine();
            int numLinha = 1;

            while (linha != null) {

                String linhaNormalizada = Normalizer.normalize(linha, Normalizer.Form.NFD);
                linhaNormalizada = linhaNormalizada.replaceAll("\\p{M}", "");
                String[] palavras = linhaNormalizada.split("\\s+");

                for (String palavra : palavras) {

                    palavra = palavra.toUpperCase().replaceAll("[^a-zA-Z-]", "");

                    if (!palavra.isEmpty()) {

                        if (!th.existeNaTabela(palavra)) {
                            th.addNaTabela(new Palavra(palavra, numLinha));
                        } else {

                            int posicao = th.getTabela(th.hash(palavra)).getPos(palavra);
                            Object elemento = th.getTabela(th.hash(palavra)).getElemento(posicao);
                            ((Palavra) elemento).setOcorrencia(numLinha);
                        }
                    }
                }
                linha = br.readLine();
                numLinha++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(th);


        //TRABALHANDO A PARTIR DAQUI

        String enderecoArquivoPC = "C:\\Users\\Renato\\Desktop\\atividade-final-estrutura-de-dados\\pc.txt";

        TabelaHash thPalavrasChave = new TabelaHash(26);

        try (FileReader fr = new FileReader(enderecoArquivoPC);
             BufferedReader br = new BufferedReader(fr)) {

            String linha = br.readLine();

            while (linha != null) {

                String linhaNormalizada = Normalizer.normalize(linha, Normalizer.Form.NFD);
                linhaNormalizada = linhaNormalizada.replaceAll("\\p{M}", "");
                String[] palavras = linhaNormalizada.split("\\s+");

                for (String palavra : palavras) {
                    palavra = palavra.toUpperCase().replaceAll("[^a-zA-Z-]", "");

                    if (!palavra.isEmpty() && th.existeNaTabela(palavra)) {

                        if (!thPalavrasChave.existeNaTabela(palavra)) {
                            thPalavrasChave.addNaTabela(palavra);
                        }
                    }
                }

                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        String [] palavrasChave = thPalavrasChave.converteParaListaEncadeada();
        System.out.println(palavrasChave[0]);

        //System.out.println(Arrays.toString(thPalavrasChave.converteParaListaEncadeada()));
    }



}