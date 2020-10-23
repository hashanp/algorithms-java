package DataStructures;

import java.util.NoSuchElementException;

public class BinarySearchTree<A extends Comparable<A>, B> {
  private static class Node<A extends Comparable<A>, B> {
    A key;
    B value;
    Node<A, B> left;
    Node<A, B> right;
    Node<A, B> parent;

    public Node(A key, B value, Node<A, B> parent) {
      this.key = key;
      this.value = value;
      this.parent = parent;
    }

    protected int size() {
      int s = 1;
      if (left != null) {
        s += left.size();
      }
      if (right != null) {
        s += right.size();
      }
      return s;
    }

    protected Node<A, B> minimum() {
      Node<A, B> current = this;
      while (current.left != null) {
        current = current.left;
      }
      return current;
    }

    protected Node<A, B> maximum() {
      Node<A, B> current = this;
      while (current.right != null) {
        current = current.right;
      }
      return current;
    }

    protected Node<A, B> successor() {
      if (this.right != null) {
        return this.right.minimum();
      } else {
        Node<A, B> current = this;
        Node<A, B> next = this.parent;
        while (next != null && next.right == current) {
          current = next;
          next = next.parent;
        }
        return next;
      }
    }

    protected void remove() {
      if (this.left == null && this.right == null) {
        transplant(null);
      } else if (this.left == null) {
        transplant(this.right);
      } else if (this.right == null) {
        transplant(this.left);
      } else {
        Node<A, B> replacement = this.successor();
        if (this.right != replacement) {
          replacement.transplant(replacement.right);
          replacement.right = this.right;
          replacement.right.parent = replacement;
        }
        transplant(replacement);
        replacement.left = this.left;
        replacement.left.parent = replacement;
      }
    }

    protected Node<A, B> get(A key) {
      if (key.compareTo(this.key) == 0) {
        return this;
      } else if (key.compareTo(this.key) < 0) {
        if (this.left == null) {
          return null;
        } else {
          return this.left.get(key);
        }
      } else {
        if (this.right == null) {
          return null;
        } else {
          return this.right.get(key);
        }
      }
    }

    protected void transplant(Node<A, B> replacement) {
      if (this.parent.left == this) {
        this.parent.left = replacement;
        replacement.parent = this.parent;
      } else if(this.parent.right == this) {
        this.parent.right = replacement;
        replacement.parent = this.parent;
      }
    }

    protected void put(A key, B value) {
      if (key.compareTo(this.key) < 0) {
        if(this.left == null) {
          this.left = new Node<>(key, value, this);
        } else {
          this.left.put(key, value);
        }
      } else if (key.compareTo(this.key) == 0) {
        this.value = value;
      } else {
        if (this.right == null) {
          this.right = new Node<>(key, value, this);
        } else {
          this.right.put(key, value);
        }
      }
    }
  }

  private Node<A, B> root;

  public void put(A key, B value) {
    if (root == null) {
      root = new Node<>(key, value, null);
    } else {
      root.put(key, value);
    }
  }

  public B get(A key) {
    /*Node<A, B> current = root;
    while (current != null && current.key != key) {
      if (key.compareTo(current.key) < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }*/
    Node<A, B> current = root.get(key);
    if (current == null) {
      throw new NoSuchElementException();
    } else {
      return current.value;
    }
  }

  public void remove(A key) {
    Node<A, B> node = root.get(key);
    if (node == null) {
      throw new NoSuchElementException();
    } else {
      node.remove();
    }
  }

  public Node<A, B> minimum() {
    return root.minimum();
  }

  public Node<A, B> maximum() {
    return root.maximum();
  }

  public int size() {
    if (root == null) {
      return 0;
    } else {
      return root.size();
    }
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer, Integer> k = new BinarySearchTree<>();
    k.put(4, 7);
    k.put(1, 3);
    k.put(6, 8);
    k.put(7, 8);
    System.out.println(k.get(4));
    System.out.println(k.get(1));
    System.out.println(k.get(6));
    System.out.println(k.get(7));
    System.out.println();
    System.out.println(k.size());
    System.out.println(k.minimum().value);
    System.out.println(k.maximum().value);
    System.out.println();
    k.remove(6);
    System.out.println(k.size());
    System.out.println();
    System.out.println(k.get(4));
    System.out.println(k.get(1));
    System.out.println(k.get(7));
    System.out.println(k.get(6));
  }
}
