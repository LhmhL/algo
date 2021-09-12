package avltree;

public class AVLTreeTest {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        avl.add(9);
        avl.add(10);
        avl.add(11);

        System.out.println("是否是二叉查找树：" + avl.isBSTree());
        System.out.println("是否是平衡二叉树：" + avl.isBalanced());
    }
}
