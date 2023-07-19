package br.com.banco.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

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

   @Column
   private LocalDate data_transferencia;

   @Column
   private BigDecimal valor;

   @Column
   private String tipo;

   @Column(nullable = false)
   private String nome_operador_transacao;

   private BigDecimal saldoTotal = new BigDecimal(2);

   private BigDecimal saldoTotalPeriodo = new BigDecimal(3);

   @ManyToOne
   private Conta conta;



}
