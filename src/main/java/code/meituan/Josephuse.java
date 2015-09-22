package code.meituan;

/**
 * 约瑟夫斯环
 */
public class Josephuse {
    private Node first;  
    private Node last;  
    private int numbers;  
      
    class Node {  
        private int num;  
        private Node pre;  
        private Node next;  
          
        public Node(int num, Node pre, Node next) {  
            super();  
            this.num = num;  
            this.pre = pre;  
            this.next = next;  
        }  
    }  
      
    private void add(int n) {  
        if (first == null) {  
            first = new Node(n, null, null);  
            last = first;  
        } else {  
            Node newNode = new Node(n, last, null);  
            last.next = newNode;  
            last = newNode;  
        }  
        numbers++;  
    }  
      
    public void delete(Node node) {  
        if (node.pre == null && node.next == null) {  
            first = last = null;  
            node = null;  
        } else if (node.pre == null) {  
            Node n = node.next;  
            n.pre = null;  
            node.next = null;  
            node = null;  
            first = n;  
        } else if (node.next == null) {  
            Node n = node.pre;  
            n.next = null;  
            node.pre = null;  
            node = null;  
            last = n;  
        } else {  
            Node p = node.pre;  
            Node n = node.next;  
            p.next = n;  
            n.pre = p;  
            node.next = null;  
            node.pre = null;  
            node = null;  
        }  
        numbers--;  
    }  
  
    public Josephuse(int fir, int la) {  
        if (fir < 0 || la < 0 || fir > la)  
            throw new RuntimeException();  
        for (int i = fir; i <= la; i++) {  
            add(i);  
        }  
    }  
      
    public static void main(String[] args) {  
        Josephuse josephuse = new Josephuse(0, 500);  
        System.out.print("");
//      System.out.println("\n最后剩余的结点为： " + josephuse.lastRemaining(2));  
        System.out.println("\n最后剩余的结点为： " + josephuse.lastRemaining2());  
        int j = 0;  
        for(int i = 0; i < 100; i++) {  
            j = j++;  
        }  
        System.out.println(j);  
    }  
      
    /** 
     * 约瑟夫环 
     * @param m 每次删除第m个结点 
     * @return  
     */  
    public int lastRemaining(int m) {  
        Node node = first;  
        while (numbers > 1) {  
            for (int i = 1; i < m; i++) {  
                Node n = node;  
                if (n == null) {  
                    n = first;  
                }  
                n = node.next;  
                if (n == null) {  
                    n = first;  
                }  
                node = n;  
            }  
            Node start = node.next;  
            if (start == null)  
                start = first;  
            delete(node);  
            System.out.print(node.num + "  ");  
            node = start;  
        }  
        return node.num;  
    }  
      
    /** 
     * 0, 1, 2, 3, ..., 499, 500共501个数按升序排列，每次取奇数位序的数丢掉， 
     * 然后去剩余的数的奇数位序的数丢掉，重复这个过程，那么最后剩余的数是多少？<p> 
     * eg: 0 1 2 3 4 5 6 7 8 9 10<br> 
     * 第一次删除 0 2 4 6 8 10<br> 
     * 第二次删除 1 5 9<br> 
     * 第三次删除 3<br> 
     * 剩余 7<br> 
     * @param m 每次删除第m个结点 
     * @return  
     */  
    public int lastRemaining2() {  
        Node node = first;  
          
        while (numbers > 1) {  
            int i = 1;  
            while (node != null ) {  
                Node n = node.next;  
                if ((i & 0x01) != 0) {  
                    System.out.print(node.num + "  ");  
                    delete(node);  
                }  
                node = n;  
                i++;  
            }  
            node = first;  
        }  
        return node.num;  
    }  
      
}  