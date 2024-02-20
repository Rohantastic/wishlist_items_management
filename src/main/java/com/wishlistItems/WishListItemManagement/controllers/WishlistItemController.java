package com.wishlistItems.WishListItemManagement.controllers;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.entities.WishlistEntity;
import com.wishlistItems.WishListItemManagement.service.UserService;
import com.wishlistItems.WishListItemManagement.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WishlistItemController {

    @Autowired
    private UserService userService;

    @Autowired
    private WishlistService wishlistService;


    @PostMapping("/wishlist")
    public WishlistEntity createWishlist(@RequestBody WishlistEntity item) {

        // Extracting user ID from the WishlistEntity
        String userId = item.getUser().getUserId();

        // Retrieving the user from the database based on the user ID
        User user = userService.getUserById(userId);

        // Setting the retrieved user in the WishlistEntity
        item.setUser(user);

        // Saving the wishlist item

        return wishlistService.createWishlist(item);
    }

    @GetMapping("/wishlists")
    public List<WishlistEntity> getUserWishlist(Principal principal) {
        String username = principal.getName();
        return wishlistService.getWishlistItemsByUsername(username);
    }

    @DeleteMapping("/wishlists/{wishlistId}")
    public ResponseEntity<String> deleteWishlistItem(@PathVariable long wishlistId) {
        // Check if the wishlist item exists
        Optional<WishlistEntity> optionalWishlistItem = wishlistService.getWishlistItemById(wishlistId);
        if (optionalWishlistItem.isPresent()) {
            wishlistService.deleteWishlistItem(wishlistId);
            return new ResponseEntity<>("Item has been removed from wishlist", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Item not found in wishlist", HttpStatus.NOT_FOUND);
        }
    }
}
