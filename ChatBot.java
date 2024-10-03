import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        IntentClassifier classifier = new IntentClassifier("training_data.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I am an advanced chatbot. Type 'exit' to quit.");

        while (true) {
            String userInput = scanner.nextLine().toLowerCase();
            if (userInput.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            String intent = classifier.classify(userInput);
            String response = getResponse(intent);
            System.out.println(response);
        }
        scanner.close();
    }

    private static String getResponse(String intent) {
        switch (intent) {
            case "greeting":
                return "Hi there! How can I help you?";
            case "goodbye":
                return "Goodbye! Have a great day!";
            case "thanks":
                return "You're welcome!";
            case "how are you":
                return "I'm just a program, but I'm doing well!";
            case "do you know hindi":
                return "no";
            default:
                return "I'm not sure how to respond to that.";
        }
    }
}