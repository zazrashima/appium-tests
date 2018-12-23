# appium-tests

This repository contains basic tests to verify Search feature of Wikipedia Android application:
- Verify search results contain relevant articles.
- Verify search results should be empty.

Test reports are generated in `ExtentReports` folder automatically. In case failed tests, immediate screenshots are captured and displayed in the report as well.

## System Requirements
Android
* Mac OSX or Windows or Linux
* Android SDK ≥ 16

JDK 8+<br/>
Maven 3.3+

## Installation
* JDK : https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html
* Maven: https://maven.apache.org/install.html
* Android SDK: https://developer.android.com/studio/install.html
* Appium: http://appium.io/docs/en/about-appium/getting-started/

## Setting up
Appium desired capabilities to start tests are initialized through [config.json](https://github.com/zazrashima/appium-tests/blob/master/src/test/resources/config.json) file. Change [deviceName](https://github.com/zazrashima/appium-tests/blob/dc9492f4243bf9e36da0712c7c7385b4ce8fd38e/src/test/resources/config.json#L3) and [platFormVersion](https://github.com/zazrashima/appium-tests/blob/dc9492f4243bf9e36da0712c7c7385b4ce8fd38e/src/test/resources/config.json#L4) value to map with the device under test.

## Run tests
Execute maven command to run tests from the project root:<br/>
`mvn test`
