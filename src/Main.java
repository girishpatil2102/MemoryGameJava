import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cards = new ArrayList<>();

        cards.add("A");cards.add("A");
        cards.add("B");cards.add("B");
        cards.add("C");cards.add("C");
        cards.add("D");cards.add("D");

        Collections.shuffle(cards);

        String[] board = new String[cards.size()];
        Arrays.fill(board," ");
        boolean[] flipped = new boolean[cards.size()];
        int pairsFound = 0;

        System.out.println("Welcome to the Memory Game :)\n");

        while(pairsFound<4){
            printBoard(board);

            int firstIndex = getIndex(sc,board,flipped,"Enter First Index : ");
            board[firstIndex] = cards.get(firstIndex);
            flipped[firstIndex] = true;
            printBoard(board);

            int secondIndex = getIndex(sc,board,flipped,"Enter Second Index : ");
            board[secondIndex] = cards.get(secondIndex);
            flipped[secondIndex] = true;
            printBoard(board);

            if(board[firstIndex].equals(board[secondIndex])){
                System.out.println("Yay!! You Found a Pair !!!");
                pairsFound++;
            }
            else{
                System.out.println("Sorry! This Cards Didn't Match !!!");
                board[firstIndex] = " ";
                board[secondIndex] = " ";
                flipped[firstIndex] = false;
                flipped[secondIndex] = false;

            }
        }

        System.out.println("Congratulations!!! You Won.");

    }

    private static int getIndex(Scanner sc, String[] board, boolean[] flipped, String s) {
        int index;
        while(true){
            System.out.print(s);
            index = sc.nextInt();
            if(index<0 || index>=board.length){
                System.out.println("Enter Valid Index.");
            } else if (flipped[index]) {
                System.out.println("Card already Flipped. select another card");
            }
            else{
                break;
            }
        }
        return index;
    }
    private static void printBoard(String[] board) {
        for(String value : board){
            System.out.print("| "+value+" ");
        }
        System.out.println("|");
    }
}