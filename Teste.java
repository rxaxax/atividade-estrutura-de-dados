import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Teste {
    public static void main(String[] args) {
        String enderecoArquivo = "C:\\Users\\Renato\\Desktop\\atividade-final-estrutura-de-dados\\in.txt";

        FileReader fr = null;
        BufferedReader br = null;
        TabelaHash th = new TabelaHash(26);
        try {

            fr = new FileReader(enderecoArquivo);
            br = new BufferedReader(fr);

            String linha = br.readLine();
            int numLinha = 1;


            while (linha != null) {

                String[] palavras = linha.split(" ");
                //System.out.println(linha);
                for (String palavra : palavras) {

                    palavra = palavra.toUpperCase().replaceAll("[^a-zA-Z-]", "");


                    if (!th.existeNaTabela(palavra)) {
                        th.addNaTabela(palavra);
                    }



                    System.out.println(palavra + " -> " + numLinha);

                }

                linha = br.readLine();
                numLinha++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(th.getTabela());
        System.out.println(th.tabela[0].getInicio());
        System.out.println(th.tabela[0].getPos("and"));
        //System.out.println(th.tabela[0].getInicio().getValor());

    }
}
