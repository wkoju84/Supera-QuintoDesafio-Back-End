package br.com.banco.dtos;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class TransferenciaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date data_transferencia;

    private double valor;

    private String tipo;

    private String nome_operador_transacao;

    private Conta conta;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(Long id, Date data_transferencia, double valor, String tipo, String nome_operador_transacao, Conta conta) {
        this.id = id;
        this.data_transferencia = data_transferencia;
        this.valor = valor;
        this.tipo = tipo;
        this.nome_operador_transacao = nome_operador_transacao;
        this.conta = conta;
    }

    public TransferenciaDTO (Transferencia transferencia){
        this.id = transferencia.getId();
        this.data_transferencia = transferencia.getData_transferencia();
        this.valor = transferencia.getValor();
        this.tipo = transferencia.getTipo();
        this.nome_operador_transacao = transferencia.getNome_operador_transacao();
        this.conta = transferencia.getConta();
    }
}
