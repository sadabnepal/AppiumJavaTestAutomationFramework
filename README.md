<h2 align="center"> Mobile Test Automation Framework | Appium | Java</h2>


### Requirements:
[![Java](https://img.shields.io/badge/-JDK-%23007396?logo=java&logoColor=black&)](https://www.oracle.com/java/technologies/downloads/)
[![Maven](https://img.shields.io/badge/-Apache%20Maven-black?logo=Apache%20Maven&logoColor=C71A36)](https://maven.apache.org/download.cgi)
[![NodeJs](https://img.shields.io/badge/-NodeJS-%23339933?logo=npm)](https://nodejs.org/en/download/)
[![Appium-Inspector](https://img.shields.io/badge/-Appium%20Inspector-662d91?logo=appium&logoColor=black)](https://github.com/appium/appium-inspector/releases)
[![AppiumDriver](https://img.shields.io/badge/-Appium%20Driver-662d91?logo=Appium&logoColor=white)](https://appiumpro.com/editions/122-installing-appium-20-and-the-driver-and-plugins-cli)
[![AndroidStudio](https://img.shields.io/badge/-Android%20Studio-3DDC84?logo=android-studio&logoColor=white)](https://developer.android.com/studio)

### Getting Started:

#### Clone repository:
```bash
git clone https://github.com/sadabnepal/AppiumJavaTestNGFramework.git
Navigate to `AppiumJavaTestNGFramework`
```
#### Setup/Create virtual device on Android studio:
```
platformName: Android
platformVersion: 11
deviceName: Pixel 3
```
#### Install
```
npm i -g appium
npm i -g appium-doctor
```
#### Verify appium drivers:
```
appium driver list
```
uiautomator2 should be installed for android and xcuitest for ios<br/>
![appium_driver_list.png](sample/appium_driver_list.png)

If drivers are not installed then run below command as required:
```
appium driver install uiautomator2  [for android]
appium driver install xcuitest [for ios]
```

#### Verify all pre-requisite for android:
```
npm run android-doctor
```
all options should be green checked as shown in below image to start.
![android_config.png](sample/android_config.png)
