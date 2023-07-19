package br.com.banco.controllers;

import br.com.banco.dtos.TransferenciaDTO;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<TransferenciaDTO>> buscarTodasAsTransferencias(){
        List<TransferenciaDTO> transferenciaDTOList = transferenciaService.buscarTodas();
        return ResponseEntity.ok().body(transferenciaDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TransferenciaDTO> buscarTransferenciaPorId(@PathVariable Long id){
        TransferenciaDTO transferenciaDTO = transferenciaService.buscarPorId(id);
        return ResponseEntity.ok().body(transferenciaDTO);
    }

    @PostMapping
    public ResponseEntity<TransferenciaDTO> inserirTransferencia(@RequestBody TransferenciaDTO transferenciaDTO){
        transferenciaDTO = transferenciaService.inserirTransferencia(transferenciaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transferenciaDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(transferenciaDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransferenciaDTO> atualizarTransferencia(@PathVariable Long id,
                                                                   @RequestBody TransferenciaDTO transferenciaDTO){
        transferenciaDTO = transferenciaService.atualizarTransferencia(id, transferenciaDTO);
        return ResponseEntity.ok().body(transferenciaDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirTransferencia(@PathVariable Long id){
        transferenciaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    
}

