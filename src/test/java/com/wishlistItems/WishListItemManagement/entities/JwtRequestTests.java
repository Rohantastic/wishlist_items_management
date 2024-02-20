package com.wishlistItems.WishListItemManagement.entities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class JwtRequestTests {

    @Test
    void testCanEqual() {
        assertFalse((new JwtRequest()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        JwtRequest jwtRequest = new JwtRequest();

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("rohan@gmail.com");
        jwtRequest1.setPassword("password");
        assertTrue(jwtRequest.canEqual(jwtRequest1));
    }

    @Test
    void testConstructor() {
        JwtRequest actualJwtRequest = new JwtRequest();
        actualJwtRequest.setEmail("rohan@gmail.com");
        actualJwtRequest.setPassword("password");
        String actualToStringResult = actualJwtRequest.toString();
        assertEquals("rohan@gmail.com", actualJwtRequest.getEmail());
        assertEquals("password", actualJwtRequest.getPassword());
        assertEquals("JwtRequest(email=rohan@gmail.com, password=password)", actualToStringResult);
    }

    @Test
    void testEquals() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("rohan@gmail.com");
        jwtRequest.setPassword("password");
        assertNotEquals(jwtRequest, null);
    }

    @Test
    void testEquals2() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("rohan1@gmail.com");
        jwtRequest.setPassword("password");
        assertNotEquals(jwtRequest, "Different type to JwtRequest");
    }

    @Test
    void testEquals3() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("rohan@gmail.com");
        jwtRequest.setPassword("password");
        assertEquals(jwtRequest, jwtRequest);
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest.hashCode());
    }
    @Test
    void testEquals4() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("rohan@gmail.com");
        jwtRequest.setPassword("password");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("rohan@gmail.com");
        jwtRequest1.setPassword("password");
        assertEquals(jwtRequest, jwtRequest1);
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest1.hashCode());
    }

    @Test
    void testEquals5() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("ritik@gmail.com");
        jwtRequest.setPassword("password");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("rohan@gmail.com");
        jwtRequest1.setPassword("something");
        assertNotEquals(jwtRequest, jwtRequest1);
    }


    @Test
    void testEquals6() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail(null);
        jwtRequest.setPassword("huehue");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("ritik@gmail.com");
        jwtRequest1.setPassword("huehue");
        assertNotEquals(jwtRequest, jwtRequest1);
    }

    @Test
    void testEquals7() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("ritik@gmail.com");
        jwtRequest.setPassword("janet");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("ritik@gmail.com");
        jwtRequest1.setPassword("password");
        assertNotEquals(jwtRequest, jwtRequest1);
    }

    @Test
    void testEquals8() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("ritik@gmail.com");
        jwtRequest.setPassword(null);

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("ritik@gmail.com");
        jwtRequest1.setPassword("password");
        assertNotEquals(jwtRequest, jwtRequest1);
    }

    @Test
    void testEquals9() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail(null);
        jwtRequest.setPassword("password");

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail(null);
        jwtRequest1.setPassword("password");
        assertEquals(jwtRequest, jwtRequest1);
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest1.hashCode());
    }

    @Test
    void testEquals10() {
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setEmail("ritik@gmail.com");
        jwtRequest.setPassword(null);

        JwtRequest jwtRequest1 = new JwtRequest();
        jwtRequest1.setEmail("ritik@gmail.com");
        jwtRequest1.setPassword(null);
        assertEquals(jwtRequest, jwtRequest1);
        int expectedHashCodeResult = jwtRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtRequest1.hashCode());
    }
}

