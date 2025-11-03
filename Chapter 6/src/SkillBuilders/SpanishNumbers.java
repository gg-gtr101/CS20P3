package SkillBuilders;

public class SpanishNumbers 
{

	public static void main(String[] args) 
	{
		System.out.println("Spanish Numbers (1 through 10) \n");

        for (int i = 1; i <= 10; i++) {
            displaySpanishNumber(i); 
        }
    }

    public static void displaySpanishNumber(int number) {
        String spanishWord;

        if (number == 1) {
            spanishWord = "uno";
        } else if (number == 2) {
            spanishWord = "dos";
        } else if (number == 3) {
            spanishWord = "tres";
        } else if (number == 4) {
            spanishWord = "cuatro";
        } else if (number == 5) {
            spanishWord = "cinco";
        } else if (number == 6) {
            spanishWord = "seis";
        } else if (number == 7) {
            spanishWord = "siete";
        } else if (number == 8) {
            spanishWord = "ocho";
        } else if (number == 9) {
            spanishWord = "nueve";
        } else if (number == 10) {
            spanishWord = "diez";
        } else {
            spanishWord = "Error: Number out of range (1-10)";
        }

        System.out.println("Number " + number + ": " + spanishWord);    
        }
}
