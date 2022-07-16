package br.com.dev1.dsmeta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dev1.dsmeta.entity.Sale;


public interface SalesRepository extends JpaRepository<Sale, Long>{

}
