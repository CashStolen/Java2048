# Java 2048

A simple implementation of the classic **2048 game** using **Java + Swing**.

## Project Structure

Java2048/
├── src/
│ ├── MainFrame.java
│ └── Procedure.java
├── images/
│ └── *.png
└── README.md

## Run

### Compile
javac -d out src/*.java
### Run
cd out
java Procedure

> Note: Image resources use **relative path `images/`**,  
> so please run the program from the **project root directory**.

## Description
- Pure Java implementation  
- Classic 4×4 board  
- Uses Swing for UI  
- Tile images stored in `/images`  
- Core logic in `Procedure.java`

## Author
CashStolen
