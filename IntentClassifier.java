import java.io.*;
import java.util.*;

public class IntentClassifier {
    private Map<String, List<String>> intents = new HashMap<>();

    public IntentClassifier(String trainingFile) {
        loadIntents(trainingFile);
    }

    private void loadIntents(String trainingFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(trainingFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String intent = parts[0].trim();
                List<String> examples = Arrays.asList(parts[1].trim().split(" "));
                intents.put(intent, examples);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String classify(String input) {
        for (Map.Entry<String, List<String>> entry : intents.entrySet()) {
            for (String example : entry.getValue()) {
                if (input.contains(example)) {
                    return entry.getKey();
                }
            }
        }
        return "unknown";
    }
}