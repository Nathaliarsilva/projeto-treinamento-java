package br.com.nathalia.projetotreinamentojavaminsait.service;

import br.com.nathalia.projetotreinamentojavaminsait.dto.MalaDireta;
import br.com.nathalia.projetotreinamentojavaminsait.model.Contato;
import br.com.nathalia.projetotreinamentojavaminsait.model.Pessoa;
import br.com.nathalia.projetotreinamentojavaminsait.repository.PessoaRepository;
import br.com.nathalia.projetotreinamentojavaminsait.service.interfaces.PessoaServiceInterface;
import br.com.nathalia.projetotreinamentojavaminsait.utils.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceInterface {

    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public Validacoes validacoes = new Validacoes();

    @Override
    public Pessoa save(Pessoa pessoa) throws Exception {
        if(validacoes.nomeValido(pessoa.getNome()) && validacoes.tamanhoUf(pessoa.getUf())){
            pessoa.setUf(pessoa.getUf().toUpperCase());
            return pessoaRepository.save(pessoa);
        }else{
            throw new Exception("Nome inválido! Não utilize números nem caracteres especiais. UF apenas com tamanho 2");
        }
    }

    @Override
    public Optional<Pessoa> getById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa update(Long id, Pessoa upPessoa) throws Exception {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        if(pessoa.isPresent()) {
            if(validacoes.nomeValido(upPessoa.getNome()) && validacoes.tamanhoUf(upPessoa.getUf())){
                Pessoa newPessoa = pessoa.get();
                newPessoa.setNome(upPessoa.getNome());
                newPessoa.setEndereco(upPessoa.getEndereco());
                newPessoa.setCep(upPessoa.getCep());
                newPessoa.setCidade(upPessoa.getCidade());
                newPessoa.setUf(upPessoa.getUf().toUpperCase());
                return pessoaRepository.save(newPessoa);
            }else{
                throw new Exception("Nome inválido! Não utilize números nem caracteres especiais. UF apenas com tamanho 2");
            }

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Pessoa> pessoa = this.getById(id);
        if(pessoa.isPresent()) {
            pessoaRepository.deleteById(id);
        }
    }

    @Override
    public MalaDireta getMalaDireta(Long id) {
        Optional<Pessoa> pessoa = this.getById(id);
        MalaDireta malaDireta = null;

        if (pessoa.isPresent()) {

            String fullEndereco = pessoa.get().getEndereco()
                    + " - CEP: " + pessoa.get().getCep()
                    + " - " + pessoa.get().getCidade()
                    + "/" + pessoa.get().getUf();

            malaDireta = new MalaDireta(pessoa.get().getId(), pessoa.get().getNome(), fullEndereco);
        }

        return malaDireta;
    }

}
