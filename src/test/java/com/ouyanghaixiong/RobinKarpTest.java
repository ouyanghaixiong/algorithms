package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/19
 * @desc
 */
public class RobinKarpTest {

    @Test
    public void search() {
        assertEquals(3, RobinKarp.search("ababacd", "bac"));
        assertEquals(-1 , RobinKarp.search("abc", "bac"));
        assertEquals(0, RobinKarp.search("abc", "abc"));
        assertEquals(4, RobinKarp.search("abdcabc", "abc"));
    }
}
