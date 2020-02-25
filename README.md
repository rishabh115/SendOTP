# SendOTP

SendOTP is an application that uses Nexmo under the hoods to send OTP, currently generated randomly,
to any contacts. It uses MVVM architecture as recommended by Google. Kotlin has been used as the
primary language for writing the project.

## Getting Started

_Follow these instructions to build and run the project_

1. Clone this repository.
2. Download the appropriate [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
for your system. We are currently on JDK 8.
3. [Install Android Studio](https://developer.android.com/sdk/index.html).
4. Import the project. Open Android Studio, click `Open an existing Android
   Studio project` and select the project. Gradle will build the project.
5. Get your API_KEY and API_SECRET by creating an account on [Nexmo developer portal](https://developer.nexmo.com/).
6. Use those values in ```Constants.kt``` file.
7. Build the project.
5. Run the app. Click `Run > Run 'app'`. After the project builds you'll be
   prompted to build or launch an emulator.

Following are the important points I kept in mind while developing the project:-
1) Followed standard naming convention for Kotlin's variable and XML widget ids.
2) Tried to maximise separation of concern by setting boundaries viz. ui, util, api, data and base
   subpackages.
3) Documented the code wherever necessary.
4) Base activity and base fragment for ensuring that any future changes can be easily blended in the
   app.
5) All the constants are in Constants.kt file.
6) Focused more on adaptable, modular, reusability and testable architecture rather than revamping
   the UI.
7) UI is minimal, monochrome and easy-to-understand interface metaphor.
8) Tried to keep third-party libraries to minimal (Retrofit, Stetho and CircleImageView).
9) I have tried and tested via mine Nexmo credentials. Please consider replacing it with yours, if any
   issue occurs with my credentials(like whitelisting any contacts).
10) Added validation for phone number.
11) You can add your own dummy contacts in contacts.json for testing various corner cases.
12) Minimum use of idiomatic Kotlin to improve readability.
13) Initial development cost of MVVM architecture is high for simple projects, but it facilitates
    smooth growth and adaptability over time.
14) Someone with basic knowledge of Kotlin and MVVM pattern can understand this code.
15) As Stetho has been integrated, you can open Chrome to inspect local db.
16) UI components are completely free of any business logic.
17) No hardcoding in XML.
18) UI are completely scalable across any form-factor of smart-phones.

Tested on:
Nokia 8.1(Android 10 OS)

Development enviroment:
Android Studio 3.5.0


