====================================
## Lookup Service
 
[![travis](https://travis-ci.org/mxcheung/microservice.svg?branch=master)](https://travis-ci.org/mxcheung/microservice?branch=master)
[![codecov](https://codecov.io/gh/mxcheung/microservice/branch/master/graph/badge.svg)](https://codecov.io/gh/mxcheung/microservice)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f4d27930885946fd9fbd34ee8e42e449)](https://www.codacy.com/app/mxcheung/microservice?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mxcheung/microservice&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/f4d27930885946fd9fbd34ee8e42e449)](https://www.codacy.com/app/mxcheung/microservice?utm_source=github.com&utm_medium=referral&utm_content=mxcheung/microservice&utm_campaign=Badge_Coverage)

This module intentions is to:  
   - read fixed length transaction files.
   - product a daily summary report.

### How to run the program ###
java -jar fileingestor.jar datafile.txt out.csv

### Continous Integration and Code Coverage 
- [Continous Integration](https://travis-ci.org/mxcheung/microservice?branch=master)
- [Code Coverage](https://codecov.io/gh/mxcheung/microservice)
- [Codacy](https://www.codacy.com/app/mxcheung/microservice?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mxcheung/microservice&amp;utm_campaign=Badge_Grade)


CREATE USER 'golden'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'golden'@'localhost';
FLUSH PRIVILEGES;

mysql -u username -p nyc6 < E:\TEMP2\ny_cab_data_cab_trip_data_full.sql


mysql -p nyc6 < E:\TEMP2\ny_cab_data_cab_trip_data_full.sql



-Dspring.profiles.active=local-mysql

### Relevant Articles: 
- [Introduction to Spring Batch](http://www.baeldung.com/introduction-to-spring-batch)
- [FixedLengthTokenizer](https://docs.spring.io/spring-batch/trunk/apidocs/org/springframework/batch/item/file/transform/FixedLengthTokenizer.html)
- [Jackson CSV extension](http://www.baeldung.com/spring-app-setup-with-csv-files)
- [Java Bean Validation Basics](http://www.baeldung.com/javax-validation)

### What is this repository for? ###

* Service to process Future Clearing files
* 1.0.0

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact



Building The Project
================
---
###Eclipse:
1. Before importing into eclipse execute the `mvn eclipse:eclipse` command to prepare the project to be able to 
be simply imported into the IDE.
2. Within the IDE, select `import existing eclipse project` option and as the eclipse:eclipse command will have
prepared **.project** and **.classpath** files, this will mean minimal setup required.
3. Add the integration-test src and resources to your classpath to ensure your can easily execute integration tests from the IDE.

###Compiling
The project has been designed to be built via `maven` the pom has been configured to be able to execute unit and
integration tests, generate code coverage reports, and code checkstyle testing.

Four Test Profiles have been configured to aid in building the project depending on what you wish to achieve:

1. `unit-tests` will only execute unit tests.
2. `integration-tests` will only execute integration tests.
3. `all-tests` both unit and integration tests are run.
4. `no-tests` no tests run.

The default profile is __all-tests__.

Some example executions are as followed.
* mvn _clean test_ => Creates code coverage report for unit tests.
* mvn _clean verify -P unit-tests_ => Creates code coverage report for unit tests and fails if does not meet coverage ratios.
* mvn _clean verify -P integration-tests_ => Creates code coverage report for unit tests and fails if does not meet coverage ratios. 
* mvn _clean verify -P all-tests_ => Creates code coverage reports for unit and integration tests and fails if does not meet coverage ratios).
* mvn _clean package -P no-tests_ => Does not execute tests and creates the distributable.
* mvn _clean verify -P all-tests checkstyle:check_ => runs all tests, checkstyle and packages.	

Before submitting your code to GIT run __clean verify -P all-tests checkstyle:check__ and build successfully to ensure that all tests and code style checks are completed to ensure Continuous Integration build errors do not arise.

Test Profiles
=============
no-tests - all tests are ignored
all-tests - all tests are executed
unit-tests - only unit tests are executed
integration-tests - only integration tests are executed



