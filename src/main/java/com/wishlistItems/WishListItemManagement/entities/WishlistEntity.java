package com.wishlistItems.WishListItemManagement.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishlistEntity { //Wishlist table will be created into Database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String itemName;

    private String description;

    private float price;


    //forming database relation many to one i.e 1 user can have multiple wishlist items
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; //User Object from User entity

}
