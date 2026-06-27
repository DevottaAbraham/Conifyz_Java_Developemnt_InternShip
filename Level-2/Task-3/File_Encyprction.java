import java.util.Scanner;

public class File_Encyprction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("******** File Encryption / Decryption ********");
        System.out.println("1. Encrypt File");
        System.out.println("2. Decrypt File");

        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter File Name or Path: ");
        String fileName = sc.nextLine();

        File_EncryptionLogic logic = new File_EncryptionLogic();

        switch (choice) {

            case 1 -> logic.EncryptFile(fileName);

            case 2 -> logic.DecryptFile(fileName);

            default -> System.out.println("Invalid Choice");
        }

        sc.close();
    }
}