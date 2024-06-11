package com.example.atv7.controller;


import com.example.atv7.dto.ClienteDTO;
import com.example.atv7.model.Cliente;
import com.example.atv7.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{nome}")
    public ResponseEntity<ClienteDTO> getClienteByName(@PathVariable String nome) {
        Cliente cliente = clienteService.getClientebyName(nome);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setSaldo(cliente.getSaldo());

        return ResponseEntity.ok(clienteDTO);
    }
}
