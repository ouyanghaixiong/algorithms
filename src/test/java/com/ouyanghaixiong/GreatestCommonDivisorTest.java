package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class GreatestCommonDivisorTest {

    @Test
    public void gcd() {
        assertEquals(5, GreatestCommonDivisor.gcd(15, 20));
        assertEquals(1, GreatestCommonDivisor.gcd(3, 4));
        assertEquals(2, GreatestCommonDivisor.gcd(10, 8));
    }
}
