package br.com.banco.dtos;

import br.com.banco.entities.Conta;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ContaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idConta;

    private String nomeResponsavel;

    public ContaDTO() {
    }

    public ContaDTO(Long idConta, String nomeResponsavel) {
        this.idConta = idConta;
        this.nomeResponsavel = nomeResponsavel;
    }

    public ContaDTO(Conta conta){
        this.idConta = conta.getIdConta();
        this.nomeResponsavel = conta.getNomeResponsavel();
    }
}
