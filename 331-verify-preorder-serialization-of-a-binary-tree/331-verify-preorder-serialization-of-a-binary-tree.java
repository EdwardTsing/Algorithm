class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : ss) {
            stack.push(s);
            while (stack.size() >= 3 && stack.get(0).equals("#") && stack.get(1).equals("#") && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
    
}