package com.example.atv7.service;

import com.example.atv7.dto.TransacaoDTO;
import com.example.atv7.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransacaoService {

    private final Map<String, Cliente> clientes;

    public TransacaoService() {
        this.clientes = new HashMap<>();

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Cliente1");
        cliente1.setSaldo(100.0);
        cliente1.setSenha("senha1");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Cliente2");
        cliente2.setSaldo(110.0);
        cliente2.setSenha("senha2");

        clientes.put(cliente1.getNome(), cliente1);
        clientes.put(cliente2.getNome(), cliente2);

    }

    public TransacaoDTO addTransacao(TransacaoDTO transacaoDTO) {

        String pagador = transacaoDTO.getPagador();
        String recebedor = transacaoDTO.getRecebedor();
        Double quantidade = transacaoDTO.getQuantidade();

        if (!clientes.containsKey(pagador)|| !clientes.containsKey(recebedor)) {
            throw new IllegalArgumentException("Cliente nao encontrado");
        }

        Cliente clientePagador = clientes.get(pagador);
        if (clientePagador.getSaldo() < quantidade) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        Cliente clienteRecebedor = clientes.get(recebedor);
        clientePagador.setSaldo(clientePagador.getSaldo() - quantidade);
        clienteRecebedor.setSaldo(clienteRecebedor.getSaldo() + quantidade);


        return transacaoDTO;
    }
}
