package br.com.banco.services;

import br.com.banco.dtos.ContaDTO;
import br.com.banco.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;


    public List<ContaDTO> buscarTodas() {

        List<Conta> contaList = contaRepository.findAll();
        return contaList.stream().map(ContaDTO::new).collect(Collectors.toList());
    }

    public ContaDTO buscarPorId(Long id){
        Optional<Conta> contaOptional = contaRepository.findById(id);
        Conta entidade = contaOptional.get();
        return new ContaDTO(entidade);

    }

    @Transactional
    public ContaDTO inserirConta(ContaDTO contaDTO){
        Conta entidade = new Conta();
        entidade.setIdConta(contaDTO.getIdConta());
        entidade.setNomeResponsavel(contaDTO.getNomeResponsavel());
        entidade = contaRepository.save(entidade);
        return new ContaDTO(entidade);
    }

    @Transactional
    public ContaDTO atualizarConta(Long id, ContaDTO contaDTO){
        Conta entidade = contaRepository.getById(id);
        entidade.setIdConta(contaDTO.getIdConta());
        entidade.setNomeResponsavel(contaDTO.getNomeResponsavel());
        entidade = contaRepository.save(entidade);
        return new ContaDTO(entidade);
    }

    public void excluir(Long id){
        contaRepository.deleteById(id);
    }
}
