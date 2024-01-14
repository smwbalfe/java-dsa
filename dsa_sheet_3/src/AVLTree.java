

class AVLTree {
  public AVLTreeNode root;
  // TODO you may define additional variables here

  public AVLTree() {
    // TODO implement this
    root = null;
  }

  public void createTestTree() {
    // TODO implement this
    root = new AVLTreeNode("4");
    root.height = 0;
    AVLTreeNode x1 = new AVLTreeNode("1");
    AVLTreeNode x2 = new AVLTreeNode("2");
    AVLTreeNode x3 = new AVLTreeNode("3");
    AVLTreeNode x5 = new AVLTreeNode("5");
    AVLTreeNode x6 = new AVLTreeNode("6");
    AVLTreeNode x7 = new AVLTreeNode("7");
    root.left = x2;
    root.right = x6;
    x2.left = x1;
    x2.right = x3;
    x6.left = x5;
    x6.right = x7;

    x2.height = 1;
    x6.height = 1;
    x1.height = 2;
    x3.height = 2;
    x5.height = 2;
    x7.height = 2;
  }

  public static void preOrder(AVLTreeNode cur) {
    // TODO implement this

    if (cur == null) {
      return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < cur.height; i++){
      sb.append(" ");
    }
    sb.append(cur.element);
    System.out.println(sb);
    preOrder(cur.left);
    preOrder(cur.right);

  }

  public void print() {
    preOrder(root);
  }

  public boolean inTree(String e) {
    // TODO implement this

    AVLTreeNode cur = root;
    while (cur != null) {
      System.out.println("Comparing " + e + " with " + e);
      if (cur.element.compareTo(e) == 0) {
        return true;
      }
      cur = cur.element.compareTo(e) < 0 ? cur.right : cur.left;
    }
    return false;
  }

  public void insert(String e) {
    // TODO implement this

    avlInsert(root, e);
  }

  public AVLTreeNode avlInsert(AVLTreeNode cur, String e) {
    if (cur == null) {
      root = new AVLTreeNode(e);
      return root;
    }
    if (e.compareTo(cur.element) < 0) {
      cur.left = avlInsert(cur.left, e);
    } else if (e.compareTo(cur.element) > 0) {
      cur.right = avlInsert(cur.right, e);
    } else {
      return cur;
    }

    cur.height = 1 + cur.getChildHeight();

    int b = cur.getBalance();

    if (b > 1 && e.compareTo(cur.left.element) < 0) {
      return RR(cur);
    }

    if (b < -1 && e.compareTo(cur.right.element) > 0) {
      return LR(cur);
    }

    if (b > 1 && e.compareTo(cur.left.element) > 0) {
      return RR(cur);
    }

    if (b < -1 && e.compareTo(cur.right.element) < 0) {
      return LR(cur);
    }
    return cur;
  }

  public AVLTreeNode RR(AVLTreeNode node) {
    AVLTreeNode val1 = node.left;
    AVLTreeNode val2 = node.right;

    val1.right = node;
    node.left = val2;

    node.height = Math.max(node.left.getChildHeight(), node.right.getChildHeight()) + 1;
    val1.height = Math.max(val1.left.getChildHeight(), val1.right.getChildHeight()) + 1;

    return val1;
  }

  public AVLTreeNode LR(AVLTreeNode node) {
    AVLTreeNode val1 = node.right;
    AVLTreeNode val2 = val1.right;

    val1.left = node;
    node.right = val2;

    node.height = Math.max(node.left.getChildHeight(), node.right.getChildHeight()) + 1;
    val1.height = Math.max(val1.left.getChildHeight(), val1.right.getChildHeight()) + 1;

    return val1;
  }


}
