package app.security;

import app.model.Users;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String Email)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Users user = userRepository.findByEmailAndDelFlag(Email,false)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + Email)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        Optional<Users> user = userRepository.findById(id);
        Users users = user.get();
        return UserPrincipal.create(users);
    }
}