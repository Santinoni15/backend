package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://venson.net.br/resources/data/nome.txt";
        //cria um cliente http
        HttpClient client = HttpClient.newHttpClient();
        //cria uma requisicao http
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create(url)).build();
        //executa requisicao e recebe resposta
        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());
        System.out.println("Hello world!");
    }
}