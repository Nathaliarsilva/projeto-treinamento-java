package br.com.nathalia.projetotreinamentojavaminsait.service.interfaces;

import br.com.nathalia.projetotreinamentojavaminsait.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoServiceInterface {

    Contato save(Long id, Contato contato) throws Exception;

    Optional<Contato> getById(Long id);

    List<Contato> getAll(Long idPessoa);

    Contato update(Long id, Contato upContato) throws Exception;

    void delete(Long id);
}
