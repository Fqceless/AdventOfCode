package aoc22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {
    public static String compute() throws FileNotFoundException{
        File in = new File("C:\\Users\\clafa\\OneDrive\\Documents\\NetBeansProjects\\AdventOfCode2022\\src\\main\\java\\aoc22\\dayFiveIn.txt");
        Scanner read = new Scanner(in);
        Stack<String>[] StackArray = new Stack[9];
        for (int i = 0; i < StackArray.length; i++){
            StackArray[i] = new Stack<String>();
        }
        
        //input starting layout
        String input = read.nextLine();
        while(!input.isEmpty() && input.charAt(1) != 1){
            for (int i = 0; i < input.length(); i += 4){
                if(input.charAt(i) == '['){
                    StackArray[i/4].add((Character.toString(input.charAt(i + 1))));
                }
            }
            input = read.nextLine();
        }
        
        //correct stack layouts
        Stack<String> copyStack = new Stack();
        for (int i = 0; i < StackArray.length; i++) {
            while (!StackArray[i].isEmpty()) {
                copyStack.add(StackArray[i].pop());
            }
            StackArray[i] = copyStack;
            copyStack = new Stack();
        }
        
        //rearrange stacks
        String[] inSplit;
        while(read.hasNext()){
            input = read.nextLine();
            inSplit = input.split(" ");
            moveMult(StackArray, Integer.parseInt(inSplit[1]), Integer.parseInt(inSplit[3]) - 1, Integer.parseInt(inSplit[5]) - 1);
        }
        
        String ans= "";
        for(var i : StackArray){
            ans = ans + i.pop();
        }
        
        
        return ans;
    }
    
    
    public static void move(Stack[] StackArray, int moveNum, int firstNum, int lastNum){
        while(!StackArray[firstNum].isEmpty() && moveNum > 0){
            StackArray[lastNum].add(StackArray[firstNum].pop());
            moveNum--;
        }
    }
    
    public static void moveMult(Stack[] StackArray, int moveNum, int firstNum, int lastNum){
        Stack transferStack = new Stack();
        while(!StackArray[firstNum].isEmpty() && moveNum > 0){
            transferStack.add(StackArray[firstNum].pop());
            moveNum--;
        }
        
        while(!transferStack.isEmpty()){
            StackArray[lastNum].add(transferStack.pop());
        }
    }
}
