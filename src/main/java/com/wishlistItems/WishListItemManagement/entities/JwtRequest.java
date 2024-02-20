package com.wishlistItems.WishListItemManagement.entities;

import lombok.Data;

@Data

public class JwtRequest {

    private String email;

    private String password;
}
