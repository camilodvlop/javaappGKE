package co.com.application.appvalidation.nodesexample;

public class MyClass {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Método para eliminar hojas con el valor objetivo
    public static TreeNode treeWalker(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        // Aplicamos la recursión para procesar los subárboles
        root.left = treeWalker(root.left, target);
        root.right = treeWalker(root.right, target);

        // Si el nodo es hoja y tiene el valor objetivo, lo eliminamos
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }

    // Método para visualizar el árbol en preorden
    public static void treeViewer(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        treeViewer(root.left);
        treeViewer(root.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        System.out.println("arbol original:");
        treeViewer(root);

        root = treeWalker(root, 4);
        System.out.println("Despues de eliminar hojas con valor 4:");
        treeViewer(root);

        root = treeWalker(root, 3);
        System.out.println("Despues de eliminar hojas con valor 3:");
        treeViewer(root);
    }
}