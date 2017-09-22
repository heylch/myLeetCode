public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null))
            return;
        TreeLinkNode start = (root.left == null)? root.right:root.left;
        TreeLinkNode track = (root.left == null)? root.right:root.left;
        while(start != null){
            while(root !=null){
                if(track == root.left){
                    if(root.right != null){
                        track.next = root.right;
                        track = track.next;
                    }
                   else
                       root = root.next;
                }
                else if(track == root.right)
                    root = root.next;
                else if((track != root.left && track != root.right) && root.left != null){
                    track.next = root.left;
                    track = track.next;
                }
                else if((track != root.left && track != root.right) && root.right != null){
                    track.next = root.right;
                    track = track.next;
                    root = root.next;
                }
                else
                    root = root.next;
            }
            while(start != null && (start.left == null && start.right ==null))
                start = start.next;
            if(start == null)
                break;
            root = start;
            track = start.left == null? start.right:start.left;
            start = start.left == null? start.right:start.left;
            
            
        }
    }
}