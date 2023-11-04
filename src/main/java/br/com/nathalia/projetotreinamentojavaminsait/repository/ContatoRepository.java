package br.com.nathalia.projetotreinamentojavaminsait.repository;

import br.com.nathalia.projetotreinamentojavaminsait.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {}