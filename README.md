# Sugbo Eats Mobile

Sugbo Eats is a mobile application designed to simplify the process of reserving tables at restaurants in Cebu. Built using Java and Firebase, the app allows users to browse restaurants and make reservations with ease.

## Features

- **Browse Restaurants**: Explore a list of participating restaurants in Cebu with detailed information.
- **View Availability**: Check available time slots for each restaurant to plan your visit.
- **Make Reservations**: Reserve tables directly through the app with just a few taps.
- **Real-Time Database**: Utilize Firebase Realtime Database to store and retrieve reservation data instantly.

## Technologies Used

- **Java**: The primary programming language for Android app development.
- **Firebase Realtime Database**: Manages and stores reservation data efficiently.
- **Android Studio**: Integrated Development Environment (IDE) used for building and testing the app.

## Screenshots

![image](https://github.com/user-attachments/assets/28eaf830-fc50-421d-b5d0-dd4e5bd6bab5)

## Installation

To get a local copy up and running, follow these steps:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/ivanovich18/sugbo-eats-mobile.git
    ```

2. **Open the project in Android Studio:**

   - Launch Android Studio.
   - Click on **Open an existing project**.
   - Navigate to the cloned repository and select it.

3. **Set up Firebase:**

   - Create a new project on the [Firebase Console](https://console.firebase.google.com/).
   - Add an Android app to your Firebase project.
   - Follow the instructions to download the `google-services.json` file.
   - Place the `google-services.json` file in the `app` directory of your project.

4. **Install dependencies:**

   - Verify that you have the necessary dependencies specified in the `build.gradle` file.
   - Sync the project with Gradle files to ensure everything is set up correctly.

## Managing API Keys and Sensitive Information

To manage sensitive information like API keys and project configuration in your `google-services.json` file securely, follow these steps:

1. **Store Sensitive Data in Environment Variables**

   Set your important data as environment variables on your build machine or CI/CD system. For local development, you can use a `.env` file.

   - Create a `.env` file in the root directory of your project.
   - Add your Firebase credentials to the `.env` file:

     ```env
     FIREBASE_PROJECT_NUMBER=your_project_number
     FIREBASE_PROJECT_ID=your_project_id
     FIREBASE_STORAGE_BUCKET=your_storage_bucket
     FIREBASE_APP_ID=your_app_id
     FIREBASE_CLIENT_ID=your_client_id
     FIREBASE_API_KEY=your_api_key
     ```

2. **Modify Gradle Build Script**

   Update your `app/build.gradle` file to replace placeholders in your `google-services-template.json` file with actual environment variables:

   - Rename your existing `google-services.json` to `google-services-template.json` and replace sensitive values with placeholders:

     ```json
     {
       "project_info": {
         "project_number": "${FIREBASE_PROJECT_NUMBER}",
         "project_id": "${FIREBASE_PROJECT_ID}",
         "storage_bucket": "${FIREBASE_STORAGE_BUCKET}"
       },
       "client": [
         {
           "client_info": {
             "mobilesdk_app_id": "${FIREBASE_APP_ID}",
             "android_client_info": {
               "package_name": "com.bscpe3g.sugboeats"
             }
           },
           "oauth_client": [
             {
               "client_id": "${FIREBASE_CLIENT_ID}",
               "client_type": 3
             }
           ],
           "api_key": [
             {
               "current_key": "${FIREBASE_API_KEY}"
             }
           ],
           "services": {
             "appinvite_service": {
               "other_platform_oauth_client": [
                 {
                   "client_id": "${FIREBASE_CLIENT_ID}",
                   "client_type": 3
                 }
               ]
             }
           }
         }
       ],
       "configuration_version": "1"
     }
     ```

   - Add a custom Gradle task to replace placeholders in the `google-services-template.json` file with actual environment variables:

     ```gradle
     import org.apache.tools.ant.filters.ReplaceTokens

     android {
         // Other configurations...

         // Custom task to replace tokens in google-services-template.json
         task replaceGoogleServicesJson {
             doLast {
                 def templateFile = file('google-services-template.json')
                 def outputFile = file('google-services.json')

                 ant.filterset(id: 'tokens', tokens: [
                     'FIREBASE_PROJECT_NUMBER': System.getenv("FIREBASE_PROJECT_NUMBER"),
                     'FIREBASE_PROJECT_ID': System.getenv("FIREBASE_PROJECT_ID"),
                     'FIREBASE_STORAGE_BUCKET': System.getenv("FIREBASE_STORAGE_BUCKET"),
                     'FIREBASE_APP_ID': System.getenv("FIREBASE_APP_ID"),
                     'FIREBASE_CLIENT_ID': System.getenv("FIREBASE_CLIENT_ID"),
                     'FIREBASE_API_KEY': System.getenv("FIREBASE_API_KEY")
                 ])

                 ant.copy(file: templateFile, tofile: outputFile) {
                     filterchain {
                         filterset(refid: 'tokens')
                     }
                 }
             }
         }

         preBuild.dependsOn replaceGoogleServicesJson
     }
     ```

3. **Set Environment Variables**

   Ensure that the environment variables are set in your development environment or CI/CD pipeline. For local development, you can set them in your terminal session or use a `.env` file with a library like `dotenv` to load these automatically.

   Example of setting environment variables in your terminal:

   ```bash
   export FIREBASE_PROJECT_NUMBER=your_project_number
   export FIREBASE_PROJECT_ID=your_project_id
   export FIREBASE_STORAGE_BUCKET=your_storage_bucket
   export FIREBASE_APP_ID=your_app_id
   export FIREBASE_CLIENT_ID=your_client_id
   export FIREBASE_API_KEY=your_api_key

4. **Run the Build Process**

    When you build your project, the replaceGoogleServicesJson task will generate a google-services.json file with the correct values, keeping sensitive information out of your source control.

## Usage

1. **Browse Restaurants:**

   - Open the app and browse through the list of available restaurants in Cebu.

2. **Make Reservations:**

   - Select a restaurant, choose a suitable time slot, and make your reservation.

## Members

- Ronilo Jose Cabag
- Miles Dagle
- Aldrin Felices
- John Kevin Genon
- Ivan Suralta
- Rovic Tecson

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
