package model;

/**
 *
 * @author uniflbaptistella
 */
public class Investidor extends Pessoa{

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        Carteira carteira = new Carteira();
    }
}
