package com.wishlistItems.WishListItemManagement.service;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomUserDetailService.class})
@ExtendWith(SpringExtension.class)
class CustomUserDetailServiceTests {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User("42", "Name", "sam@gmail.com", "password");
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.of(user));
        assertSame(user, customUserDetailService.loadUserByUsername("samriddhi"));
        verify(userRepository).findByEmail((String) any());
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> customUserDetailService.loadUserByUsername("samriddhi"));
        verify(userRepository).findByEmail((String) any());
    }

    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(userRepository.findByEmail((String) any())).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> customUserDetailService.loadUserByUsername("samriddhi"));
        verify(userRepository).findByEmail((String) any());
    }
}
