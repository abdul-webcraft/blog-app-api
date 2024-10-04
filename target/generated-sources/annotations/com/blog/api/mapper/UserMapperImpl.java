package com.blog.api.mapper;

import com.blog.api.entities.User;
import com.blog.api.payloads.UserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T19:42:18+0530",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        return userDTO;
    }

    @Override
    public List<UserDTO> userListToUserDTOLIst(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( userToUserDTO( user ) );
        }

        return list;
    }
}
