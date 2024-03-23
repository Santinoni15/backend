
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class JogadorGerador {
    public static void main(String[] args) throws Exception {
        String textoNomes = retornaTextoDoServidor("https://venson.net.br/resources/data/nomes.txt");
        String nome = retornaElementoAleatorio(textoNomes);

        String textoSobrenomes = retornaTextoDoServidor("https://venson.net.br/resources/data/sobrenomes.txt");
        String sobrenome = retornaElementoAleatorio(textoSobrenomes);

        String textoPosicoes = retornaTextoDoServidor("https://venson.net.br/resources/data/posicoes.txt");
        String posicao = retornaElementoAleatorio(textoPosicoes);

        String textoClubes = retornaTextoDoServidor("https://venson.net.br/resources/data/clubes.txt");
        String clubes = retornaElementoAleatorio(textoClubes);

        short idade = geraNumeroAleatorio(17,41);

        System.out.print(
                nome
                + " "
                + sobrenome
                + " é um futebolista brasileiro (a) de "
                + idade
                + posicao
                + " atualmente defende o "
                + clubes
                + "."
        );


    }

    public static String retornaTextoDoServidor(String url) throws Exception {
        // Cria um cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();
        // Cria uma requisicao HTTP
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        // Executa a requisicao e recebe uma resposta
        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        // Cria uma variavel com a lista em texto
        String texto = resposta.body();
        return texto;
    }

    public static String retornaElementoAleatorio(String texto) {
        // Divide a variavel em varias strings (uma pra cada nome)
        String[] listaDeNomes = texto.split("\n");
        // Cria um numero aleatorio de acordo com o vetor
        int indiceAleatorio = (int) Math.floor(Math.random() * listaDeNomes.length);
        // Retorna uma posicao aleatoria da lista
        return listaDeNomes[indiceAleatorio];
    }

    public static short geraNumeroAleatorio(int menor, int maior) {
        short numeroAleatorio = (short) Math.floor((Math.random()) * (maior - menor) + 17);
        return numeroAleatorio;
    }



}