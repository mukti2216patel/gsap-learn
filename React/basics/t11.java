import java.io.*;

public class t11 {
    public static void main(String[] args) {
        // Use try-with-resources to automatically handle closing streams
        try (
            // Create a FileReader to read from t1.txt
            FileReader fis = new FileReader("C:\\Users\\mukti\\OneDrive\\Pictures\\gsap-learn\\React\\basics\\t1.txt");
            // Create a FileWriter to write to t2.txt
            FileWriter fout = new FileWriter("C:\\Users\\mukti\\OneDrive\\Pictures\\gsap-learn\\React\\basics\\t2.txt");
            // Create a BufferedWriter to write buffered content to t2.txt
            BufferedWriter bw = new BufferedWriter(fout);
        ) {
            int c;
            // Copy content from t1.txt to t2.txt
            while ((c = fis.read()) != -1) {
                fout.write(c);
            }

            // Print success message
            System.out.println("File copied successfully.");

            // Write additional content ("hiii") to t2.txt
            bw.write("hiii");
            bw.newLine(); // Add a newline after writing "hiii"

            // Create a new FileReader to read from t1.txt again (since fis is already consumed)
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mukti\\OneDrive\\Pictures\\gsap-learn\\React\\basics\\t1.txt"))) {
                // Read the first line from t1.txt
                String s = br.readLine();
                System.out.println("First line from t1.txt: " + s);
            }

        } catch (IOException e) {
            // Catch and print any IO exceptions
            System.out.println(e.getMessage());
        }
    }
}
