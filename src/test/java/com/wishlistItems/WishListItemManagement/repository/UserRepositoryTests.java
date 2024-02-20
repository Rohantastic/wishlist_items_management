package com.wishlistItems.WishListItemManagement.repository;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindByEmail() {
        // Mock data
        User user = new User();
        user.setUserId("3234234234");
        user.setName("RohanUser");
        user.setEmail("rohan@gmail.com");
        user.setPassword("123123");

        // Mock repository behavior
        when(userRepository.findByEmail("rohan@gmail.com")).thenReturn(Optional.of(user));

        // Call the service method that uses the repository
        Optional<User> result = Optional.ofNullable(userService.getUserByEmail("rohan@gmail.com"));

        // Verify the result
        assertEquals(Optional.of(user), result);

        // Verify that the findByEmail method was called with the expected parameter
        verify(userRepository, times(1)).findByEmail("rohan@gmail.com");
    }
}

