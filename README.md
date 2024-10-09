Personal Task Manager

A simple mobile app built with Kotlin for Android that helps users manage their daily tasks efficiently. 
The app provides features for creating, viewing, updating, and deleting tasks, ensuring seamless task management with data stored locally for persistence.

Table of Contents


Project Overview


The Personal Task Manager app allows users to efficiently manage their daily tasks with the ability to:

  Add new tasks with a title, description, due date, priority, and completion status.
  
  View a list of tasks added by the user.
  
  Edit or delete tasks as needed.
  
  Persist task data locally using a database to ensure data is saved even when the app is closed.
  
  The app utilizes the Room Persistence Library for local data storage and follows best practices for Android development using Kotlin and modern architecture components.
  
Features

   Task Management
   
  Create a Task: Users can add new tasks with fields for title, description, due date, priority (e.g., Low, Medium, High), and completion status (Pending/Completed).
  
  View Tasks: The app displays a list of tasks on the main screen.
  
  Update or Add new Tasks: Users can tap on a task to edit its details or add new task.
  
  Delete Tasks: Users can swipe a task to remove it from the list.
  
  Mark as Completed: Tasks can be marked as completed or pending via a checkbox.

  Theme : Dark and light is added as the feature for users flexibility.
  
  Local Database: Task data is stored locally using Room, a SQLite object-mapping library. This ensures data persists even after the app is closed.
  
  Automatic Data Sync: The app keeps the list of tasks up to date with changes, automatically updating the UI when a task is modified, added, or deleted.

Setup Instructions

Prerequisites

   Android Studio: Make sure you have the latest stable version of Android Studio installed.
   Java Development Kit (JDK): Ensure you have JDK 8 or higher installed.
Installation

   Clone the Repository

bash
Copy code
git clone https://github.com/12-Ravi/Task-Manager
Open the Project in Android Studio

Launch Android Studio and select "Open an existing project."
Navigate to the directory where you cloned the repository and open it.
Build the Project

Allow Gradle to sync and build the project.

Make sure the required dependencies are downloaded.
Run the App

Connect an Android device or use an emulator.

Click the "Run" button in Android Studio to install and launch the app on your selected device.

Key Design Decisions

1. Architecture

     The app follows the MVVM (Model-View-ViewModel) architectural pattern to separate concerns:
        Model: Represents the data layer. Uses Room to manage database operations.
        View: The user interface. Uses data binding to observe LiveData from the ViewModel.
        ViewModel: Acts as a communication center between the Model and View. Handles data operations and business logic.
   
2. Room Persistence Library for Data Storage

    Room was chosen for local data persistence due to its ease of use, integration with LiveData, and built-in support for SQLite.
    It allows seamless management of database operations while following best practices for data storage on Android.
   
3. Data Binding and LiveData

    Using Data Binding and LiveData ensures the UI remains up-to-date with the data without the need for manual updates.
    The reactive nature of LiveData allows automatic updates when data changes.
   
4. Kotlin Coroutines for Background Tasks
   
    Kotlin Coroutines are used to perform database operations in the background, ensuring a smooth user experience by keeping the main thread unblocked.
   
Architecture and Code Structure

1. Data Layer

  Entities: Define the Task data class, which represents the database table.
  DAO (Data Access Objects): Interfaces that define methods for accessing the database (e.g., insertTask(), updateTask(), deleteTask()).
  Room Database: Manages the local database, providing a singleton instance accessible throughout the app.
  
2. Domain Layer

  Repositories: Serve as the data sources for the ViewModel, abstracting the data access from the underlying database.
  
3. Presentation Layer
   
  ViewModel: Manages the data for the UI and business logic.
  UI (Activity/Fragment): Contains the logic for displaying data and user interactions.


Dependencies


Kotlin: 
      The main programming language for the app.
AndroidX Libraries:  
      For backward compatibility and modern Android components.
Room Persistence Library: 
      To handle local data storage.
LiveData and ViewModel: 
      To implement the MVVM architecture.
Data Binding: 
      To bind the UI components in the XML layout files to the ViewModel.
Kotlin Coroutines: 
      To perform background operations.


Screenshots 



<img width="239" alt="Screenshot 2024-10-10 at 12 47 38 AM" src="https://github.com/user-attachments/assets/5b20edff-ae1f-416c-82e2-dae2a717601f">
<img width="242" alt="Screenshot 2024-10-10 at 12 46 17 AM" src="https://github.com/user-attachments/assets/c94aca31-fced-4488-b62a-f2b5b9763ca2">
<img width="246" alt="Screenshot 2024-10-10 at 12 45 27 AM" src="https://github.com/user-attachments/assets/91770d9f-99a6-4df6-b7c3-f2267f532fe3">
<img width="244" alt="Screenshot 2024-10-10 at 12 47 46 AM" src="https://github.com/user-attachments/assets/6b1014a9-42ed-4bec-bb2e-01b8693dbefe">
<img width="244" alt="Screenshot 2024-10-10 at 12 45 06 AM" src="https://github.com/user-attachments/assets/cc8ba37c-3225-4b1a-9e09-06357934643d">
<img width="246" alt="Screenshot 2024-10-10 at 12 45 18 AM" src="https://github.com/user-attachments/assets/2697c8b3-dcc0-47ad-8223-b8e612eb9816">




