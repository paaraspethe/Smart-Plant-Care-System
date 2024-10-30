# Smart Plant Care Management System 🌿

A comprehensive application for managing and automating plant care, featuring both console-based and JavaFX GUI interfaces. Monitor your plants' watering schedules, track their health, and never miss a watering day again!

## Features ✨

- **Plant Management**
  - Add new plants with detailed information
  - Track watering schedules automatically
  - Monitor plant health and status
  - View plants requiring immediate attention

- **Dual Interface**
  - Modern JavaFX GUI with FXML support
  - Traditional console-based interface
  - Responsive design with CSS styling

- **Database Integration**
  - Persistent storage using MySQL
  - Hibernate ORM integration
  - Efficient data management

## Prerequisites 📋

Before running the application, ensure you have the following installed:

- Java 17 or higher
- Maven for dependency management
- MySQL database server
- Git (for cloning the repository)

## Installation 🚀

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/plant-care-management.git
   cd plant-care-management
   ```

2. **Database Setup**
   - Create a new MySQL database:
     ```sql
     CREATE DATABASE plantcare_db;
     ```
   - Configure database connection in `src/main/resources/hibernate.cfg.xml`

3. **Install Dependencies**
   ```bash
   mvn clean install
   ```

## Usage 💻

### Console Application
Run the console-based version:
```bash
mvn exec:java -Dexec.mainClass="com.example.myapp.PlantCareSystemApp"
```

### GUI Application
Launch the JavaFX interface:
```bash
mvn exec:java -Dexec.mainClass="com.example.myapp.MainAppUI"
```

## Project Structure 📁

```
Smart Plant Care Management System
│
├── src
│   ├── main
│   │   ├── java/com.example.myapp
│   │   │   ├── AddPlantUI.java
│   │   │   ├── MainAppUI.java
│   │   │   ├── MainAppUIController.java
│   │   │   ├── Plant.java
│   │   │   ├── PlantCareManager.java
│   │   │   ├── PlantCareSystemApp.java
│   │   │   ├── PlantsNeedingWaterUI.java
│   │   │   └── ViewAllPlantsUI.java
│   │   └── resources
│   │       ├── hibernate.cfg.xml
│   │       ├── MainAppUI.fxml
│   │       └── style.css
│   └── test
└── pom.xml
```

## Configuration ⚙️

### Database Configuration
Update `hibernate.cfg.xml` with your MySQL credentials:
```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/plantcare_db</property>
<property name="hibernate.connection.username">your_username</property>
<property name="hibernate.connection.password">your_password</property>
```

### Maven Dependencies
Ensure your `pom.xml` includes all required dependencies:
- JavaFX
- Hibernate
- MySQL Connector
- JUnit (for testing)

## Contributing 🤝

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Troubleshooting 🔧

### Common Issues

1. **Database Connection Failed**
   - Verify MySQL service is running
   - Check database credentials in `hibernate.cfg.xml`
   - Ensure database exists and is accessible

2. **JavaFX Launch Error**
   - Confirm JavaFX dependencies in `pom.xml`
   - Verify Java version compatibility
   - Check FXML file syntax

## License 📝

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments 🙏

- JavaFX Community
- Hibernate Documentation
- Maven Central Repository

---

Made with ❤️ by Paras Pethe

For questions or support, please open an issue in the repository.
