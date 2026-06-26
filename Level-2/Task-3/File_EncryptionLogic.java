import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class File_EncryptionLogic {

    public void EncryptFile(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String outputFile = fileName.replace(".txt", "_encrypted.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            while ((line = reader.readLine()) != null) {

                String encryptedLine = "";

                for (int i = 0; i < line.length(); i++) {

                    char ch = line.charAt(i);

                    char encryptedChar = (char) (ch + 1);

                    encryptedLine += encryptedChar;
                }

                writer.write(encryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File Encrypted Successfully.");
            System.out.println("Output File : " + outputFile);

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
    }

    public void DecryptFile(String fileName) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String outputFile = fileName.replace(".txt", "_decrypted.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            while ((line = reader.readLine()) != null) {

                String decryptedLine = "";

                for (int i = 0; i < line.length(); i++) {

                    char ch = line.charAt(i);

                    char decryptedChar = (char) (ch - 1);

                    decryptedLine += decryptedChar;
                }

                writer.write(decryptedLine);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File Decrypted Successfully.");
            System.out.println("Output File : " + outputFile);

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
    }
}