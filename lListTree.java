package myassp3;

import java.util.ArrayList;
import java.util.Arrays;
import static myassp3.IBR_1911188_P3.BTS;

public class lListTree {

    private Node root;
    private int size;

    public lListTree() {
        this.root = null;
    }

    public int getSize() {
        return size;
    }
//----------------------checks if the list is empty-----------------------------

    public boolean isEmpty() {
        return this.root == null;
    }
//----------------------checks to see if the word is a valid word or not--------

    public boolean IsValidWord(String word) {
        if (word.isEmpty()) {
            return false;
        }

        return !Character.isAlphabetic(word.charAt(0))
                || IsValidWord(word.substring(1));
    }
//----------------------removes punctuation symbols-----------------------------

    public String removespunctuation(String word) {
        if (word.contains("-")) {
            return word;
        }
        word = word.replaceAll("\\p{Punct}", "");
        return word.toLowerCase();
    }
//----------------------checks to see if a given word is in the stopgap list----

    private boolean IsWordAStopgapWord(String word) {
        String[] StopgapWord = {"a", "an", "and", "are", "as", "at", "be",
            "by", "for", "from", "has", "he", "in", "is", "it", "its",
            "of", "on", "that", "the", "to", "she", "was",
            "where", "will", "with", "so"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(StopgapWord));
        for (int i = 0; i < list.size(); i++) {
            if (word.equalsIgnoreCase(list.get(i))) {
                return true;
            }
        }
        return false;
    }

//-----------------------add a word to the binary search tree-------------------
    public void addword(String word) {
        /* word = removespunctuation(word).toLowerCase();
        if (!IsValidWord(word) && !IsWordAStopgapWord(word)
                && !word.isEmpty()) {
            root = insert(root, word);
        }*/

        root = insert(root, word);
    }

    private Node insert(Node root, String word) {
       
        if (root == null) {
            root = new Node(word, 1);
               size++;
        } else if (word.compareTo(root.getWord()) < 0) {
            root.setLeft(insert(root.getLeft(), word));
        } else if (word.compareTo(root.getWord()) > 0) {
            root.setRight(insert(root.getRight(), word));
        } else {
            root.increaseCount();
        }
        return root;
    }
//-------Find the word with the highest count in the BST------------------------

    public Node MostCommonWord() {
        return MostCommonWord(root);
    }

    private Node MostCommonWord(Node node) {
        Node largestvalue = node;
        if (largestvalue != null) {
            if (largestvalue.getLeft() != null) {
                if (MostCommonWord(largestvalue.getLeft()).getCount()
                        > largestvalue.getCount()) {
                    largestvalue = largestvalue.getLeft();
                }
            }
            if (largestvalue.getRight() != null) {
                if (MostCommonWord(largestvalue.getRight()).getCount()
                        > largestvalue.getCount()) {
                    largestvalue = largestvalue.getRight();
                }
            }
        }

        return largestvalue;
    }

//-------------------------get a node by given word-----------------------------
    public Node getNod(String word) {
        return getNode(root, word);
    }

    private Node getNode(Node node, String word) {
        Node temp = node;
        if (temp != null) {
            if (word.compareTo(temp.getWord()) < 0) {
                temp = getNode(temp.getLeft(), word);
            }
            if (word.compareTo(temp.getWord()) > 0) {
                temp = getNode(temp.getRight(), word);
            }

        }
        return temp;
    }
//----------------------removes the node that contains the given word-----------

    public boolean deleteNode(String word) {
        Node temp = getNod(word);
        if (temp != null) {
            root = deleteNode(root, word);
            size--;
            return temp != null;
        }

        return false;
    }

    private Node deleteNode(Node root, String word) {
        if (root == null) {
            return root;
        }

        if (word.compareTo(root.getWord()) < 0) {
            root.setLeft(deleteNode(root.getLeft(), word));

        } else if (word.compareTo(root.getWord()) > 0) {
            root.setRight(deleteNode(root.getRight(), word));

        } else {

            //check node is leafe
            if (root.getRight() == null && root.getLeft() == null) {
                return null;
            }

            // check no right childe
            if (root.getRight() == null) {
                return root.getLeft();
            }

            // check no left childe
            if (root.getLeft() == null) {
                return root.getRight();
            }

            Node minValue = minValue(root.getRight());
            root.setWord(minValue.getWord());
            root.setCount(minValue.getCount());
            root.setRight(deleteNode(root.getRight(), minValue.getWord()));
        }

        return root;
    }

    public Node minValue(Node root) {
        if (root == null) {
            return null;
        }
        if (root.getLeft() != null) {
            return minValue(root.getLeft());
        }
        return root;
    }
//----------------------count the Frequency of given word in the BTS------------

    public double GetFrequencyOf(String word) {
        return (double) BTS.getNod(word.trim().toLowerCase()).getFre();
    }
//----------------------prints all words in the BST in an alphabetical order----

    public void PrintText() {
        System.out.println("The Words in alphabetical order are: ");
        Print(root);
    }

    private void Print(Node root) {
        if (root != null) {
            Print(root.getLeft());
            System.out.println(root.toString());
            Print(root.getRight());
        }
    }

    public Node getAncestors(Node node) {
        System.out.println("hi");
        if (parent(node) == null) {
            return null;

        } else if (root.getWord().equalsIgnoreCase(parent(node).getWord())) {
            System.out.println(parent(node).getWord());
            return root;
        }
        System.out.println(parent(node).getWord());
        return getAncestors(parent(node));
    }

    public Node parent(Node p) {
        return parent(root, p);
    }

    private Node parent(Node root, Node p) {
       
        if (root == null || root == p) {
            return null;
        }
        if (root.getLeft() == p || root.getRight() == p) {
            return root;
        }
        if (p.getWord().compareTo(root.getWord()) > 0) {
            return parent(root.getLeft(), p);
        } else if (p.getWord().compareTo(root.getWord()) < 0) {
            return parent(root.getRight(), p);
        } else {
            System.out.println("here");
            return null;
        }
    }

}
