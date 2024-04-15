package pl.piwowarski.socialmediabackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.AddUserDto;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.exception.UserAlreadyExistsException;
import pl.piwowarski.socialmediabackend.mapper.UserMapper;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public long addUser(AddUserDto addUserDto) {
        Optional<User> optionalUser = userRepository.findUserByEmail(addUserDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("Użytkownik o podanym id już istnieje");
        }
        User user = userRepository.save(UserMapper.map(addUserDto));
        return user.getId();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
