package com.example.lambda4;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void test() throws  Exception {
        System.out.println("test");
        //http://edgibbs.com/junit-4-with-hamcrest/
        assertThat("a", is("a"));
        assertThat("a b c", is(notNullValue()));

        assertThat("Hello", is(anyOf(nullValue(), instanceOf(String.class), equalTo("Goodbye"))));



    }
}