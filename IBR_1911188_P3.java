package myassp3;

import java.util.Scanner;

public class IBR_1911188_P3 {

    static lListTree BTS = new lListTree();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
         Run();
        number();
    }

  //---------------------run the hole program-------------------------------------

    public static void Run() {
        CreateBST();
        WordCount();
        MostCommonWord();
        BTS.PrintText();
        GetFrequencyOf();
        RemoveWord();
    }
//---------------------reads a text and creates a BST---------------------------

    public static void CreateBST() {
        System.out.print("Please Enter Text: ");
        String[] toSplitText = input.nextLine().split(" ");
        for (String toSplitText1 : toSplitText) {
            BTS.addword(toSplitText1);
        }
    }
//-------Find the word with the highest count in the BST------------------------

    public static void MostCommonWord() {
        Node word = BTS.MostCommonWord();
        System.out.println("The Most common word: " + word.getWord()
                + " with a count: " + word.getCount());
    }
//---------------------the number of words (nodes) in the BST-------------------

    public static void WordCount() {
        System.out.println("The Number of nodes in the tree: " + BTS.getSize());
    }
//---------------------count the Frequency of given word in the BTS-------------

    public static void GetFrequencyOf() {
        try {
            System.out.print("Please Enter a word to count its Frequency: ");
            String word = input.nextLine().toLowerCase();
            System.out.println("The frequency of the word " + word + " is "
                    + BTS.GetFrequencyOf(word));
        } catch (NullPointerException e) {
            System.out.println("the word does not exist");
        }
    }
//---------------------removes the node that contains the given word------------

    public static void RemoveWord() {
        try {
            System.out.print("Please Enter a word to remove: ");
            if (BTS.deleteNode(input.nextLine().trim().toLowerCase())) {
                System.out.println("     Done The word is deleted");
            }
            WordCount();
            MostCommonWord();
            BTS.PrintText();
        } catch (NullPointerException e) {
            System.out.println("the word does not exist");
        }

    }
    public static void number() {
        lListTree tree = new lListTree();
        tree.addword("60");
        tree.addword("41");
        tree.addword("74");
        tree.addword("65");
        tree.addword("70");
        tree.addword("63");
        tree.addword("84");
        tree.addword("62");
        tree.addword("16");
        tree.addword("25");
        tree.addword("53");
        tree.addword("46");
        tree.addword("42");
        tree.addword("55");

        tree.getAncestors(tree.getNod("42"));
    }

}
