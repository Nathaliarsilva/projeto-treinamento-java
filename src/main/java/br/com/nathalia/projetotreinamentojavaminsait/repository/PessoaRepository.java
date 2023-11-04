package br.com.nathalia.projetotreinamentojavaminsait.repository;

import br.com.nathalia.projetotreinamentojavaminsait.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}
