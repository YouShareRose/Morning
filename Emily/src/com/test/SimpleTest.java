package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 这是一个测试模版
 * Created by Administrator on 2016/9/6.
 */
public class SimpleTest {
    private java.util.List emptyList;

    /**
     * Sets up the test fixture.
     * (Called before every test case method.)
     */
    @Before
    public void setUp() {
        emptyList = new java.util.ArrayList();
    }

    /**
     * Tears down the test fixture.
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {
        emptyList = null;
    }

    @Test
    public void testSomeBehavior() {
        assertEquals("Empty list should have 0 elements", 0, emptyList.size());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testForException() {
        Object o = emptyList.get(0);
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("com.test.SimpleTest");
    }
}
