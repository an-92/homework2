package test.login.login2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import test.login.login2.domain.Role;
import test.login.login2.domain.entity.UserEntity;
import test.login.login2.domain.repository.UserRepository;
import test.login.login2.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public Long joinUser(UserDto userDto) {
        //비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(userDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityWrapper = userRepository.findByEmail(userEmail);
        UserEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }

        return new User(userEntity.getEmail(),userEntity.getPassword(), authorities);
    }
}
