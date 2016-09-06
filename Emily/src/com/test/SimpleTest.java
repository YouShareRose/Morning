package com.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SimpleTest {
    @Test
    public void testEmptyCollection() {
        Collection collection = new ArrayList();
        assertTrue(collection.isEmpty());
    }
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("com.test.SimpleTest");
    }
}
