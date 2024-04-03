import org.example.Jogador;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class JogadorGerador {
    private static String textoNomes;
    private static String textoSobrenomes;
    private static String textoPosicoes;
    private static String textoClubes;

    public static void requisitarDados() throws Exception {
        textoNomes = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
        textoSobrenomes = retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
        textoPosicoes = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
        textoClubes = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
    }

    private static String retornaTextoDoServidor(String url) throws Exception {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        return resposta.body();
    }

    public static Jogador criarJogadorAleatorio() {
        Random random = new Random();
        String nome = retornaElementoAleatorio(textoNomes);
        String sobrenome = retornaElementoAleatorio(textoSobrenomes);
        String posicao = retornaElementoAleatorio(textoPosicoes);
        String clube = retornaElementoAleatorio(textoClubes);
        short idade = geraNumeroAleatorio(17, 41);
        return new Jogador(nome, sobrenome, posicao, clube, idade);
    }

    private static String retornaElementoAleatorio(String texto) {
        String[] elementos = texto.split("\n");
        int indiceAleatorio = (int) Math.floor(Math.random() * elementos.length);
        return elementos[indiceAleatorio];
    }

    private static short geraNumeroAleatorio(int menor, int maior) {
        return (short) (Math.floor(Math.random() * (maior - menor)) + menor);
    }
}
