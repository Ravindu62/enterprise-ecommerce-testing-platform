# Test Plan

## Document Information

| Item | Details |
|------|---------|
| Project | Enterprise E-Commerce Testing Platform |
| Application | Maho Commerce Demo Store |
| Version | 1.0 |
| Prepared By | Ravindu Nanayakkara |
| Date | July 2026 |
| Document Type | Test Plan |

---

# 1. Introduction

## Purpose

This Test Plan defines the testing activities, scope, resources, schedule, deliverables, risks, and execution approach for validating the Maho Commerce Demo Store. It provides a roadmap for the testing effort and ensures that testing is performed consistently and systematically.

---

# 2. Project Overview

The Maho Commerce Demo Store is an e-commerce application that enables customers to browse products, manage accounts, purchase items, and track orders. The platform also includes an administrative portal for managing products, customers, and orders.

The objective of this project is to validate the application's functionality, reliability, usability, performance, security, and compatibility through both manual and automated testing.

---

# 3. Testing Objectives

The testing effort aims to:

- Verify all functional requirements defined in the SRS.
- Validate critical business workflows.
- Detect and document defects.
- Confirm regression stability.
- Validate APIs and database consistency.
- Verify compatibility across supported browsers.
- Ensure acceptable performance.
- Assess basic accessibility and security.

---

# 4. Scope

## In Scope

### Customer Portal

- Homepage
- Navigation
- Registration
- Login
- Forgot Password
- My Account
- Categories
- Product Search
- Product Details
- Wishlist
- Product Comparison
- Shopping Cart
- Checkout
- Orders
- Newsletter
- Contact Us

### Admin Portal

- Login
- Dashboard
- Product Management
- Customer Management
- Order Management
- Reports

### Additional Testing

- API Testing
- Database Validation
- Accessibility Testing
- Cross-Browser Testing
- Performance Testing
- Security Testing

---

## Out of Scope

- Source code review
- Infrastructure testing
- Native mobile application testing
- Production environment testing
- Large-scale load and stress testing
- Third-party payment gateway certification

---

# 5. Test Items

The following items will be tested:

| Module | Priority |
|---------|----------|
| Homepage | High |
| Registration | High |
| Login | High |
| Search | High |
| Categories | High |
| Product Details | High |
| Cart | Critical |
| Checkout | Critical |
| Orders | High |
| Admin Dashboard | High |
| Product Management | High |
| Customer Management | High |
| Order Management | Critical |

---

# 6. Test Approach

The project will use a combination of manual and automated testing.

## Manual Testing

- Requirement-based testing
- Exploratory testing
- Functional testing
- UI validation
- Negative testing
- Boundary value analysis
- Error validation

## Automation Testing

Automation will be implemented using:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- WebDriverManager

Automation suites:

- Smoke Suite
- Regression Suite

---

# 7. Test Environment

| Component | Configuration |
|-----------|---------------|
| Environment | Demo |
| Operating System | macOS |
| Java | JDK 25 |
| Browser | Chrome, Firefox, Edge, Safari |
| IDE | IntelliJ IDEA |
| Build Tool | Maven |
| Automation Framework | Selenium + TestNG |
| API Framework | Rest Assured |
| Database | MySQL |
| Reporting | Allure & Extent Reports |
| CI/CD | Jenkins & GitHub Actions |

---

# 8. Test Deliverables

The following deliverables will be produced:

## Documentation

- Business Requirements Specification
- Software Requirement Specification
- Test Strategy
- Test Plan
- Requirement Traceability Matrix
- Test Scenarios
- Manual Test Cases
- Defect Log
- Bug Reports
- Test Summary Report
- Test Closure Report

## Automation

- Selenium Framework
- Page Object Model
- Utility Classes
- TestNG Suites
- API Test Suite
- SQL Validation Scripts

## Reports

- Allure Report
- Extent Report
- TestNG Report
- Execution Logs

---

# 9. Entry Criteria

Testing will begin when:

- Requirements are finalized.
- Demo environment is accessible.
- Test accounts are available.
- Test data is prepared.
- Automation framework is configured.
- Necessary tools are installed.

---

# 10. Exit Criteria

Testing will conclude when:

- All planned test cases have been executed.
- Critical and High severity defects are resolved or accepted.
- Smoke suite passes successfully.
- Regression suite achieves the planned pass rate.
- Test Summary Report is completed.

---

# 11. Suspension Criteria

Testing may be suspended if:

- Demo environment is unavailable.
- Critical defects prevent further execution.
- Required test data is unavailable.
- Build instability prevents meaningful testing.

Testing will resume once blocking issues have been resolved.

---

# 12. Defect Management Process

Defects will be logged with the following information:

- Defect ID
- Module
- Summary
- Description
- Steps to Reproduce
- Expected Result
- Actual Result
- Severity
- Priority
- Status
- Assigned To
- Reporter
- Attachments

Defect Lifecycle:

New → Assigned → In Progress → Fixed → Retest → Closed

Alternative statuses (when applicable):

Rejected → Deferred → Duplicate → Cannot Reproduce

---

# 13. Roles and Responsibilities

| Role | Responsibility |
|------|----------------|
| QA Engineer | Design test cases, execute tests, log defects, automate regression |
| Developer | Fix defects, support root cause analysis |
| Project Manager | Monitor schedule, approve deliverables |
| System Administrator | Maintain demo environment |

---

# 14. Risks

| Risk | Impact | Mitigation |
|------|--------|------------|
| Demo environment downtime | High | Retry execution after recovery |
| Test data reset | Medium | Maintain reusable datasets |
| Browser compatibility issues | Medium | Execute cross-browser testing |
| Environment slowness | Medium | Use explicit waits and rerun failed cases |
| Feature changes | Medium | Update RTM and test cases accordingly |

---

# 15. Assumptions

- Demo environment remains available.
- Internet connectivity is stable.
- Test users can be created.
- Test data can be regenerated if required.
- Supported browsers are available for testing.

---

# 16. Test Schedule

| Phase | Estimated Duration |
|--------|--------------------|
| Requirement Analysis | 1 Day |
| Test Planning | 1 Day |
| Test Case Design | 3 Days |
| Manual Test Execution | 5 Days |
| Defect Reporting | Ongoing |
| Automation Development | 6 Days |
| API Testing | 2 Days |
| Database Validation | 2 Days |
| Regression Testing | 3 Days |
| Reporting & Closure | 1 Day |

---

# 17. Test Completion Criteria

The project will be considered complete when:

- 100% of planned test cases have been executed.
- No open Critical defects remain.
- High severity defects are resolved or accepted.
- Regression suite is stable.
- Automation suite executes successfully.
- All project documentation is finalized.
- Final Test Summary Report and Test Closure Report are completed.