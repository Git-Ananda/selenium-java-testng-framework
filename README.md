# Selenium Java Automation Framework

![Java](https://img.shields.io/badge/Java-21-blue)
![Selenium](https://img.shields.io/badge/Selenium-4-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-7-red)
![Maven](https://img.shields.io/badge/Maven-Build-orange)
![Apache POI](https://img.shields.io/badge/Apache%20POI-Excel-yellow)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-green)
![Extent Reports](https://img.shields.io/badge/Extent-Reports-blueviolet)

A scalable and maintainable Selenium automation framework built using Java, Selenium 4, TestNG, Maven, and the Page Object Model (POM).

The framework follows enterprise level design principles and demonstrates how a production ready automation framework is structured with reusable components, reporting, logging, retry mechanisms, and data driven testing.

---

# Highlights

* Enterprise style Selenium Automation Framework
* Page Object Model (POM)
* Page Object Manager
* Thread safe WebDriver using ThreadLocal
* Factory Design Pattern
* Singleton Design Pattern
* Apache POI Data Driven Testing
* Excel based test execution
* Extent HTML Reports
* Log4j2 Logging
* Retry Analyzer
* Screenshot Capture
* Explicit Wait Utility
* Configuration driven execution
* Cross Browser Testing
* Clean and Modular Architecture

---

# Framework Architecture

```text
                      testng.xml
                           │
                           ▼
                      TestNG Runner
                           │
                           ▼
                       BaseTest
                           │
                           ▼
                    DriverFactory
                           │
                           ▼
              DriverManager (ThreadLocal)
                           │
                           ▼
                 PageObjectManager
                           │
             ┌─────────────┴─────────────┐
             ▼                           ▼
        LoginPage                  DashboardPage
             │                           │
             └─────────────┬─────────────┘
                           ▼
                    Selenium WebDriver
                           │
                           ▼
                 OrangeHRM Application

----------------------------------------------------

Configuration

config.properties
        │
        ▼
 ConfigReader (Singleton)

----------------------------------------------------

Reporting

TestListener
      │
      ▼
ExtentLogger
      │
      ▼
ExtentTestManager
      │
      ▼
Extent Reports

----------------------------------------------------

Data Driven Testing

LoginData.xlsx
      │
      ▼
ExcelUtility
      │
      ▼
LoginDataProvider
      │
      ▼
LoginTest
```

---

# Project Structure

```text
src
│
├── main
│   ├── java
│   │
│   ├── base
│   │     └── BaseTest.java
│   │
│   ├── constants
│   │     ├── ExcelColumns.java
│   │     └── FrameworkConstants.java
│   │
│   ├── driver
│   │     └── DriverManager.java
│   │
│   ├── enums
│   │     └── ExpectedResult.java
│   │
│   ├── factory
│   │     └── DriverFactory.java
│   │
│   ├── listeners
│   │     ├── RetryTransformer.java
│   │     └── TestListener.java
│   │
│   ├── managers
│   │     └── PageObjectManager.java
│   │
│   ├── pages
│   │     ├── BasePage.java
│   │     ├── DashboardPage.java
│   │     └── LoginPage.java
│   │
│   ├── reports
│   │     ├── ExtentLogger.java
│   │     ├── ExtentManager.java
│   │     └── ExtentTestManager.java
│   │
│   ├── retry
│   │     └── RetryAnalyzer.java
│   │
│   ├── utilities
│   │     ├── ConfigReader.java
│   │     ├── ExcelUtility.java
│   │     ├── ScreenshotUtility.java
│   │     └── WaitUtility.java
│   │
│   └── resources
│         ├── config.properties
│         └── log4j2.xml
│
├── test
│   ├── java
│   │
│   ├── dataproviders
│   │     └── LoginDataProvider.java
│   │
│   └── tests
│         └── LoginTest.java
│
├── resources
│   └── testdata
│         └── LoginData.xlsx
│
├── testng.xml
├── pom.xml
└── README.md
```

---

# Package Responsibilities

| Package | Responsibility |
|----------|----------------|
| base | Browser setup and framework initialization |
| constants | Framework constants and Excel column names |
| driver | Thread safe WebDriver management |
| enums | Enumerations used throughout the framework |
| factory | Browser creation using Factory Pattern |
| listeners | TestNG Listeners and Annotation Transformers |
| managers | Centralized Page Object management |
| pages | Page Object Model implementation |
| reports | Extent Report management |
| retry | Retry mechanism implementation |
| utilities | Common reusable utility classes |
| dataproviders | TestNG Data Providers |
| tests | Test classes |

---

# Design Patterns Used

| Design Pattern | Implementation |
|----------------|----------------|
| Singleton | ConfigReader, ExtentManager |
| Factory | DriverFactory |
| ThreadLocal | DriverManager |
| Page Object Model | Page Classes |
| Page Object Manager | PageObjectManager |

---

# Data Driven Testing

The framework supports Excel based Data Driven Testing using Apache POI and TestNG DataProviders.

Example Test Data

| Username | Password | Expected |
|----------|----------|----------|
| Admin | admin123 | PASS |
| Admin | admin12 | FAIL |
| User | password | FAIL |

Execution Flow

```text
Excel File
     │
     ▼
ExcelUtility
     │
     ▼
DataProvider
     │
     ▼
TestNG
     │
     ▼
Single Test Executed Multiple Times
```

---

# Reporting

The framework automatically generates

* Extent HTML Report
* Screenshots for failed tests
* Log4j2 execution logs

---

# Logging

Log4j2 is integrated for framework logging.

Logs include

* Browser initialization
* Test execution
* Retry attempts
* Errors
* Framework events

---

# Browser Support

Configure the browser through `config.properties`.

Supported browsers

* Chrome
* Microsoft Edge
* Mozilla Firefox

Example

```properties
browser=chrome
```

---

# Framework Configuration

Framework execution is controlled through `config.properties`.

Example

```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com

explicitWait=10
retryCount=2

loginExcelFile=LoginData.xlsx
loginSheet=LoginData
```

---

# Technology Stack

* Java 21
* Selenium 4
* TestNG
* Maven
* Apache POI
* Log4j2
* Extent Reports

---

# Running the Framework

## Clone the Repository

```bash
git clone https://github.com/<your-github-username>/selenium-java-framework.git
```

## Install Dependencies

```bash
mvn clean install
```

## Execute Tests

Using IntelliJ IDEA

```text
Right Click
testng.xml
Run
```

Using Maven

```bash
mvn test
```

---

# Current Framework Features

* Selenium Web Automation
* Cross Browser Execution
* Thread Safe WebDriver
* Page Object Model
* Page Object Manager
* Explicit Wait Handling
* Screenshot Capture
* Extent HTML Reports
* Retry Mechanism
* Log4j2 Logging
* Excel Based Data Driven Testing
* Configuration Driven Framework
* Modular Architecture

---

# Planned Enhancements

* Parallel Execution
* Selenium Grid
* Docker Integration
* Jenkins CI/CD
* GitHub Actions
* REST Assured API Testing
* Database Validation
* Environment Based Configuration
* Allure Reports
* BrowserStack Integration

---

# Author

**Anandaroop Maitra**

Manual QA Engineer with hands on experience in Selenium Automation, TestNG, Java, SQL, API Testing, and Manual Testing.

---

# License

This project is intended for learning, portfolio, and demonstration purposes.