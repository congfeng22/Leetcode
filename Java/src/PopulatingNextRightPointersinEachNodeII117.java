public class PopulatingNextRightPointersinEachNodeII117 {
    public Node connect(Node root) {
        if (root==null) return root;
        root.left = connect(root.left);
        root.right = connect(root.right);
        Node l = root.left;
        Node r = root.right;
        int lvl = 0;
        while (true){
            Node t = leftmost(r,lvl);
            Node s = rightmost(l,lvl);
            if (t==null || s==null) break;
            s.next=t;
            lvl++;
        }
        return root;
    }
    public Node rightmost(Node root, int lvl){
        if (lvl==0) return root;
        Node t = null;
        if (root.right!=null) t=rightmost(root.right,lvl-1);
        if (t==null) return (root.left==null)?null:rightmost(root.left,lvl-1);
        return t;
    }
    public Node leftmost(Node root, int lvl){
        if (lvl==0) return root;
        Node t = null;
        if (root.left!=null) t=leftmost(root.left,lvl-1);
        if (t==null) return (root.right==null)?null:leftmost(root.right,lvl-1);
        return t;
    }
}
