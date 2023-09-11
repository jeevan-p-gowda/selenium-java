# Selenium-Java <img align="right" src="https://avatars.githubusercontent.com/u/983927?s=200&v=4" width="auto" height="100" title='Selenium'/>
Educate on Selenium latests.
### 🧬 Features
1. [Docker implementation](src/test/java/docker)
   1. Run on Docker container
   2. Parallel execution using Docker-Selenium Grid
2. [Selenium latest](src/test/java/selenium4)
   1. Chrome Dev Tools
   2. WebElement and Page Section Screenshots
   3. Popping new tab and web window
   4. Friendly / Relative locators

### 🏃‍Run config and execution
1. For tests with docker
   1. Install docker 
      1. ```brew install docker```
      2. ```brew install docker-compose```
      3. Add Docker [plugin](https://plugins.jetbrains.com/plugin/7724-docker) to IDE
   2. Start / Stop containers
      1. ```docker-compose up``` (or) Start directly ```docker-compose.yml```
      2. Open terminal and check for up and running ```docker ps -a```
      3. Post-Execution ```docker-compose down``` (or) Stop ```docker-compose.yml```
   3. Run & View tests
      1. Run [TestNG](testng.xml) xml
      2. View http://localhost:4444/ui
2. Selenium tests
   ```mvn clean test io.qameta.allure:allure-maven:serve```
### 📚 Stack
* Lang - Java 8
* Library - Selenium
* Framework - TestNG
* Builder - Maven
* Report - Allure
* Container - Docker

