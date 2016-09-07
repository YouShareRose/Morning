package com.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SimpleTest {
    private Collection<Object> collection;
    @Before
    public void setUp() {
        collection = new ArrayList<>();
    }

    @Test
    public void testEmptyCollection() {
        assertTrue(collection.isEmpty());
    }


    @Test
    public void testOneItemCollection() {
        collection.add("itemA");
        assertEquals(1, collection.size());
    }

    @Test
    public void testNotEmptyCollection() {
        assertFalse(collection.isEmpty());
    }

    @Test
    public void testTwoItemCollection() {
        collection.add("itemB");
        assertEquals(1, collection.size());
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("com.test.SimpleTest");
    }
}
