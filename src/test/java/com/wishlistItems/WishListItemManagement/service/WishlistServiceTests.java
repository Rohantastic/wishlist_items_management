package com.wishlistItems.WishListItemManagement.service;

import com.wishlistItems.WishListItemManagement.entities.WishlistEntity;
import com.wishlistItems.WishListItemManagement.repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceTests {

    @Mock
    private WishlistRepository wishlistRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private WishlistService wishlistService;

    @Test
    public void shouldCreateNewWishlistItemSuccessfully() {

        WishlistEntity wishlistEntity = new WishlistEntity();
        wishlistEntity.setId(1L);
        wishlistEntity.setItemName("Smartphone");
        wishlistEntity.setDescription("Latest model with amazing features");
        wishlistEntity.setPrice(899.99f);


        when(wishlistRepository.save(wishlistEntity)).thenReturn(wishlistEntity);


        WishlistEntity result = wishlistService.createWishlist(wishlistEntity);


        assertEquals(wishlistEntity, result);
        verify(wishlistRepository, times(1)).save(wishlistEntity);
    }

    @Test
    public void shouldRetrieveWishlistItemByIdSuccessfully() {

        long wishlistId = 1L;
        WishlistEntity wishlistEntity = new WishlistEntity();
        wishlistEntity.setId(wishlistId);
        wishlistEntity.setItemName("Smartwatch");
        wishlistEntity.setDescription("Water-resistant with health tracking");
        wishlistEntity.setPrice(149.99f);


        when(wishlistRepository.findById(wishlistId)).thenReturn(Optional.of(wishlistEntity));


        Optional<WishlistEntity> result = wishlistService.getWishlistItemById(wishlistId);


        assertEquals(Optional.of(wishlistEntity), result);
        verify(wishlistRepository, times(1)).findById(wishlistId);
    }

    @Test
    public void shouldDeleteWishlistItemSuccessfully() {

        long wishlistId = 1L;


        wishlistService.deleteWishlistItem(wishlistId);


        verify(wishlistRepository, times(1)).deleteById(wishlistId);
    }
}
