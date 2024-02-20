package com.wishlistItems.WishListItemManagement.repository;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.entities.WishlistEntity;
import com.wishlistItems.WishListItemManagement.service.WishlistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishlistRepositoryTests {

    @Mock
    private WishlistRepository wishlistRepository;

    @InjectMocks
    private WishlistService wishlistService;

    @Test
    public void testSaveWishlistItem() {
        // Mock data
        User user = new User();
        user.setUserId("123123");

        WishlistEntity wishlistItem = new WishlistEntity();
        wishlistItem.setId(1L);
        wishlistItem.setItemName("Motorola X");
        wishlistItem.setUser(user);

        // Mock repository behavior
        when(wishlistRepository.save(wishlistItem)).thenReturn(wishlistItem);

        // Call the service method that uses the repository
        WishlistEntity result = wishlistService.createWishlist(wishlistItem);

        // Verify the result
        assertEquals(wishlistItem, result);

        // Verify that the save method was called with the expected parameter
        verify(wishlistRepository, times(1)).save(wishlistItem);
    }

    @Test
    public void testFindById() {
        // Mock data
        WishlistEntity wishlistItem = new WishlistEntity();
        wishlistItem.setId(1L);
        wishlistItem.setItemName("Panasonic TVs");

        // Mock repository behavior
        when(wishlistRepository.findById(1L)).thenReturn(Optional.of(wishlistItem));

        // Call the service method that uses the repository
        Optional<WishlistEntity> result = wishlistService.getWishlistItemById(1L);

        // Verify the result
        assertEquals(Optional.of(wishlistItem), result);

        // Verify that the findById method was called with the expected parameter
        verify(wishlistRepository, times(1)).findById(1L);
    }
}
