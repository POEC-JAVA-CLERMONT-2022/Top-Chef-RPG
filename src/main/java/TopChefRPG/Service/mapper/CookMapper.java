package TopChefRPG.Service.mapper;

import TopChefRPG.Service.DTO.CookDTO;
import TopChefRPG.model.Cook;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CookMapper {

    CookDTO cookToCookDto(Cook cook);
}

