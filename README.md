# Demonopcommerce 

> [!IMPORTANT]
> This is the website that you're supposed to perform your automation scenarios using Cucumber Framework 
> https://demo.nopcommerce.com/ 

## Add essential required dependencies

Search google on: [Selenium maven dependency](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java).

Search google on: [Cucumber java maven dependency](https://mvnrepository.com/artifact/io.cucumber/cucumber-java).

Search google on: [Cucumber TestNG maven dependency](https://mvnrepository.com/artifact/io.cucumber/cucumber-testng).

## Project Structure 
```
  src
    |_ main
        |_ resources
            |_ Features
                |_ F01_Register.feature
                |_ F02_Login.feature
                |_ F03_Currencies.feature
                |_ F04_Search.feature
                |_ F05_HoverCategories.feature
                |_ F06_HoverSliders.feature
                |_ F07_FollowUs.feature
                |_ F08_Wishlist.feature
    |_ test
        |_ java
            |_ org.example
               |_ pages
                  |_ P01_register
                  |_ P02_login
                  |_ P03_homePage
                  |_ pageBase
                |_ stepDefintions
                  |_D01_registerStepDef
                  |_D02_loginStepDef
                  |_D03_currenciesStepDef
                  |_D04_searchStepDef
                  |_D05_hoverCategoriesStepDef
                  |_D06_homeSlidersStepDef
                  |_D07_followUsStepDef
                  |_D08_wishlistStepDef
                  |_Hooks
                |_testRunner
                  |_runners
    target
    pom.xml
```

### There are 2 important groups of files to be placed to create a test:

1.Feature
  - Can be found under: src/main/resources/features
      - Written in Gherkin language and mirroring business scenarios using a readable and accessible language for everybody.

2.stepDefinitions
  - Can be found under: src/test/java/org.example/stepDefintions
      - They are written in Java language and, they define what is supposed to be done for each of the steps from one business scenario described in the Feature file.
   
## How to run tests
1.There are 2 ways to run tests locally:

2.Opening the feature from the features file:
  - clicking in the play button (at left) of the feature or of the scenario. 
  - Using the testRunner to run and generate the report needed(based on configurations).

### Aside from these, we also have some other folders and/or files important to keep the project working:
  - pom.xml
      - As this is a Maven project, which is base on the concept of a Project Object Model (POM), we must have a pom.xml file to manage all the required dependencies and plugins
  - target
      - This is a folder which contains our code (after packaging it) and our reports
      - The report is located under the target file as "cucumber.html"
## ScreenShots:
<img width="827" alt="image" src="https://github.com/NouranAhmedk/FinalTestingProject/assets/105202599/81aa3098-f1f4-407b-a865-0b10bd20f538">
<img width="737" alt="image" src="https://github.com/NouranAhmedk/FinalTestingProject/assets/105202599/af2711ce-6f8f-4f3a-95eb-5cbe125a7840">

## Test Execution Report:
<img width="1277" alt="image" src="https://github.com/NouranAhmedk/nopcommerce-testing-main/assets/105202599/67d69b6c-0ec0-48db-bb77-c6926d9ecdfa">








