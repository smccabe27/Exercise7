import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Exercise7 {

    public static void main(String[] args) throws Exception {
        String filepath = "Exercise7.txt";
        File text = new File(filepath);
        
        try(PrintWriter integers = new PrintWriter(filepath)){
            Random rand = new Random();
            for(int i = 1;i<=10;i++){
                    integers.print(rand.nextInt(101) + " ");
                }
                integers.close();
        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
        }
        
        Scanner reader = new Scanner(text);
        String content = reader.nextLine();
        reader.close();
        
        String intBuild = "";
        int[] contents = new int[10];
        int arrayCount = 0;
        
        for(int i = 0;i<content.length();i++){
            if(content.charAt(i) != ' '){
                intBuild += content.charAt(i);
            }
            else{
                contents[arrayCount] = Integer.parseInt(intBuild);
                arrayCount++;
                intBuild = "";
            }
        }
        
        System.out.print("The array contins the following integers: ");
                
        int sum = 0;
        for(int i = 0;i<10;i++){
            sum += contents[i];
            System.out.print(contents[i] + " ");
        }
        System.out.print("\nThe sum of the numbers in the array is " + sum);
        System.out.print("\nThe average of the numbers in the array is " + (double)sum/10 + "\n");
        
        text.delete();
    }
}