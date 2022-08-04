package TopChefRPG.Security;

import TopChefRPG.Repository.UserRepository;
import TopChefRPG.model.User;
import TopChefRPG.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    final
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("Not found : "+ username));

        return new UserDetailsImpl(user);
    }
}
