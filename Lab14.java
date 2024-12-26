import java.io.*;

public class Lab14 {
    public static void main(String[] args) {
        try {
            String source = "src/main/resources/source.txt";
            String destination = "src/main/resources/destination.txt";
            copyToUpperCase(source, destination);
            System.out.println("Текст скопійований аперкейсом");

            String binaryFile = "src/main/resources/binaryFile.dat";
            byte checksum = checkSum(binaryFile);
            System.out.println("Контрольна сума байтів: " + checksum);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void copyToUpperCase(String source, String destination) throws IOException {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Шлях до файлу є null.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
        }
    }

    public static byte checkSum(String filename) throws IOException {
        if (filename == null) {
            throw new IllegalArgumentException("Шлях до файлу є null!");
        }

        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            byte checksum = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    checksum ^= buffer[i];
                }
            }

            return checksum;
        }
    }
}
