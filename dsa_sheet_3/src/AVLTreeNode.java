class AVLTreeNode {
    public String element;
    public int height;
    public AVLTreeNode left = null;
    public AVLTreeNode right = null;

    AVLTreeNode(String e) {
        element = e;
        height = 1;
    }

    public int getRightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height;
        }
    }

    public int getLeftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height;
        }
    }

    public int getBalance() {
        return getRightHeight() - getLeftHeight();
    }

    public int getChildHeight() {
        return Math.max(getRightHeight(), getLeftHeight());
    }

    public int compareStringToThis(String s) {
        System.out.println("Comparing " + s + " with " + element);
        return s.compareTo(element);
    }

    public String toString() {
      return element;
    }
}
