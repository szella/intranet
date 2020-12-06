package br.com.szella.intranet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.szella.intranet.domain.Building;
import br.com.szella.intranet.exception.BadRequestException;
import br.com.szella.intranet.mapper.BuildingMapper;
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

	public List<Building> findByName(String name) {
		return buildingRepository.findByName(name);
	}

	public Building findById(String id) {
		return buildingRepository.findById(id).orElseThrow(() -> new BadRequestException("Building not found"));
	}

	public Building save(BuildingPostRequestBody buildingPostRequestBody) {
		return buildingRepository.save(BuildingMapper.INSTANCE.toBuilding(buildingPostRequestBody));
	}

	public void delete(String id) {
		buildingRepository.delete(findById(id));
	}

	public void replace(BuildingPutRequestBody buildingPutRequestBody) {
		Building savedBuilding = findById(buildingPutRequestBody.getId());
		Building building = BuildingMapper.INSTANCE.toBuilding(buildingPutRequestBody);
		building.setId(savedBuilding.getId());

		buildingRepository.save(building);
	}
}
