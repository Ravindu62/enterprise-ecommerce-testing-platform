# Software Requirement Specification (SRS)

## Project Information

| Item | Details |
|------|---------|
| Project | Enterprise E-Commerce Testing Platform |
| Application | Maho Commerce Demo Store |
| Version | 1.0 |
| Prepared By | Ravindu Nanayakkara |
| Date | July 2026 |

---

# 1. Purpose

This Software Requirement Specification defines the functional and non-functional requirements for the Maho Commerce e-commerce application. These requirements serve as the foundation for planning, designing, executing, and automating software testing activities.

---

# 2. Functional Requirements

## 2.1 Homepage

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-001 | Homepage shall load successfully. | High |
| REQ-002 | Homepage shall display company logo. | High |
| REQ-003 | Homepage shall display navigation menu. | High |
| REQ-004 | Homepage shall display featured products. | Medium |
| REQ-005 | Homepage shall display promotional banners. | Medium |
| REQ-006 | Homepage shall display footer information. | Medium |
| REQ-007 | Homepage links shall navigate correctly. | High |
| REQ-008 | Homepage shall be responsive across supported screen sizes. | Medium |

---

## 2.2 User Registration

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-009 | User shall register with valid details. | High |
| REQ-010 | First Name is mandatory. | High |
| REQ-011 | Last Name is mandatory. | High |
| REQ-012 | Email must be unique. | High |
| REQ-013 | Email must follow valid format. | High |
| REQ-014 | Password is mandatory. | High |
| REQ-015 | Password confirmation must match. | High |
| REQ-016 | Validation messages shall be displayed for invalid input. | High |
| REQ-017 | Successful registration shall redirect to My Account. | High |

---

## 2.3 Login

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-018 | Registered user shall log in with valid credentials. | High |
| REQ-019 | Invalid password shall display an error message. | High |
| REQ-020 | Invalid email shall display an error message. | High |
| REQ-021 | Empty credentials shall not be accepted. | High |
| REQ-022 | Session shall be created after successful login. | High |
| REQ-023 | User shall log out successfully. | High |

---

## 2.4 Forgot Password

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-024 | User can request password reset. | High |
| REQ-025 | Invalid email shall show validation. | Medium |
| REQ-026 | Password reset confirmation message shall be displayed. | Medium |

---

## 2.5 Product Search

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-027 | Search shall return matching products. | High |
| REQ-028 | Partial keyword search shall be supported. | High |
| REQ-029 | Search shall be case-insensitive. | Medium |
| REQ-030 | No-result search shall display an appropriate message. | High |
| REQ-031 | Search input shall accept special characters safely. | Medium |

---

## 2.6 Product Catalog

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-032 | Categories shall display products correctly. | High |
| REQ-033 | Product image shall be displayed. | High |
| REQ-034 | Product price shall be displayed. | High |
| REQ-035 | Product stock status shall be displayed. | High |
| REQ-036 | Product description shall be displayed. | Medium |
| REQ-037 | Breadcrumb navigation shall work correctly. | Medium |

---

## 2.7 Product Details

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-038 | Product details page shall load successfully. | High |
| REQ-039 | Product gallery shall display images. | Medium |
| REQ-040 | Quantity selector shall function correctly. | High |
| REQ-041 | Add to Cart button shall be available. | High |
| REQ-042 | Add to Wishlist shall be available. | Medium |
| REQ-043 | Compare Product option shall be available. | Medium |

---

## 2.8 Shopping Cart

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-044 | Products shall be added to the cart successfully. | Critical |
| REQ-045 | Quantity shall be updated correctly. | Critical |
| REQ-046 | Cart subtotal shall be calculated correctly. | Critical |
| REQ-047 | Product shall be removable from the cart. | High |
| REQ-048 | Empty cart shall display a proper message. | Medium |

---

## 2.9 Checkout

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-049 | Checkout shall require mandatory information. | Critical |
| REQ-050 | Shipping address shall be saved. | High |
| REQ-051 | Shipping method shall be selectable. | High |
| REQ-052 | Payment method shall be selectable. | Critical |
| REQ-053 | Order review shall display correct details. | Critical |
| REQ-054 | Order confirmation shall be displayed after successful purchase. | Critical |

---

## 2.10 My Account

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-055 | User profile shall be editable. | Medium |
| REQ-056 | Address book shall support CRUD operations. | Medium |
| REQ-057 | Order history shall be available. | High |
| REQ-058 | Wishlist shall be accessible. | Medium |

---

## 2.11 Admin Panel

| Requirement ID | Requirement | Priority |
|---------------|-------------|----------|
| REQ-059 | Administrator shall log in successfully. | Critical |
| REQ-060 | Dashboard shall display summary widgets. | Medium |
| REQ-061 | Products shall be managed successfully. | High |
| REQ-062 | Orders shall be searchable. | High |
| REQ-063 | Customers shall be manageable. | High |
| REQ-064 | Reports shall be viewable. | Medium |

---

# 3. Non-Functional Requirements

| ID | Requirement |
|----|-------------|
| NFR-001 | Homepage should load within acceptable response time under normal conditions. |
| NFR-002 | System shall support Chrome, Firefox, Edge, and Safari. |
| NFR-003 | Passwords shall be securely stored. |
| NFR-004 | Sessions shall expire after inactivity. |
| NFR-005 | Application shall use HTTPS. |
| NFR-006 | Forms shall provide clear validation messages. |
| NFR-007 | UI shall be responsive on common desktop and mobile resolutions. |
| NFR-008 | Images shall include meaningful alternative text where appropriate. |
| NFR-009 | Keyboard navigation shall be supported. |
| NFR-010 | Application shall remain available except during planned maintenance. |

---

# 4. Assumptions

- Stable internet connectivity.
- Demo environment remains available.
- Required user accounts can be created.
- Test data can be generated without restrictions.

---

# 5. Constraints

- Demo data may reset periodically.
- Payment flow may use simulated payment methods.
- Some admin actions may be restricted in the demo environment.

---

# 6. Requirement Summary

| Category | Count |
|----------|------:|
| Functional Requirements | 64 |
| Non-Functional Requirements | 10 |
| Total Requirements | 74 |