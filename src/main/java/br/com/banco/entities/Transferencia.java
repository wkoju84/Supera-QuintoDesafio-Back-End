package br.com.banco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transferencia")
public class Transferencia implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Temporal(TemporalType.TIMESTAMP)
   @Column
   private Date data_transferencia;

   @Column
   private double valor;

   @Column
   private String tipo;

   @Column(nullable = false)
   private String nome_operador_transacao;

   @ManyToOne
   private Conta conta;



}
