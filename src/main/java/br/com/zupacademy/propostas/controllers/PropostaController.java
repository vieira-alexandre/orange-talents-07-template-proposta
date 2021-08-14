package br.com.zupacademy.propostas.controllers;

import br.com.zupacademy.propostas.controllers.dto.request.NovaPropostaRequest;
import br.com.zupacademy.propostas.model.entities.Proposta;
import br.com.zupacademy.propostas.model.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaRepository repository;

    @PostMapping
    public ResponseEntity<Void> cria(@RequestBody @Valid NovaPropostaRequest request) {
        Proposta proposta = request.toModel();
        repository.save(proposta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
