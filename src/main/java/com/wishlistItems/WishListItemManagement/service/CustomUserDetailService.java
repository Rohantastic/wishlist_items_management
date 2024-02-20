package com.wishlistItems.WishListItemManagement.service;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(">>>>>>>>>>>>>>>loadByUserName in CustomUserDetailsService");
        User user = userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Foundddd") );
        return user;
    }
}
