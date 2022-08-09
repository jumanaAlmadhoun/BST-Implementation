package myassp3;

public class Node {

    private int count;
    private String word;
    private Node left;
    private Node right;
    static int counter;

    public Node(String word, int count) {
        this(word, count, null, null);
    }

    public Node(String word, int count, Node left, Node right) {
        this.word = word;
        this.count = count;
        this.left = left;
        this.right = right;
        counter++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        this.count++;
        counter++;
    }
    public double getFre(){
       return (double)this.count/counter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "     " + word + " with a count: " + count;
    }
    
    

}
