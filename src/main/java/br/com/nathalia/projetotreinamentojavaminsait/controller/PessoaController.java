package br.com.nathalia.projetotreinamentojavaminsait.controller;

import br.com.nathalia.projetotreinamentojavaminsait.dto.MalaDireta;
import br.com.nathalia.projetotreinamentojavaminsait.model.Pessoa;
import br.com.nathalia.projetotreinamentojavaminsait.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    @Operation(summary = "Retorna todas as pessoas cadastradas")
    public ResponseEntity<List<Pessoa>> getAllPessoas(){
        List<Pessoa> pessoas = pessoaService.getAll();
        if(pessoas == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna uma pessoa cadastrada pelo seu id")
    public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaService.getById(id);
        if(pessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    @Operation(summary = "Cadastra uma pessoa nova")
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) throws Exception {
        Pessoa newPessoa = pessoaService.save(pessoa);
        if(newPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma pessoa pelo seu id")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) throws Exception {
        Pessoa newPessoa = pessoaService.update(id, pessoa);
        if(newPessoa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(newPessoa);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma pessoa pelo seu id e seus contatos vinculados")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/maladireta/{id}")
    @Operation(summary = "Retorna uma pessoa por Id para mala direta")
    public ResponseEntity<MalaDireta> getMalaDireta(@PathVariable Long id){
        MalaDireta malaDireta = pessoaService.getMalaDireta(id);
        if(malaDireta == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(malaDireta);
    }
}
