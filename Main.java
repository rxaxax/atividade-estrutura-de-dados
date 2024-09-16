public class Main {

    public static void main(String[] args) {

        IndiceRemissivo ir = new IndiceRemissivo();

        //entrar com caminho relativo do arquivo a ser lido
        ir.setEnderecoArquivoEntrada("\\arquivos\\texto_ex.txt");
        //entrar com caminho relativo do arquivo contendo as palavras-chave
        ir.setEnderecoArquivoPalavrasChave("\\arquivos\\pc_ex.txt");

        ir.fazerLeituraDoTexto();
        ir.fazerLeituraPalavrasChave();

        ir.gerarIndiceRemissivo();
    }
}