class MinStack {
    
    class Node{
        int element;
        int min;
        
        Node(int Element, int Min){
            element = Element;
            min = Min;
        }
    }
    
    List<Node> list;
    MinStack(){
        list = new ArrayList<Node>();
    }
    
    public void push(int x) {
        int minVal = x;
        if(!list.isEmpty()){
            Node lastNode = list.get(list.size() - 1);
            minVal = Math.min(minVal, lastNode.min);
        }
        Node newNode = new Node(x, minVal);
        list.add(newNode);
    }

    public void pop() {
        if(!list.isEmpty()){
            list.remove(list.size() - 1);
        }
    }

    public int top() {
        if(!list.isEmpty()){
            return list.get(list.size() - 1).element;
        }
        else{
            return 0;
        }
    }

    public int getMin() {
        if(!list.isEmpty()){
            return list.get(list.size() - 1).min;
        }
        else{
            return 0;
        }
    }
}

