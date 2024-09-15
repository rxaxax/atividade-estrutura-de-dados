import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;



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

                String linhaNormalizada = Normalizer.normalize(linha, Normalizer.Form.NFD);
                linhaNormalizada = linhaNormalizada.replaceAll("\\p{M}", "");

                String[] palavras = linhaNormalizada.split("\\s+");
                //System.out.println(linha);
                for (String palavra : palavras) {

                    palavra = palavra.toUpperCase().replaceAll("[^a-zA-Z-]", "");

                    if (!palavra.isEmpty()) {
                        if (!th.existeNaTabela(palavra)) {
                            th.addNaTabela(new Palavra(palavra, numLinha));
                        }
                        if (th.existeNaTabela(palavra)) {
                            int posicao = th.tabela[th.hash(palavra)].getPos(palavra);
                            Object elemento = th.tabela[th.hash(palavra)].getElemento(posicao);
                            ((Palavra) elemento).setOcorrencia(numLinha);
                        }

                        //System.out.println(palavra + " -> " + numLinha);

                    }




                }

                linha = br.readLine();
                numLinha++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(th);

    }
}
