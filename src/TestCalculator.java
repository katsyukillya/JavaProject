
public class TestCalculator {

    public static void main(String[] args) {

        OOPCalculator calc = new OOPCalculator();
        while (calc.askCalcChoice() != 5) { // it will set choice
            calc.askTwoValues(); // it will set two values
            calc.displayResults(); // do calculation, display result
            // and wait on press enter key
        }
        calc.displayBye(); 	// thanks the user for using and waits for press
        					// enter key
    }

}