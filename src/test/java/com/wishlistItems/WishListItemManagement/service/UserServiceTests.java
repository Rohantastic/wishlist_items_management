package com.wishlistItems.WishListItemManagement.service;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldRetrieveListOfUsersSuccessfully() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId("userId1");
        user1.setName("Rohan");
        user1.setEmail("rohan@gmail.com");
        user1.setPassword("rohan@password");
        users.add(user1);

        User user2 = new User();
        user2.setUserId("userId2");
        user2.setName("Samriddhi S");
        user2.setEmail("sam@gmail.com");
        user2.setPassword("samriddhi@password");
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.getUsers();
        assertEquals(users, result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void shouldCreateNewUserSuccessfully() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setPassword("testPassword");

        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);
        assertEquals(user, result);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void shouldRetrieveUserByEmailSuccessfully() {
        String email = "rj@gmail.com";
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setName("rajat");
        user.setEmail(email);
        user.setPassword("password");

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        User result = userService.getUserByEmail(email);
        assertEquals(user, result);
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    public void shouldRetrieveUserByIdSuccessfully() {
        String userId = UUID.randomUUID().toString();
        User user = new User();
        user.setUserId(userId);
        user.setName("rajat");
        user.setEmail("rajat@gmail.com");
        user.setPassword("password");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User result = userService.getUserById(userId);
        assertEquals(user, result);
        verify(userRepository, times(1)).findById(userId);
    }
}
