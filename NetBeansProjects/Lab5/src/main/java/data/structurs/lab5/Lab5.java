/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package data.structurs.lab5;

public class Lab5 {

    public static void main(String[] args) {

        BST<Integer> lab5Tree = new BST<>();

        int[] values = {13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10};

        for (int value : values) {
            lab5Tree.insert(value);
        }

        lab5Tree.delete(17);

        System.out.print("Inorder: ");
        lab5Tree.inorder();

        System.out.print("\nPostorder: ");
        lab5Tree.postorder();

        System.out.print("\nPreorder: ");
        lab5Tree.preorder();

        System.out.println("\nSearch 36: " + lab5Tree.search(36));
        System.out.println("Search 37: " + lab5Tree.search(37));

        System.out.print("Path to 2: ");
        for (BST.TreeNode<Integer> node : lab5Tree.path(2)) {
            System.out.print(node.element + " ");
        }

        System.out.print("\nPath to 34: ");
        for (BST.TreeNode<Integer> node : lab5Tree.path(34)) {
            System.out.print(node.element + " ");
        }
    }
}