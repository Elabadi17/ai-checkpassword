# AwesomePasswordChecker

## Project Overview

The **AwesomePasswordChecker** is a Java library designed to analyze and score passwords based on their complexity. It offers functionalities to mask passwords, compute their similarity to predefined cluster centers, and evaluate their strength. This tool can be useful for cybersecurity applications, helping developers build secure password validation mechanisms.

## Features

- **Password Masking**: Masks different characters in the password with predefined values for various character types (e.g., lowercase, uppercase, digits, special characters).
- **Password Similarity**: Compares the password to predefined "cluster centers" to calculate a similarity score using the Euclidean distance.
- **MD5 Hashing**: Computes the MD5 hash of a given password for secure password storage.

## Requirements

- Java 11 or higher
- Maven (for dependency management and building the project)

## Installation

To use the **AwesomePasswordChecker** library, follow these steps:

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/AwesomePasswordChecker.git
    cd AwesomePasswordChecker
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

3. Add the library to your project as a dependency (if using Maven):

    ```xml
    <dependency>
        <groupId>org.example</groupId>
        <artifactId>AwesomePasswordChecker</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

## Basic Usage

Here’s how you can use the library in your own Java project.

### 1. Get an Instance of the Password Checker

You can retrieve the singleton instance of the `AwesomePasswordChecker` class.

```java
AwesomePasswordChecker checker = AwesomePasswordChecker.getInstance();
