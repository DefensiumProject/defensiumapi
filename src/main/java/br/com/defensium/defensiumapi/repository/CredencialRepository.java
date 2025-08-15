package br.com.defensium.defensiumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.defensium.defensiumapi.entity.CredencialEntity;
import jakarta.transaction.Transactional;

@Repository
public interface CredencialRepository extends JpaRepository<CredencialEntity, Long> {

	@Transactional
	@Modifying
	@Query(value = "update tb_credencial set active = false where codigo = :credencialCodigo", nativeQuery = true)
	public int inativarCredencial(Long credencialCodigo);

}
