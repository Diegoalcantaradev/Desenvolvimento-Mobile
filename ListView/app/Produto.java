
public class Produto {
    private String nome;
    private float valor;
    private int quantidade;
    public Produto(String nome, float valor, int quantidade){
        this.nome=nome;
        this.valor=valor;
        this.quantidade=quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
