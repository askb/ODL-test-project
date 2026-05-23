# SPDX-License-Identifier: EPL-1.0

# SPDX-FileCopyrightText: 2026 The Linux Foundation

# ODL Test Project

A minimal multi-module Maven project mimicking OpenDaylight structure
for testing Maven stage/release GitHub Actions workflows.

## Purpose

This project validates the following GHA actions and workflows:

| Test | Workflow                          | What it tests                                                      |
| ---- | --------------------------------- | ------------------------------------------------------------------ |
| A    | `test-a-stage-prep.yaml`          | `askb/maven-stage-prep-action` — de-SNAPSHOT, patch, bundle        |
| B    | `test-b-nexus-staging.yaml`       | `askb/nexus-staging-action` — Nexus 2 lifecycle (stage/close/drop) |
| C    | `test-c-artifactory-staging.yaml` | JFrog CLI — Artifactory upload, build-info, promote                |
| D    | `test-d-central-publish.yaml`     | Central Portal REST API — bundle zip upload                        |
| E    | `test-e-full-pipeline.yaml`       | End-to-end: prep → stage → release → central                       |

## Project Structure

```
ODL-test-project/
├── pom.xml                    # Aggregator POM (1.0.0-SNAPSHOT)
├── artifacts/pom.xml          # BOM module
├── testapi/                   # API interfaces (jar)
│   └── src/main/java/...
├── testlib/                   # Implementation (jar, depends on testapi)
│   ├── src/main/java/...
│   └── src/test/java/...
└── .github/workflows/         # Test workflows A-E
```

## Quick Start

```bash
# Build locally
mvn clean install

# Build and deploy to local m2repo (simulates staging)
mvn clean deploy -DaltDeploymentRepository="staging::default::file://$(pwd)/m2repo" -DskipTests

# Run specific test workflow
gh workflow run test-a-stage-prep.yaml
gh workflow run test-b-nexus-staging.yaml -f mode=full-lifecycle
gh workflow run test-c-artifactory-staging.yaml -f mode=full-lifecycle
gh workflow run test-d-central-publish.yaml -f dry-run=true
gh workflow run test-e-full-pipeline.yaml -f artifact-server=nexus2 -f dry-run=true
```

## Required Secrets

| Secret                     | Used by   | Description                 |
| -------------------------- | --------- | --------------------------- |
| `NEXUS_USERNAME`           | Test B, E | ODL Nexus 2 service account |
| `NEXUS_PASSWORD`           | Test B, E | ODL Nexus 2 password        |
| `ARTIFACTORY_URL`          | Test C, E | JFrog Artifactory Cloud URL |
| `ARTIFACTORY_ACCESS_TOKEN` | Test C, E | JFrog access token          |
| `GPG_SECRET_KEY`           | Test D, E | GPG private key (armor)     |
| `GPG_PASSPHRASE`           | Test D, E | GPG key passphrase          |
| `CENTRAL_USERNAME`         | Test D, E | Central Portal username     |
| `CENTRAL_TOKEN`            | Test D, E | Central Portal token        |

## Maven Coordinates

- **groupId:** `org.opendaylight.testproject`
- **version:** `1.0.0-SNAPSHOT`
- **Modules:** `testproject-api`, `testproject-lib`, `testproject-artifacts`

## Related Repositories

- [askb/maven-stage-prep-action](https://github.com/askb/maven-stage-prep-action)
- [askb/nexus-staging-action](https://github.com/askb/nexus-staging-action)
- [askb/releng-reusable-workflows](https://github.com/askb/releng-reusable-workflows)

## License

Eclipse Public License v1.0 — see [LICENSE](LICENSE)
