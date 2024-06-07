package com.example.atv7.controller;

import com.example.atv7.dto.TransacaoDTO;
import com.example.atv7.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacao")
@Validated
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> addTransacao(@Validated @RequestBody TransacaoDTO transacaoDTO) {
        TransacaoDTO result = transacaoService.addTransacao(transacaoDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
