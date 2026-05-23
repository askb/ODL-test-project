/*
 * SPDX-License-Identifier: EPL-1.0
 * SPDX-FileCopyrightText: 2026 The Linux Foundation
 */
package org.opendaylight.testproject.testapi;

/**
 * Simple service interface for testing Maven stage/release workflows.
 */
public interface GreetingService {

    /**
     * Returns a greeting for the given name.
     *
     * @param name the name to greet
     * @return greeting string
     */
    String greet(String name);

    /**
     * Returns the current version of this service.
     *
     * @return version string
     */
    String getVersion();
}
