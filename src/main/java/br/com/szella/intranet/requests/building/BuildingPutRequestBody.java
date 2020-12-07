package br.com.szella.intranet.requests.building;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BuildingPutRequestBody {
	private String id;

	@NotBlank
	@Size(min = 1, max = 255)
	private String name;
}
