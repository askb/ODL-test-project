/*
 * SPDX-License-Identifier: EPL-1.0
 * SPDX-FileCopyrightText: 2026 The Linux Foundation
 */
package org.opendaylight.testproject.testapi;

/**
 * Utility class providing common helpers.
 */
public final class ProjectInfo {

    private static final String VERSION = "1.0.0-SNAPSHOT";
    private static final String PROJECT_NAME = "ODL Test Project";

    private ProjectInfo() {
        // utility class
    }

    /**
     * Returns the project name.
     *
     * @return project name
     */
    public static String getProjectName() {
        return PROJECT_NAME;
    }

    /**
     * Returns the project version from POM.
     *
     * @return project version string
     */
    public static String getVersion() {
        return VERSION;
    }
}
