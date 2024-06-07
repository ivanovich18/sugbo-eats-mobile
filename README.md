# Sugbo Eats

Sugbo Eats is a mobile application designed to simplify the process of reserving tables at restaurants in Cebu. Built using Java and Firebase, the app allows users to browse restaurants and make reservations with ease.

## Features

- **Browse Restaurants**: Users can browse a list of participating restaurants in Cebu.
- **View Availability**: Users can view available time slots for each restaurant.
- **Make Reservations**: Users can reserve tables directly through the app.
- **User Authentication**: Secure user authentication using Firebase Authentication.
- **Real-Time Database**: Store and retrieve reservation data in real-time using Firebase Realtime Database.
- **Push Notifications**: Receive notifications for reservation confirmations and reminders.

## Technologies Used

- **Java**: The primary programming language used for the app development.
- **Firebase Authentication**: For secure user sign-in and sign-up.
- **Firebase Realtime Database**: To store and manage reservation data.
- **Firebase Cloud Messaging**: For push notifications.
- **Android Studio**: The IDE used for developing the app.

## Screenshots

![image](https://github.com/ivanovich18/sugbo-eats/assets/88656474/43529fe0-983d-4f75-a0b0-fc91647cd582)

## Installation

To get a local copy up and running, follow these steps:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/ivanovich18/sugbo-eats.git
    ```

2. **Open the project in Android Studio:**
   - Open Android Studio.
   - Click on `Open an existing project`.
   - Navigate to the cloned repository and select it.

3. **Set up Firebase:**
   - Create a new project on the [Firebase Console](https://console.firebase.google.com/).
   - Add an Android app to your Firebase project.
   - Follow the instructions to download the `google-services.json` file.
   - Place the `google-services.json` file in the `app` directory of your project.

4. **Install dependencies:**
   - Ensure you have the necessary dependencies specified in the `build.gradle` file.
   - Sync the project with Gradle files.

## Usage

1. **Register/Login:**
   - Users need to create an account or log in to make reservations.

2. **Browse Restaurants:**
   - Users can browse the list of available restaurants.

3. **Make Reservations:**
   - Select a restaurant, choose a time slot, and make a reservation.

4. **Manage Reservations:**
   - View and manage your reservations from the user profile section.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
