package br.com.szella.intranet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.szella.intranet.domain.Building;
import br.com.szella.intranet.requests.building.BuildingPostRequestBody;
import br.com.szella.intranet.requests.building.BuildingPutRequestBody;
import br.com.szella.intranet.service.BuildingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/buildings")
@RequiredArgsConstructor
public class BuildingController {
	private final BuildingService buildingService;

	@GetMapping
	public ResponseEntity<List<Building>> list() {
		return ResponseEntity.ok(buildingService.listAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Building> findById(@PathVariable String id) {
		return ResponseEntity.ok(buildingService.findById(id));
	}

	@GetMapping(path = "/find")
	public ResponseEntity<List<Building>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(buildingService.findByName(name));
	}

	@PostMapping
	public ResponseEntity<Building> save(@RequestBody BuildingPostRequestBody animePostRequestBody) {
		return new ResponseEntity<>(buildingService.save(animePostRequestBody), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		buildingService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody BuildingPutRequestBody animePutRequestBody) {
		buildingService.replace(animePutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
