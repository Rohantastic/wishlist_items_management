package com.wishlistItems.WishListItemManagement.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserTests {

    @Test
    void testConstructor() {
        User actualUser = new User("123123", "Samriddhi", "sam@gmail.com", "password");

        assertNull(actualUser.getAuthorities());
        assertEquals("sam@gmail.com", actualUser.getUsername());
        assertTrue(actualUser.isAccountNonExpired());
        assertTrue(actualUser.isAccountNonLocked());
        assertTrue(actualUser.isCredentialsNonExpired());
        assertTrue(actualUser.isEnabled());
    }
}
