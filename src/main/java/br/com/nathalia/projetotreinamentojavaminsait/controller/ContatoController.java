package br.com.nathalia.projetotreinamentojavaminsait.controller;

import br.com.nathalia.projetotreinamentojavaminsait.model.Contato;
import br.com.nathalia.projetotreinamentojavaminsait.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ContatoController {

    private ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/api/pessoas/{idPessoa}/contatos")
    @Operation(summary = "Retorna todos os contatos de uma pessoa pelo seu id")
    public ResponseEntity<List<Contato>> getAllContatos(@PathVariable Long idPessoa){
        List<Contato> contatos = contatoService.getAll(idPessoa);
        if(contatos == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contatos);
    }

    @GetMapping("/api/contatos/{id}")
    @Operation(summary = "Retorna um contato pelo seu id")
    public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id){
        Optional<Contato> contato = contatoService.getById(id);
        if(contato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contato);
    }

    @PostMapping("/api/pessoas/{id}/contatos")
    @Operation(summary = "Cria um novo contato para uma pessoa pelo seu id")
    public ResponseEntity<Contato> save(@PathVariable Long id, @RequestBody Contato contato) throws Exception {
        Contato newContato = contatoService.save(id, contato);
        if(newContato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newContato);
    }

    @PutMapping("/api/contatos/{id}")
    @Operation(summary = "Atualiza um contato pelo seu id")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) throws Exception {
        Contato newContato = contatoService.update(id, contato);
        if(newContato == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newContato);
    }

    @DeleteMapping("/api/contatos/{id}")
    @Operation(summary = "Exclui um contato pelo seu id")
    public ResponseEntity<?> delete(@PathVariable Long id){
        contatoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
