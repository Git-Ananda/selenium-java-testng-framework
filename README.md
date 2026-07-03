# Selenium Java Automation Framework

A scalable Selenium automation framework built using Java, TestNG, Maven, and the Page Object Model.

The project demonstrates how a production style automation framework is designed with reusable components, clean architecture, reporting, logging, and data driven testing.

---

## Features

✔ Selenium 4

✔ Java

✔ Maven

✔ TestNG

✔ Page Object Model (POM)

✔ Page Object Manager

✔ ThreadLocal WebDriver

✔ Factory Design Pattern

✔ Singleton Design Pattern

✔ Apache POI Data Driven Testing

✔ Excel Based Test Data

✔ Extent Reports

✔ Log4j2 Logging

✔ Retry Analyzer

✔ Screenshot Capture

✔ Explicit Wait Utility

✔ Config Reader

✔ Git Version Control

---

## Project Structure

```
src
│
├── main
│   ├── base
│   ├── constants
│   ├── driver
│   ├── factory
│   ├── listeners
│   ├── pages
│   ├── reports
│   ├── retry
│   └── utilities
│
├── test
│   ├── dataproviders
│   ├── resources
│   │     ├── config.properties
│   │     └── testdata
│   └── tests
```

---

## Design Patterns Used

| Pattern | Purpose |
|----------|----------|
| Singleton | ConfigReader, ExtentManager |
| Factory | DriverFactory |
| ThreadLocal | DriverManager |
| Page Object Model | Encapsulates page operations |
| Page Object Manager | Centralized page creation |

---

## Reporting

The framework automatically generates:

* Extent HTML Reports
* Screenshots for failed tests
* Log4j2 execution logs

---

## Data Driven Testing

Test data is maintained in Excel.

Apache POI reads the Excel file and TestNG DataProviders execute the same test for multiple datasets.

Example:

| Username | Password | Expected |
|----------|----------|----------|
| Admin | admin123 | PASS |
| Admin | admin12 | FAIL |
| User | password | FAIL |

---

## Technologies

* Java 21
* Selenium 4
* TestNG
* Maven
* Apache POI
* Log4j2
* Extent Reports

---

## Future Enhancements

- Parallel Execution
- Jenkins CI/CD
- Docker
- Selenium Grid
- API Testing Integration
- Cross Browser Execution
- GitHub Actions

---

## Author

Anandaroop Maitra

Manual QA Engineer transitioning into Automation Testing.