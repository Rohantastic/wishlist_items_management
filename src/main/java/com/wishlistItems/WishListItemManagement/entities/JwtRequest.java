package com.wishlistItems.WishListItemManagement.entities;

import lombok.Data;

@Data
public class JwtRequest {

    private String email;

    private String password;
}

//JwtRequest class to send request to our backend for login with email and password