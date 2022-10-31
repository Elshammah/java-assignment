public class GuessNumber {

    private int randomNumber;
    private int maxValue;
    private int minValue;
    private int numberOfTries;
    private int[] guessHistory;


    public GuessNumber(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        randomNumber = (int) (Math.random() * maxValue) + minValue;
        numberOfTries = 0;
        guessHistory = new int[20];
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        System.out.println("Guess the number between " + minValue + " and " + maxValue + ": ");
        int guess;
        do {
            guess = scanner.nextInt();
            numberOfTries++;
            if (guess > randomNumber) {
                System.out.println("Too high, try again.");
            } else if (guess < randomNumber) {
                System.out.println("Too low, try again.");
            } else {
                System.out.println("You guessed it! It took you " + numberOfTries + " tries.");
            }
            if (numberOfTries <= 20) {
                guessHistory[numberOfTries - 1] = guess;
            }
        } while (guess != randomNumber);
        scanner.close();
        printGuessHistory();
    }

    public void reset() {
        randomNumber = (int) (Math.random() * maxValue) + minValue;
        numberOfTries = 0;
        for (int i = 0; i < guessHistory.length; i++) {
            guessHistory[i] = 0;
        }
    }

    public void printGuessHistory() {
        System.out.println("Your guess history: ");
        for (int i = 0; i < guessHistory.length; i++) {
            if (guessHistory[i] != 0) {
                System.out.print(guessHistory[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(0, 100);
        game.play();
        game.reset();
        game.play();
    }
}
