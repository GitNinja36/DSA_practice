import java.util.*;

public class BT {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int indx = -1;
        public static Node buildTree(int node[]){
            indx++;
            if( node[indx] == -1){
                return null;
            }
            Node newNode = new Node(node[indx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }

        //preorder
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //inorder
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        //postorder
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        //levelorder
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    static class Info{
        int diameter;
        int height;

        public Info(int diam, int ht){
            this.diameter = diam;
            this.height = ht;
        }
    }


    //height of tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    //total nodes
    public static int numNode(Node root){
        if(root == null){
            return 0;
        }
        int ln = numNode(root.left);
        int rn = numNode(root.right); 
        return ln + rn + 1;
    }

    //total sum nodes
    public static int sumNode(Node root){
        if(root == null){
            return 0;
        }
        return sumNode(root.left) + sumNode(root.right) + root.data;
    }

    //maximum diameter
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int LD = diameter(root.left);
        int RD = diameter(root.right);
        int LH = height(root.left);
        int RH = height(root.right);
        int selfDia = LH + RH ;
        return Math.max(selfDia, Math.max(RD, LD));
    }

    //maximum diameter approach 2
    public static Info diamete2(Node root){
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diamete2(root.left);
        Info rightInfo = diamete2(root.right);
        int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height +1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(diam, height);
    }

    //subtree
    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null){
            return true;
        }else if(root == null || subRoot == null || root.data != subRoot.data){
            return false;
        }
        if(!isIdentical(root.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)){
            return false;
        }
        return true;
    }

    //

    public static void main(String[] args) {
        // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // tree.preOrder(root);
        // tree.inOrder(root);
        // tree.postOrder(root);
        // tree.levelOrder(root); 

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(9);

        // System.out.println("height : " + height(root));
        // System.out.println("number of Nodes : " +numNode(root));
        // System.out.println("sum of Nodes : " + sumNode(root));
        // System.out.println("maximum diameter : " + diameter(root));
        // System.out.println("maximum diameter approach 2 : " + diamete2(root).diameter);
        System.out.println(isSubtree(root, subRoot));
    }
}
