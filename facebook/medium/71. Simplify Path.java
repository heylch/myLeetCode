public class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < paths.length;i++){
            String p = paths[i];
            if(p.length() !=0){
                if(p.equals("."))
                    continue;
                else if(p.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else
                    stack.push(p);
            }
        }
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
            result.insert(0,"/");
        }     
        return result.toString();
    }
}