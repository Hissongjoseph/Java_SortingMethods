/*
Program title: Bubble Sort Algorithm
Programmer: Joseph Hissong
Course: CSCI 192
Semester: Fall 2015
Instructor: Samimi
Due Date: December 4, 2015

Description: This program takes inputted numbers and sorts using Bubble
sort. Any numbers under zero and above one thousand will be send to a external 
text file named InvalidData and will be prompted with an appropriate message.

input:Amount of numbers to sort & the numbers to sort.
Output: N/A
*/
package bubblesortalgorithm;
import java.util.Formatter;
import java.util.Scanner;
public class BubbleSortAlgorithm {
    public static void main(String[] args) throws Exception {
    int Counter = 0;
    int[] Array = getData();
    System.out.println("******************************************************************************");
    Array = BubbleSortData(Array,Counter);//calls the selection sort method.
    }//end of main string

    private static int[] getData() throws Exception {
    Scanner input = new Scanner(System.in);
    Formatter output = new Formatter("InvalidData.out");
    
    int AmountOfNumbers = 0;
    
    System.out.println("Please enter how many numbers you would like to sort:");
    AmountOfNumbers = input.nextInt();
    int[] Array = new int[AmountOfNumbers];
    
    
    System.out.println("Please enter numbers greater than 0 and less than 1000 separated by spaces: ");
    for (int i = 0; i < AmountOfNumbers;i++)
    {
        
        Array[i]= input.nextInt();
        while (Array[i] > 1000 || Array[i] < 0) //checks user input to make sure it is between 0 and 1000.
        {
        System.out.println("Your input does not match the criteria, please enter a number between 0 and 1000");
        output.format("Invalid Criteria that has been entered: %d \n",Array[i]);//sends output to output file.
        
        while(!input.hasNextInt())
            {
            input.next() ;
            }//end of input while loop
        Array[i] = input.nextInt();
        }//end of while loop
   
    }//end of for loop
    output.close();
    return Array;        
    }

    private static int[] BubbleSortData(int[] Array, int Counter) {
        int tempArray = 0;
        for (int p = 1; p <= Array.length - 1;p++)
            for(int i = 0;i <= Array.length - 2;i++)
                if (Array[i] > Array [i +1])
                {
                    tempArray = Array[i];
                    Array[i] = Array[i + 1];
                    Array[i + 1] = tempArray;
                    Counter++;
                }    
              
    System.out.printf("Amount of times For-loop was executed: %d%n",Counter);
    //displays how many times the sort method had to go through
    return Array;
    }
    
}
