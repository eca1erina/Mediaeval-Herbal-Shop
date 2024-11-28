package herbshop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Herb> readHerbsFromJson(String FILE_PATH) {
        File file = new File(FILE_PATH);
        List<Herb> herbList = new ArrayList<>();

        if (file.exists()) {
            try {
                herbList = objectMapper.readValue(file, new TypeReference<List<Herb>>() {});
            } catch (IOException e) {
                System.out.println("Error reading JSON file: " + e.getMessage());
            }
        } else {
            System.out.println("No JSON file found. Returning an empty list.");
        }

        return herbList;
    }

    public static void writeHerbsToJson(List<Herb> herbs, String FILE_PATH) {
        try {
            objectMapper.writeValue(new File(FILE_PATH), herbs);
            System.out.println("Herb list has been written to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error writing to JSON file: " + e.getMessage());
        }
    }
}
