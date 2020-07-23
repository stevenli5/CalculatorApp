# Calculator App

#### Description
A calculator app designed and programmed in Android Studio, as part of assignment 5 for the SEG2105 course at the University of Ottawa.  
This calculator contains many new implementations compared to the initially commited version.

#### Key Additions/Changes
- New sin, cos, tan buttons
- Dark Mode
- User Manual
- Completely redesigned user interface
- New log, ln, square root, exponential, and factorial buttons
- New negative and pi buttons
- New symbol viewer, to display what operation the user chose

### Video Walkthrough
https://www.youtube.com/watch?v=BRvh4-MM3KI

### Architecture
All calculator functions can be found in /app/src/main/java/com/example/simple_calculator/MainActivity.java  
Calculator layout can be found in /app/src/main/res/layout/activity_main.xml  
User Manual can be found in /app/src/main/res/layout/activity_user_manual.xml  

Here is a basic unfinished state machine from Umple. Issues were ran into and so the final product was drawn out by hand.  
![image](https://user-images.githubusercontent.com/60322211/88244459-f30f9480-cc61-11ea-8467-b629819d4a05.png)  
![image](https://user-images.githubusercontent.com/60322211/88244358-92805780-cc61-11ea-94c7-04eafdd6d638.png)  

### Future Implementations
- Backspace button, where the user can delete 1 single digit at a time (in MainActivity.java)  
- Cubic root/x root, where the user can root any number to any number (in MainActivity.java)  
- Ability to switch from radians (RAD) to degrees (DEG) (in MainActivity.java)  
- Allow for more operations before calculating a result (in MainActivity.java)  

### User Stories
1. A student wants to determine what 2 to the power of 3 is. They input "2", "yˣ", "3", "=", such that the app outputs the answer, "8.0".  
2. A math teacher wants divide "42" by "0", but runs into "Error 1". They check the user manual and discovers that no number is divisible by "0".  
3. A cashier wants to determine the taxable amount on a $2 purchase. They input "2", "x", ".13", "=", such that the app outputs the answer, "0.26".  

### Test Cases

1. Determine the log of 10.  
Input "10" in the display and press "log".  
Expected Result: 1.0  
Actual Result: 1.0

2. Determine the factorial of 9.  
Input "9" in the display and press "!".  
Expected Result: 362880.0  
Actual Result: 362880.0

3. Determine the result of sin(4).  
Input "4" in the display and press "sin".  
Expected Result: -0.7568024953079282  
Actual Result: -0.7568024953079282

4. Determine the result of 99 / 0.  
Input "99" in the display, press "÷", press "0", and press "=".  
Expected Result: Error 1  
Actual Result: Error 1

5. Clear the Screen and Enable Dark Mode.  
Press "Clear and Enable Dark Mode".  
Expected Result and Actual Result:  
![image](https://user-images.githubusercontent.com/60322211/88239628-ecc5ec00-cc52-11ea-9a1d-e12ece1b180b.png)

### Credits
Dark Mode: https://www.youtube.com/watch?v=QhGf8fGJM8U  
Second Activity: https://codinginflow.com/tutorials/android/open-activity-on-button-click  
