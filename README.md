##Woohoo Offer SDK Sample Project

This sample is build for with AndroidStudio or IntelliJ Idea 13 but can be used with Eclipse as well.

### Steps before starting:

Register an account in the [woohoo developer section](http://woohoo-mobile.com/developer-area/registration/).

Make sure you have installed the Play Services Library and the Support Library.

### Android Studio and Idea Users

 * Download and extract the [WoohooSDK](http://woohoo-mobile.com/developer-area/downloads/) into the Sample Project.
 * Open the Project into Android Studio (select the build.gradle file)
 * Build and run the Application.

**Important: The Android Support Repository and the Play Services Repository have to be installed with the SDK manager**

###Eclipse Users
**Important: when importing projects please copy them to your workspace so the pre-configured paths still work.**

* Import the woohoo-example project into your workspace.
* [Download](http://woohoo-mobile.com/developer-area/downloads/) and extract the WoohooSDK into your workspace and import it as Project
* Import the Play Services Library Project into your workspace
* Import the AppCompat-v7 Project into your workspace
* Copy the the content of the asset folder of the woohoo-sdk library Project into the asset folder of the main project
* Now you could start and use the Application now

*Additional Info*
 * The Play Services library Project can be found at $ANDROID-SDK/extras/google/google_play_services/libproject/
 * The AppCompat-v7 library Project can be found at $ANDROID-SDK/extras/android/support/v7/appcompat/

### Command line
 * Download and extract the [WoohooSDK](http://woohoo-mobile.com/developer-area/downloads/) into the Sample Project.
 * Build and install the sample with ```./gradlew installDebug```

 For more information visit the [woohoo mobile develeoper section](http://woohoo-mobile.com/developer-area/)