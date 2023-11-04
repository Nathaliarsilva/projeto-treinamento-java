package br.com.nathalia.projetotreinamentojavaminsait.service;

import br.com.nathalia.projetotreinamentojavaminsait.model.Contato;
import br.com.nathalia.projetotreinamentojavaminsait.model.Pessoa;
import br.com.nathalia.projetotreinamentojavaminsait.repository.ContatoRepository;
import br.com.nathalia.projetotreinamentojavaminsait.repository.PessoaRepository;
import br.com.nathalia.projetotreinamentojavaminsait.service.interfaces.ContatoServiceInterface;
import br.com.nathalia.projetotreinamentojavaminsait.utils.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Validacoes validacoes = new Validacoes();

    @Override
    public Contato save(Long id, Contato contato) throws Exception {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(pessoa.isPresent()) {
            if(validacoes.tipoValido(contato.getTipo())){
                contato.setPessoa_id(id);
                return contatoRepository.save(contato);
            }else{
                throw new Exception("Somente permitido tipo de contato 0 para telefome e 1 para celular!");
            }
        }

        return null;
    }

    @Override
    public Optional<Contato> getById(Long id) {
        return contatoRepository.findById(id);
    }

    @Override
    public List<Contato> getAll(Long idPessoa) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);

        if(pessoa.isPresent()) {
            return pessoa.get().getContatos();
        }

        return null;
    }

    @Override
    public Contato update(Long id, Contato upContato) throws Exception {

        Optional<Contato> contato = contatoRepository.findById(id);

        if(contato.isPresent()) {
            if(validacoes.tipoValido(contato.get().getTipo())){
                Contato newContato = contato.get();
                newContato.setTipo(upContato.getTipo());
                newContato.setContato(upContato.getContato());
                return contatoRepository.save(newContato);
            }else{
                throw new Exception("Somente permitido tipo de contato 0 para telefome e 1 para celular!");
            }

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Contato> contato = this.getById(id);
        if(contato.isPresent()) {
            contatoRepository.deleteById(id);
        }
    }
}
