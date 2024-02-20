package com.wishlistItems.WishListItemManagement.repository;
import com.wishlistItems.WishListItemManagement.entities.User;
import com.wishlistItems.WishListItemManagement.entities.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistEntity,Long> {
    List<WishlistEntity> findByUser(User user); //This will fetch Item details by userID of a user
}
