import java.io.*;
import java.text.Normalizer;
import java.util.Arrays;

public class IndiceRemissivo {

    //ATRIBUTOS
    private String enderecoArquivoEntrada;
    private TabelaHash textoEntrada;
    private String enderecoArquivoPalavrasChave;
    private String[] palavrasChave;

    //GETTERS E SETTERS
    public TabelaHash getTextoEntrada() {
        return textoEntrada;
    }

    public void setEnderecoArquivoEntrada(String enderecoArquivoEntrada) {
        this.enderecoArquivoEntrada = System.getProperty("user.dir") + enderecoArquivoEntrada;
    }

    public void setEnderecoArquivoPalavrasChave(String enderecoArquivoPalavrasChave) {
        this.enderecoArquivoPalavrasChave = System.getProperty("user.dir") + enderecoArquivoPalavrasChave;
    }

    public String getPalavrasChave() {
        String palavrasChaveStr = Arrays.toString(palavrasChave);
        return palavrasChaveStr;
    }

    //MÉTODOS
    public void fazerLeituraDoTexto() {

        TabelaHash th = new TabelaHash(26);

        try (FileReader fr = new FileReader(enderecoArquivoEntrada);
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
            System.out.println("Erro: " + e.getMessage());
            System.exit(0);
        }
        textoEntrada = th;
        System.out.println("Arquivo de entrada lido com sucesso!");
    }

    public void fazerLeituraPalavrasChave() {

        TabelaHash thPalavrasChave = new TabelaHash(26);

        try (FileReader fr = new FileReader(enderecoArquivoPalavrasChave);
             BufferedReader br = new BufferedReader(fr)) {

            String linha = br.readLine();

            while (linha != null) {

                String linhaNormalizada = Normalizer.normalize(linha, Normalizer.Form.NFD);
                linhaNormalizada = linhaNormalizada.replaceAll("\\p{M}", "");
                String[] palavras = linhaNormalizada.split("\\s+");

                for (String palavra : palavras) {

                    palavra = palavra.toUpperCase().replaceAll("[^a-zA-Z-]", "");

                    if (!palavra.isEmpty() && textoEntrada.existeNaTabela(palavra)) {

                        if (!thPalavrasChave.existeNaTabela(palavra)) {
                            thPalavrasChave.addNaTabela(palavra);
                        }
                    }
                }
                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
            System.exit(0);
        }
        palavrasChave = thPalavrasChave.converterParaArray();
        System.out.println("Palavras-chave lidas com sucesso!");
    }

    public void gerarIndiceRemissivo() {

        System.out.println("");
        System.out.println("### ÍNDICE REMISSIVO ###");
        System.out.println("");
        for (String palavraChave : palavrasChave) {

            Object palavra = this.textoEntrada.getElementoNaTabela(palavraChave);
            System.out.println(palavra);
        }
        gerarArquivoIndiceRemissivo();
    }

    public void gerarArquivoIndiceRemissivo() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "\\arquivos\\indice_remissivo.txt"))) {

            bw.write("### ÍNDICE REMISSIVO ###");
            bw.newLine();
            bw.write("\n");
            for (String palavraChave : palavrasChave) {

                Object palavra = this.textoEntrada.getElementoNaTabela(palavraChave);
                bw.write(palavra.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
        System.out.println("\nArquivo escrito em: \n" + System.getProperty("user.dir") + "\\arquivos\\indice_remissivo.txt");
    }
}