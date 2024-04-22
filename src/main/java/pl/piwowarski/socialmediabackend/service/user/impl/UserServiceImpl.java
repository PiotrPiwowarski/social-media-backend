package pl.piwowarski.socialmediabackend.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.piwowarski.socialmediabackend.dto.user.AddUserDto;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;
import pl.piwowarski.socialmediabackend.entity.User;
import pl.piwowarski.socialmediabackend.exception.NoUsersWithSuchIdException;
import pl.piwowarski.socialmediabackend.exception.UserAlreadyExistsException;
import pl.piwowarski.socialmediabackend.mapper.UserMapper;
import pl.piwowarski.socialmediabackend.repository.UserRepository;
import pl.piwowarski.socialmediabackend.service.user.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public long addUser(AddUserDto addUserDto) {
        Optional<User> optionalUser = userRepository.findUserByEmail(addUserDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new UserAlreadyExistsException("Użytkownik o podanym id już istnieje");
        }
        User user = userRepository.save(UserMapper.map(addUserDto, passwordEncoder));
        return user.getId();
    }

    @Override
    public GetUserDto getUser(long id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.map(user.orElseThrow(() -> new NoUsersWithSuchIdException("Brak użytkowników o podanym id")));
    }

    @Override
    public User getEntity(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new NoUsersWithSuchIdException("Brak użytkowników o podanym id"));
    }

    @Override
    public List<GetUserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::map)
                .toList();
    }


    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
