public class ObjetoTeste {

    private int num;
    private String nome;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ObjetoTeste (int num, String nome) {
        this.num = num;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ObjetoTeste{" +
                "num=" + num +
                ", nome='" + nome + '\'' +
                '}';
    }
}
