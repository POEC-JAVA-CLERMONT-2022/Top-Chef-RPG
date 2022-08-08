package TopChefRPG.Service.mapper;


import TopChefRPG.Service.DTO.UserDTO;
import TopChefRPG.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO UserToUserDTO (User user);
}
