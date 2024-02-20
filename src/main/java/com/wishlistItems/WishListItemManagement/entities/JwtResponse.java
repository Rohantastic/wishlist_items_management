package com.wishlistItems.WishListItemManagement.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class JwtResponse {

    private String jwtToken;
    private String username;
}
