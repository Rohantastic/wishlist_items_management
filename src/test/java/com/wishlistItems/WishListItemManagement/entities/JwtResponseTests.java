package com.wishlistItems.WishListItemManagement.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtResponseTests {

    @Test
    void modifiedTestCanEqual() {
        assertFalse((new JwtResponse("123123rr4r", "Shyam")).canEqual("Other"));
    }

    @Test
    void modifiedTestCanEqual2() {
        JwtResponse jwtResponse = new JwtResponse("123123rr4r", "Shyam");
        assertTrue(jwtResponse.canEqual(new JwtResponse("123123rr4r", "Shyam")));
    }

    @Test
    void modifiedTestConstructor() {
        JwtResponse actualJwtResponse = new JwtResponse("123123rr4r", "Shyam");
        actualJwtResponse.setJwtToken("123123rr4r");
        actualJwtResponse.setUsername("Shyam");
        String actualToStringResult = actualJwtResponse.toString();
        assertEquals("123123rr4r", actualJwtResponse.getJwtToken());
        assertEquals("Shyam", actualJwtResponse.getUsername());
        assertEquals("JwtResponse(jwtToken=123123rr4r, username=Shyam)", actualToStringResult);
    }

    @Test
    void modifiedTestEquals() {
        assertNotEquals(new JwtResponse("123123rr4r", "Shyam"), null);
        assertNotEquals(new JwtResponse("123123rr4r", "Shyam"), "Different type to JwtResponse");
    }

    @Test
    void modifiedTestEquals2() {
        JwtResponse jwtResponse = new JwtResponse("123123rr4r", "Shyam");
        assertEquals(jwtResponse, jwtResponse);
        int expectedHashCodeResult = jwtResponse.hashCode();
        assertEquals(expectedHashCodeResult, jwtResponse.hashCode());
    }

    @Test
    void modifiedTestEquals3() {
        JwtResponse jwtResponse = new JwtResponse("123123rr4r", "Shyam");
        JwtResponse jwtResponse1 = new JwtResponse("123123rr4r", "Shyam");

        assertEquals(jwtResponse, jwtResponse1);
        int expectedHashCodeResult = jwtResponse.hashCode();
        assertEquals(expectedHashCodeResult, jwtResponse1.hashCode());
    }

    @Test
    void modifiedTestEquals4() {
        JwtResponse jwtResponse = new JwtResponse("Shyam", "Shyam");
        assertNotEquals(jwtResponse, new JwtResponse("123123rr4r", "Shyam"));
    }

    @Test
    void modifiedTestEquals5() {
        JwtResponse jwtResponse = new JwtResponse(null, "Shyam");
        assertNotEquals(jwtResponse, new JwtResponse("123123rr4r", "Shyam"));
    }

    @Test
    void modifiedTestEquals6() {
        JwtResponse jwtResponse = new JwtResponse("123123rr4r", "123123rr4r");
        assertNotEquals(jwtResponse, new JwtResponse("123123rr4r", "Shyam"));
    }

    @Test
    void modifiedTestEquals7() {
        JwtResponse jwtResponse = new JwtResponse("123123rr4r", null);
        assertNotEquals(jwtResponse, new JwtResponse("123123rr4r", "Shyam"));
    }

    @Test
    void modifiedTestEquals8() {
        JwtResponse jwtResponse = new JwtResponse(null, "Shyam");
        JwtResponse jwtResponse1 = new JwtResponse(null, "Shyam");

        assertEquals(jwtResponse, jwtResponse1);
        int expectedHashCodeResult = jwtResponse.hashCode();
        assertEquals(expectedHashCodeResult, jwtResponse1.hashCode());
    }

    @Test
    void modifiedTestEquals9() {
        JwtResponse jwtResponse = new JwtResponse("123123rr4r", null);
        JwtResponse jwtResponse1 = new JwtResponse("123123rr4r", null);

        assertEquals(jwtResponse, jwtResponse1);
        int expectedHashCodeResult = jwtResponse.hashCode();
        assertEquals(expectedHashCodeResult, jwtResponse1.hashCode());
    }
}
