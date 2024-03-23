public class Jogador extends JogadorGerador {
    public String nome;
    public String sobrenome;
    public short idade;
    public String posicao;
    public String clubes;

    public Jogador (String nome, String sobrenome, short idade, String posicao, String clubes) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.posicao = posicao;
        this.clubes = clubes;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public short getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClubes() {
        return clubes;
    }

    public Jogador(){
        Jogador = new Jogador();
    }





}
