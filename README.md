# Air Traffic Analysis in Poland

## 🎯 Project Goal
The goal of this project is to analyze data on the number of passengers served at Polish airports in international traffic. The data comes from public sources and enables an analysis of passenger trends by destination city, year, and time periods.

The project utilizes **Java Streams, Collections, and Generics** for processing and analyzing data loaded from a CSV file.

---

## 📂 Project Structure

```
📦 flight-analysis
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┣ 📂 model
 ┃ ┃ ┃ ┃ ┣ 📄 FlightRecord.java
 ┃ ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┃ ┣ 📄 FlightDataLoader.java
 ┃ ┃ ┃ ┃ ┣ 📄 FlightDataAnalyzer.java
 ┃ ┃ ┃ ┣ 📂 util (if necessary)
 ┃ ┃ ┃ ┣ 📄 Main.java
 ┃ ┣ 📂 test
 ┃ ┃ ┣ 📄 FlightDataAnalyzerTest.java
 ┣ 📂 resources
 ┃ ┣ 📂 input
 ┃ ┃ ┣ 📄 air_traffic.csv
 ┃ ┣ 📂 output
 ┣ 📄 README.md
 ┣ 📄 pom.xml (if using Maven)
 ┣ 📄 build.gradle (if using Gradle)
```

---

## 🛠️ Technologies
- **Java 17+**
- **OpenCSV Library** for parsing CSV files
- **Java Streams** for data processing and analysis
- **JUnit 5** for unit testing (optional)

---

## 📝 Data Structure
The CSV file contains the following columns:
- `variable_name` – description (not used)
- `traffic_type` – specifies the type of traffic (e.g., international)
- `country` – destination city
- `year` – data year
- `time_period` – e.g., first half of the year
- `passenger_count` – number of passengers
- `market_share_[percent]` – market share (optional)

---

## 🧑‍💻 Classes and Their Functionality

### 📌 `model.FlightRecord`
Data model representing a single entry from the CSV file.
- Should contain fields corresponding to CSV data.
- Should have a constructor, getters, and setters.

### 📌 `service.FlightDataLoader`
Class responsible for loading the CSV file.
- A method to read the CSV file and convert data into `FlightRecord` objects.
- Error handling in case of file issues.

### 📌 `service.FlightDataAnalyzer`
Class responsible for data analysis.

Example methods:
- `totalPassengersByYear(int year)`: Returns the total number of passengers for a given year.
- `busiestDestination(int year)`: Returns the city with the highest number of passengers for a given year.
- `passengerTrendsByCity(String city)`: Returns passenger trends for a specific city over the years.

### 📌 `Main`
Main application class.
- Loads data from the CSV file.
- Calls analysis methods and presents results to the user.

---

## 📌 Possible Extensions
- 📊 Data visualization – export results to CSV, PDF, or charts.
- 📅 Seasonal analysis – comparison of results for different time periods.
- 🌍 Market share analysis – examining how the share of a particular city changes in the overall market.

---

## 🚀 How to Run the Project?
1. Download the CSV file with data and place it in the `resources/input/` directory.
2. Compile the code using an IDE (IntelliJ IDEA, Eclipse) or a build tool (Maven/Gradle).
3. Run `Main.java`.

---

## 📌 Data Source
The data is sourced from **[dane.gov.pl](https://dane.gov.pl/pl/dataset/3374%2Cruch-lotniczy-w-polsce-przewozy-pasazerskie-operac)**.

---

