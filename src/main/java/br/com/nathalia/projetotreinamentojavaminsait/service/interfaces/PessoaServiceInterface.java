package br.com.nathalia.projetotreinamentojavaminsait.service.interfaces;

import br.com.nathalia.projetotreinamentojavaminsait.dto.MalaDireta;
import br.com.nathalia.projetotreinamentojavaminsait.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaServiceInterface {

    Pessoa save(Pessoa pessoa) throws Exception;

    Optional<Pessoa> getById(Long id);

    List<Pessoa> getAll();

    Pessoa update(Long id, Pessoa pessoa) throws Exception;

    void delete(Long id);

    MalaDireta getMalaDireta(Long id);
}
