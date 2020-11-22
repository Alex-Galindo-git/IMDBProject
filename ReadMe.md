## Prerequisites
* Install [Git](https://github.com/saucelabs-training/demo-java/blob/master/docs/prerequisites.md#install-git)
* Install [IntelliJ (or another IDE)](https://github.com/saucelabs-training/demo-java/blob/master/docs/prerequisites.md#install-intellij)
* Install [JDK](https://github.com/saucelabs-training/demo-java/blob/master/docs/prerequisites.md#install-the-jdk)
* Install [Maven](https://github.com/saucelabs-training/demo-java/blob/master/docs/prerequisites.md#install-maven)

* Language:Java(v8+)
* Test Runner:TestNg(v6.1+)
* Build Tool:Maven(v3.6.+)
* Plugins:Maven Surefire Plugin(v2.1+)
### Import the Project

1. Create a directory on your machine.
2. Clone this repository into said directory.
3. Import the project into your IntelliJ (or IDE of your choice) as a **Maven Project**.
4. Click through the prompts, and confirm when it asks to **Import from Sources**

### Run a Maven Test

1. Run the following command to update any package dependencies:
    ```
    $ mvn dependency:resolve
    ```
2. Then run the following command to compile your test code:
    ```
    $ mvn test-compile
    ```
###  Troubleshooting
To clean and install dependencies 

     $ mvn dependency:purge-local-repository


3.
  If you wish to run a specific test/sub-module in this using_testng use the following command:
       
       # for running a specific test:
       mvn test -Dtest=testname
       
       # for running all tests
       mvn test
       




    
