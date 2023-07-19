package br.com.banco.dtos;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idConta;

    private String nomeResponsavel;

    private Transferencia transferencia;

    public ContaDTO() {
    }

    public ContaDTO(Long idConta, String nomeResponsavel, Transferencia transferencia) {
        this.idConta = idConta;
        this.nomeResponsavel = nomeResponsavel;
        this.transferencia = transferencia;
    }

    public ContaDTO(Conta conta){
        this.idConta = conta.getIdConta();
        this.nomeResponsavel = conta.getNomeResponsavel();
        this.transferencia = conta.getTransferencia();
    }
}
