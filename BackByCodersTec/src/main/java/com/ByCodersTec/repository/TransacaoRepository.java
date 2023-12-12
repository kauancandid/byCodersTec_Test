package com.ByCodersTec.repository;

import com.ByCodersTec.model.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<TransacaoModel, UUID> {
    TransacaoModel findByCpf(String cpf);

}
