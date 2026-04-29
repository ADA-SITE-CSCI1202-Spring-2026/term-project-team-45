# Running The Code

## First Method: Jar File (Recommended)

### 1) Download the zip file from Github and extract the files
### 2) Open a terminal session in the root directory (term-project-team-45, where the jar file is located at)
### 3) Run the command "java -jar term-project-team-45.jar"
### 4) Enjoy the program!

## Second Method: Manual Compilation

### 1) Download the zip file from Github and extract the files
### 2) Open a terminal session in the "src/main/java" subdirectory (directory that contains the prj folder)
### 3) Run the command "javac -d out prj/*.java" to compile all java files
### 4) Finally run the command "java -cp out prj.Main" to start the program
### 5) Enjoy the program!

# Save File

## The save file is saved in the Current Working Directory (Usually the same directory the program is run from)
## e.g when you run the "java -cp out prj.Main" command from the "src/main/java" and save, the save file will be created in "src/main/java"
## e.g when you run the "java -jar term-project-team-45.jar" command from the same directory as the jar file is in and save, the save file will be created in the same directory