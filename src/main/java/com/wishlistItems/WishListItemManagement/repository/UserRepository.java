package com.wishlistItems.WishListItemManagement.repository;
import com.wishlistItems.WishListItemManagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User> findByEmail(String email); //This will fetch User Details by providing Email of user
}
