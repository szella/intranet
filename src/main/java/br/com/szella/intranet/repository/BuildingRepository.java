package br.com.szella.intranet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.szella.intranet.domain.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, String> {

	List<Building> findByName(String name);
}
