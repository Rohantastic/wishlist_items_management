package com.wishlistItems.WishListItemManagement.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishlistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String itemName;

    private String description;

    private float price;


    //forming database relation
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
