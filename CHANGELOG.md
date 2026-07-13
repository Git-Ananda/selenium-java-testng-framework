# Changelog

All notable changes to this project will be documented in this file.

---

## v2.2

### Added

- Parallel execution support using TestNG.
- Browser parameterization through `testng.xml`.
- Dashboard test for validating parallel execution.
- Thread ID logging for debugging parallel runs.

### Improved

- BaseTest browser initialization flow.
- Driver lifecycle management.
- Framework documentation.
- Browser selection priority.

### Changed

- Browser initialization now supports:

```text
testng.xml
    ↓
config.properties
```

- Added support for:

```xml
<suite
        parallel="classes"
        thread-count="2">
```

---

## v2.1

### Added

- Apache POI integration.
- ExcelUtility.
- Header based Excel data reading.
- TestNG DataProvider.
- ExpectedResult enum.
- LoginDataProvider.
- Data driven testing support.

### Improved

- WaitUtility.
- BasePage.
- ScreenshotUtility.
- Framework architecture.
- README documentation.

### Changed

- Test execution is now data driven using Excel files.

---

## v2.0

### Added

- ThreadLocal DriverManager.
- Extent Reports.
- Retry Analyzer.
- Retry Transformer.
- Log4j2 logging.
- Page Object Manager.

### Improved

- Screenshot capture.
- Reporting mechanism.
- Driver management.

---

## v1.0

### Added

- Selenium 4 setup.
- Maven project structure.
- Java 21 configuration.
- TestNG integration.
- BaseTest.
- BasePage.
- Page Object Model.
- Cross browser execution.
- ConfigReader.
- WaitUtility.
- ScreenshotUtility.
