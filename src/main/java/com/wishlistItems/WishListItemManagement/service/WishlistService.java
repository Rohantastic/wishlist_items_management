package com.wishlistItems.WishListItemManagement.service;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.entities.WishlistEntity;
import com.wishlistItems.WishListItemManagement.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    WishlistRepository wishlistRepo;

    @Autowired
    UserService userService;

    public WishlistEntity createWishlist(WishlistEntity item){
//
//        String userId = item.getUser().getUserId();
//
//        User user = userService.getUserById(userId);
//
//        item.setUser(user);

        return wishlistRepo.save(item);
    }

    public Optional<WishlistEntity> getWishlistItemById(long wishlistId) {
        return wishlistRepo.findById(wishlistId);
    }

    public void deleteWishlistItem(long wishlistId) {
        wishlistRepo.deleteById(wishlistId);
    }

    public List<WishlistEntity> getWishlistItemsByUsername(String username) {
        // Fetch user by username
        User user = userService.getUserByEmail(username);
        System.out.println(">>>>>>>>>>>checking for user by getUserByEmail in getWishlistItemsByUsername()");
        System.out.println(user);
        // Fetch wishlist items for the user

        System.out.println(">>>>>>>>>>>>>in getWishlistItemsByusername(), checking for wishlistRepo.findByUser");
        System.out.println(wishlistRepo.findByUser(user));

        System.out.println(">>>....>>>>>>>>>>>>>>checking all wishlistrepo");

        System.out.println(wishlistRepo.findAll());
        return wishlistRepo.findByUser(user);
    }
}
