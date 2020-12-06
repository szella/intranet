package br.com.szella.intranet.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.szella.intranet.domain.Building;
import br.com.szella.intranet.repository.BuildingRepository;
import br.com.szella.intranet.requests.building.BuildingPostRequestBody;
import br.com.szella.intranet.requests.building.BuildingPutRequestBody;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildingService {
	private final BuildingRepository buildingRepository;

	public List<Building> listAll() {
		return buildingRepository.findAll();
	}

	public Building findById(String id) {
		return buildingRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Building not found"));
	}

	public Building save(BuildingPostRequestBody buildingPostRequestBody) {
		return buildingRepository.save(Building.builder().name(buildingPostRequestBody.getName()).build());
	}

	public void delete(String id) {
		buildingRepository.delete(findById(id));
	}

	public void replace(BuildingPutRequestBody buildingPutRequestBody) {
		Building savedBuilding = findById(buildingPutRequestBody.getId());
		Building building = Building.builder().id(savedBuilding.getId()).name(buildingPutRequestBody.getName()).build();

		buildingRepository.save(building);
	}
}
