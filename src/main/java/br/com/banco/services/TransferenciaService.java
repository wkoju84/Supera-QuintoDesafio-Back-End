package br.com.banco.services;

import br.com.banco.dtos.TransferenciaDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    public List<TransferenciaDTO> buscarTodas(){
        List<Transferencia> transferenciaList = transferenciaRepository.findAll();
        return transferenciaList.stream().map(TransferenciaDTO::new).collect(Collectors.toList());
    }

    public TransferenciaDTO buscarPorId(Long id){
        Optional<Transferencia> transferenciaOptional = transferenciaRepository.findById(id);
        Transferencia entidade = transferenciaOptional.get();
        return new TransferenciaDTO(entidade);
    }


    public TransferenciaDTO inserirTransferencia(TransferenciaDTO transferenciaDTO){

        Transferencia entidade = new Transferencia();
        entidade.setId(transferenciaDTO.getId());
        entidade.setData_transferencia(transferenciaDTO.getData_transferencia());
        entidade.setValor(transferenciaDTO.getValor());
        entidade.setTipo(transferenciaDTO.getTipo());
        entidade.setNome_operador_transacao(transferenciaDTO.getNome_operador_transacao());
        entidade.setSaldoTotal(transferenciaDTO.getSaldoTotal());
        entidade.setSaldoTotalPeriodo(transferenciaDTO.getSaldoTotalPeriodo());
        entidade.setConta(transferenciaDTO.getConta());
        entidade = transferenciaRepository.save(entidade);
        return new TransferenciaDTO(entidade);
    }


    public TransferenciaDTO atualizarTransferencia(Long id, TransferenciaDTO transferenciaDTO){
        Transferencia entidade = transferenciaRepository.getById(id);
        entidade.setId(transferenciaDTO.getId());
        entidade.setData_transferencia(transferenciaDTO.getData_transferencia());
        entidade.setValor(transferenciaDTO.getValor());
        entidade.setTipo(transferenciaDTO.getTipo());
        entidade.setNome_operador_transacao(transferenciaDTO.getNome_operador_transacao());
        entidade.setSaldoTotal(transferenciaDTO.getSaldoTotal());
        entidade.setSaldoTotalPeriodo(transferenciaDTO.getSaldoTotalPeriodo());
        entidade.setConta(transferenciaDTO.getConta());
        entidade = transferenciaRepository.save(entidade);
        return new TransferenciaDTO(entidade);
    }

    public void excluir(Long id){transferenciaRepository.deleteById(id);}

//    public List<Transferencia> filtrarTransferencia(Long id,
//                                                    LocalDate dataInicio,
//                                                    LocalDate dataFinal,
//                                                    String nomeOperador){
//        Specification<TransferenciaDTO> transferenciaDTOSpecification = Specification.where(null);
//
//        if (id != null){
//            transferenciaDTOSpecification = transferenciaDTOSpecification.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.equal(root.get("transferencia").get("id"),id));
//        }
//
//        if (dataInicio != null){
//            transferenciaDTOSpecification = transferenciaDTOSpecification.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.greaterThanOrEqualTo(root.get("data_transferencia"), dataInicio));
//        }
//
//        if (dataFinal != null){
//            transferenciaDTOSpecification = transferenciaDTOSpecification.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.lessThanOrEqualTo(root.get("data_transferencia"), dataFinal));
//        }
//
//        if (nomeOperador != null) {
//            transferenciaDTOSpecification = transferenciaDTOSpecification.and((root, query, criteriaBuilder) ->
//                    criteriaBuilder.equal(root.get("nome_operador_transacao"), nomeOperador));
//        }
//        return transferenciaRepository.findAll();
//    }
}
