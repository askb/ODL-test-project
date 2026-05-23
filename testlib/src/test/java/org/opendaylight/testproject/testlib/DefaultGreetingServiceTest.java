/*
 * SPDX-License-Identifier: EPL-1.0
 * SPDX-FileCopyrightText: 2026 The Linux Foundation
 */
package org.opendaylight.testproject.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link DefaultGreetingService}.
 */
class DefaultGreetingServiceTest {

    private DefaultGreetingService service;

    @BeforeEach
    void setUp() {
        service = new DefaultGreetingService();
    }

    @Test
    void testGreetWithName() {
        assertEquals("Hello, ODL!", service.greet("ODL"));
    }

    @Test
    void testGreetWithNull() {
        assertEquals("Hello, World!", service.greet(null));
    }

    @Test
    void testGreetWithEmpty() {
        assertEquals("Hello, World!", service.greet(""));
    }

    @Test
    void testGetVersion() {
        assertNotNull(service.getVersion());
        assertEquals("1.0.0-SNAPSHOT", service.getVersion());
    }
}
