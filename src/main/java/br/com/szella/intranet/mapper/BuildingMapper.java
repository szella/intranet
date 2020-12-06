package br.com.szella.intranet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.szella.intranet.domain.Building;
import br.com.szella.intranet.requests.building.BuildingPostRequestBody;
import br.com.szella.intranet.requests.building.BuildingPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class BuildingMapper {
	public static final BuildingMapper INSTANCE = Mappers.getMapper(BuildingMapper.class);

	public abstract Building toBuilding(BuildingPostRequestBody BuildingPostRequestBody);

	public abstract Building toBuilding(BuildingPutRequestBody BuildingPostRequestBody);

}
