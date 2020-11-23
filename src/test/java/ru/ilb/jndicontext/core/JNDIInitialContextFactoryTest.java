/*
 * Copyright 2019 slavb.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.ilb.jndicontext.core;

import javax.naming.Context;
import javax.naming.InitialContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author slavb
 */
public class JNDIInitialContextFactoryTest {

    public JNDIInitialContextFactoryTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getInitialContext method, of class JNDIInitialContextFactory.
     */
    @Test
    public void testGetInitialContext() throws Exception {
        System.out.println("getInitialContext");
        System.setProperty("java.naming.factory.initial", JNDIInitialContextFactory.class.getName());

        Context context = new InitialContext();

        context.bind("testkey", "testvalue");

        context = new InitialContext();
        String expResult = "testvalue";
        String result = (String) context.lookup("testkey");
        assertEquals(expResult, result);
    }

}
