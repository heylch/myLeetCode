// Two Ponters
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        TreeLinkNode start = (root.left == null)? root.right:root.left;
        TreeLinkNode track = start;
        while(start != null){
            if(track == root.left){
                if(root.right != null)
                    track.next = root.right;
                else{
                    root = root.next;
                    while(root != null && (root.left == null && root.right ==null ))
                        root = root.next;
                    if(root != null)
                        track.next = (root.left == null)? root.right : root.left;
                }
            }
            else{
                root = root.next;
                while(root != null && ((root.left == null) && (root.right == null)))
                    root = root.next;
                if(root != null)
                    track.next = (root.left == null)? root.right : root.left;
            }
            track = track.next;
            if(root == null){
                while(start != null && ((start.left == null) && (start.right == null)))
                    start = start.next;
                if(start == null)
                    return;
                root = start;
                start = (start.left == null)? start.right:start.left;
                track = start;
            }
        }
    }
}

//Recursion
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        TreeLinkNode track = root.next;
        TreeLinkNode next = null;
        while(track !=null){
            if(track.left != null){
                next = track.left;
                break;
            }
            if(track.right != null){
                next = track.right;
                break;
            }
            track = track.next;
        }
        if(root.right !=null)
            root.right.next = next;
        if(root.left !=null)
            root.left.next = (root.right == null)? next:root.right;
        connect(root.right);
        connect(root.left);      
        
    }
}
