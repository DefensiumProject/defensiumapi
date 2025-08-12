package br.com.defensium.defensiumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.defensium.defensiumapi.entity.CredencialEntity;

@Repository
public interface CredencialRepository extends JpaRepository<CredencialEntity, Long> { }
