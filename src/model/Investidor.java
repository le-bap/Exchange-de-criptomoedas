package model;

/**
 *
 * @author uniflbaptistella
 */
public class Investidor extends Pessoa{
    private Carteira carteira;
    
    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        carteira = new Carteira();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Carteira getCarteira(){
        return carteira;
    }
}
