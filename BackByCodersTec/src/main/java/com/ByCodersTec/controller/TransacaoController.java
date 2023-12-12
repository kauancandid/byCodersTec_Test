package com.ByCodersTec.controller;

import com.ByCodersTec.model.TransacaoModel;
import com.ByCodersTec.service.Impl.TransacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoServiceImpl transacaoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadArquivo(@RequestParam("file") MultipartFile file) {
        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("O arquivo está vazio.");
            }
            byte[] bytes = file.getBytes();
            String arquivo = new String(bytes);
            List<String> linhasDoArquivo = List.of(arquivo.split("\n"));
            transacaoService.salvarTransacoes(linhasDoArquivo);
            return ResponseEntity.ok("Arquivo enviado e processado com sucesso.");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<TransacaoModel>> listarTransacoes() {
        List<TransacaoModel> transacoes = transacaoService.listarTransacoes();
        return ResponseEntity.ok(transacoes);
    }

}