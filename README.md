# Car Dealership
An application that tracks cars in a dealership.

<!-- HOW TO USE THIS TEMPLATE
     Save it as README.md at the root of your project, next to pom.xml. Replace every comment like this one
     with your own text; comments do not show on GitHub, so what you leave untouched shows as an empty heading.
     Two sections are optional and say so: Class Diagram, and Data and configuration. When your project does not
     need one, delete the whole section, heading included. Every other section stays. -->

<!-- One sentence under the title: what the app is, for whom.
     Example: A console app that keeps a store's inventory in a csv file and lets a clerk search it. -->

## Description of the Project
- A java console-based software application that allows users to manage a dealership's vehicle inventory. Users 
can browse available vehicles, search for specific vehicles with unique attributes, add a new vehicle, remove and other features.

<!-- Three to five sentences. What the application does, who uses it, what problem it solves.
     Write it for someone who has never seen the workbook: a recruiter, a classmate, you in six months. -->

## Features

<!-- One bullet per thing the app can do, in the order of your menu. Mark bonuses.
     For an API (Capstone 3), one line per endpoint instead: method, path, what it does.
     Be honest: list what works. If something is half done, say so under Future Work instead.
     Example:
     - Shows every product in the store
     - Searches products by name (bonus) -->

- find vehicles by price
- find vehicles by make/model
- find vehicles by year
- find vehicles by color
- find vehicles by mileage
- find vehicles by type
- list all available vehicles
- add a vehicle
- remove a vehicle


## Setup

### Prerequisites

- Java 17 (Amazon Corretto), the version used in class.
- IntelliJ IDEA Community Edition: <https://www.jetbrains.com/idea/download/>

### Running the application

1. Clone this repository, or download it as a zip and unzip it.
2. In IntelliJ: File > Open, pick the project folder (the one that holds `pom.xml`), press Open.
3. Wait for IntelliJ to finish indexing (progress bar at the bottom).
4. Open `src/main/java/com/pluralsight/YourMainClassName.java`. <!-- replace YourMainClassName with the class that has main -->
5. Right-click inside the file and choose Run 'YourMainClassName.main()'.

### Data and configuration

<!-- OPTIONAL. Anything the program needs that is not code: data files and where they must sit, files the
     program creates, a database script to run first, a settings file to edit (connection, port).
     If there is nothing, delete this subsection, heading included.
     Example:
     - `inventory.csv` sits at the project root, next to `pom.xml`. The program reads it at start.
     - `logs.txt` is created by the program at the project root on the first run. -->

- `inventory.csv` sits at the project root, next to `pom.xml`. The program reads it at start.

## Technologies Used

- Java 17
- IntelliJ IDEA
<!-- Add anything else you used: a library, Maven plugins, an external tool. For a console app this list is short. That is fine. -->

## Demo

<!-- Pictures of the app running: the console for a console app, Insomnia or Swagger for an API.
     Screenshots are enough; a GIF is a bonus.
     1. Create a folder named `images` at the project root, next to `pom.xml`.
     2. Take screenshots of the app in the IntelliJ console (the menu, one feature, one error message):
          Windows: Win + Shift + S, drag a rectangle, then paste into Paint and save as PNG, or open the
                   notification and save. Save into the `images` folder.
          Mac:     Shift + Cmd + 4, drag a rectangle. The file lands on the Desktop; move it into `images`.
     3. Name the files by what they show: `images/menu.png`, `images/search.png`.
     4. Reference each one below with a relative path. No spaces in file names.
     5. Commit the images with the rest of your work (Git > Commit shows them as unversioned files: tick them).
     Optional GIF: LICEcap (free, Windows and Mac, <https://www.cockos.com/licecap/>) records a region of the
     screen straight to a .gif. Keep it under 10 seconds and under 10 MB, save it into `images`. -->

![Main menu](images/![Menu gif 2026-11-17 045603.gif](images/Menu%20gif%202026-11-17%20045603.gif) )

![One feature in action](images/![Feature gif 2026-11-17 045740.gif](images/Feature%20gif%202026-11-17%20045740.gif) )

## A piece of code I am proud of

<!-- Paste one short block of your own code (5 to 15 lines) between the three backticks, then write two
     or three sentences: what it does and why you chose to write it that way. This is what you show on
     demo day and what you talk about in an interview. -->

```java

Dealership dealership = null;
while ((line = reader.readLine()) != null){
    String[] tokens = line.split("\\|");

    if(dealership == null){
        dealership = new Dealership(tokens[0], tokens[1],tokens[2]);
    }else {
        int vin = Integer.parseInt(tokens[0]);
        int year = Integer.parseInt(tokens[1]);
        String make = tokens[2];
        String model = tokens[3];
        String vehicleType = tokens[4];
        String color = tokens[5];
        int odometer = Integer.parseInt(tokens[6]);
        BigDecimal price = new BigDecimal(tokens[7]);

        dealership.addVehicle( new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));}

}
    reader.close();
```
I chose this code because it was tricky to figure out how to parse and store the values in the correct fields. 
The loop goes through the "csv.file", line. Split, splits the values, and then we assign each value to the correct field.


## Future Work

<!-- What you would add or fix next, one bullet each. Unfinished bonuses belong here. -->

- modify the UserInterface with colors and appropriate graphics.
- add a table for the menu
- handling exceptions better without exiting the methods.

## Resources

<!-- What helped you: the workbook, the week's hub pages, a tutorial, a documentation page. Real links. -->

- Java YearUp Fall 2026 hub: <https://raymaroun.github.io/yearup-java-fall2026/>


## Author

<!-- Your name and, if you like, your GitHub profile link. For a team workshop, one line per person with what each one built. -->

- Kaleab Tsegaye

## Thanks

<!-- Optional. The people who helped: the instructor, a classmate who debugged with you, a mentor. -->

- Thank you to Raymond Maroun for guidance and support.