## TestVagrant-Coding-Test

Welcome!

I have built this project to do fetch Release Date and Country fields of your favourite movie (any movie!) from its IMDB and Wikipedia page and compare them to see if there is any discrepency.

&nbsp;
## Getting Started

Please follow the below steps to setup up the dependencies required to run the project.

##### 1. Installing Maven and Chrome browser

We need to install Maven in our system first to run this project.

Following link has detailed instructions for [Maven Installation](https://maven.apache.org/install.html).

Please make sure your Chrome browser is using the latest Version 105/106.

&nbsp;
##### 2. Cloning the GIT repo

We need to clone this repository in order to run the test scripts.

Following GIT commands will help you achieve this.

```
git clone https://github.com/ndevare13/TestVagrant-Coding-Test.git
```

&nbsp;
##### 3. Running the test scripts

Now that we have installed Maven and cloned the project in our system, we need to run the scripts to perform the validation.

For this, first we need to navigate to our project folder 'TestVagrant-Coding-Test' in our system and open command line from there.

Then in our command line, we have to provide the following command -

```
mvn clean test
```

This will run the tests for movie mentioned in the description - "Pushpa: The Rise"

If you want to run the scripts for your favourite movie then instead of the above command, provide the following -

```
mvn clean test -DmovieName="{insert the movie name}"
```

For example -

```
mvn clean test -DmovieName="Karthik Calling Karthik"
```

&nbsp;
##### 4. Viewing Reports

Once above commands are executed, it will automatically open your Chrome browser and run the test script to do the validations.

You can check the basic report inside your 'test-output' folder, there would be a file named 'emailable-report.html'


&nbsp;
## Closing Notes

This is a coding test for TestVagrant. In case of any queries or issues, please feel free to contact me.