package br.com.banco.controllers;

import br.com.banco.dtos.ContaDTO;
import br.com.banco.entities.Conta;
import br.com.banco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaDTO>> buscarTodasAsContas(){
        List<ContaDTO> contaList = contaService.buscarTodas();
        return ResponseEntity.ok().body(contaList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContaDTO> buscarContaPorId(@PathVariable Long id){
        ContaDTO contaDTO = contaService.buscarPorId(id);
        return ResponseEntity.ok().body(contaDTO);
    }

    @PostMapping
    public ResponseEntity<ContaDTO> inserirConta(@RequestBody ContaDTO contaDTO){
        contaDTO = contaService.inserirConta(contaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(contaDTO.getIdConta()).toUri();
        return ResponseEntity.created(uri).body(contaDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContaDTO> atualizarConta(@PathVariable Long id,
                                                   @RequestBody ContaDTO contaDTO){
        contaDTO = contaService.atualizarConta(id, contaDTO);
        return ResponseEntity.ok().body(contaDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirConta(@PathVariable Long id){
        contaService.excluir(id);
        return ResponseEntity.noContent().build();
    }


}
