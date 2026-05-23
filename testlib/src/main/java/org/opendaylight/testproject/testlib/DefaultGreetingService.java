/*
 * SPDX-License-Identifier: EPL-1.0
 * SPDX-FileCopyrightText: 2026 The Linux Foundation
 */
package org.opendaylight.testproject.testlib;

import org.opendaylight.testproject.testapi.GreetingService;

/**
 * Default implementation of {@link GreetingService}.
 */
public class DefaultGreetingService implements GreetingService {

    private static final String VERSION = "1.0.0-SNAPSHOT";

    @Override
    public String greet(final String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "!";
    }

    @Override
    public String getVersion() {
        return VERSION;
    }
}
