package LinkedList;

public class Test {
    public int getLength(ListNode head) {
        int length=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            length++;
        }
        return length;
    }

    //给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null
    //结论：从链表的头部出发到达环入口点的距离，
    //     和从 fast，slow 交汇处出发到达环入口点的距离是一样的
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        ListNode cur1=head;
        ListNode cur2=fast;
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }

    //给定一个链表，判断链表中是否有环，如果链表中存在环，则返回 true，否则，返回 false
    //快慢指针法:创建两个引用 fast，slow，fast每次走两步，slow每次走一步，
    //如果链表不带环，fast就会率先到达终点 null；如果链表带环，fast 就会追上 slow
    public boolean hasCycle(ListNode head) {
        if(head==null&&head.next==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    //找到两个单链表相交的起始节点。
    //1、分别求出两个链表的长度 l1，l2
    //2、看两个链表谁长，
    //   如果 l1>l2 ，就让 cur1 先走 l1-l2 步，如果 l1<l2 ，就让 cur2 先走 l2-l1 步
    //3、此时 cur1 和 cur2 处在同一起跑线上，让他俩同时往后走，看是否相遇
    //   相遇时的位置就是两个链表的交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=getLength(headA);
        int len2=getLength(headB);
        if(len1>len2){
            int steps=len1-len2;
            for(int i=0;i<steps;i++){
                headA=headA.next;
            }
        }else{
            int steps=len2-len1;
            for(int i=0;i<steps;i++){
                headB=headB.next;
            }
        }
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }

    //对于一个链表，判断其是否为回文结构
    public boolean chkPalindrome(ListNode A) {
        if(A==null){
            return true;
        }
        if(A.next==null){
            return true;
        }
        ListNode newHead=new ListNode(0);
        ListNode newTail=newHead;
        for(ListNode cur=A;cur!=null;cur=cur.next){
            newTail=new ListNode(cur.val);
            newTail=newTail.next;
        }
        ListNode B=newHead.next;
        ListNode prev=null;
        ListNode cur=B;
        while(cur!=null){
            ListNode next=cur.next;
            if(next==null){
                B=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        ListNode cur1=A;
        ListNode cur2=B;
        while(cur1!=null&&cur2!=null){
            if(cur1.val!=cur2.val){
                return false;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return true;
    }

    // 在一个排序的链表中存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return null;
        }
        if(pHead.next==null){
            return pHead;
        }
        ListNode newHead=new ListNode(0);
        ListNode newTail=newHead;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur!=null&&cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
            }else{
                newTail.next=new ListNode(cur.val);
                newTail=newTail.next;
            }
            cur=cur.next;
        }
        return newHead.next;
    }

    // 给一定值 x ，编写一段代码将所有小于 x 的结点排在其余结点之前，
    // 且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    // 处理一般情况，需要创建两个链表，用来保存两部分结果。
    // 最后需要把两个链表合并成一个，直接首尾相接即可。
    public ListNode partition (ListNode pHead,int x){
        if(pHead==null){
            return null;
        }
        if(pHead.next==null){
            return pHead;
        }
        ListNode smallHead=new ListNode(0);
        ListNode smallTail=smallHead;
        ListNode largeHead=new ListNode(0);
        ListNode largeTail=largeHead;
        for(ListNode cur=pHead;cur!=null;cur=cur.next){
            if(cur.val<x){
                smallTail.next=new ListNode(cur.val);
                smallTail=smallTail.next;
            }else{
                largeTail.next=new ListNode(cur.val);
                largeTail=largeTail.next;
            }
        }
        smallTail.next=largeHead.next;
        return smallHead.next;
    }
    // 将两个升序链表合并为一个新的升序链表并返回。
    // 新链表是通过拼接给定的两个链表的所有节点组成的。
    // 思路：
    // 创建一个新链表，用来表示合并结果，初始情况下是一个空链表；
    // 创建两个引用分别指向两个链表的第一个结点，
    // 比较这两个值的大小，将值较小的结点插入到结果链表的末尾；
    // 然后对应的引用也要移动到 next 的位置上；
    // 循环以上比较和插入的过程，直到两个引用的其中一个到达 null 即链表末尾；
    // 最后将另一个链表剩余的部分都插入到结果链表的末尾。
    public ListNode mergeTwoLists (ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur1=l1;
        ListNode cur2=l2;
        ListNode newHead=new ListNode(0);
        ListNode newTail=newHead;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                newTail.next=cur1;
                cur1=cur1.next;
            }else{
                newTail.next=cur2;
                cur2=cur2.next;
            }
            newTail=newTail.next;
        }
        if(cur1==null){
            newTail.next=cur2;
        }
        if(cur2==null){
            newTail.next=cur1;
        }
        return newHead.next;
    }
    //输入一个链表，输出该链表中倒数第 k 个结点。
    //要想得到倒数第 k 个结点，就从头开始走 len-k 步
    public ListNode FindKthToTail (ListNode head,int k){
        if(head==null){
            return null;
        }
        if(k<=0){
            return null;
        }
        int length=getLength(head);
        if(k>length){
            return null;
        }
        int steps=length-k;
        ListNode cur=head;
        for(int i=0;i<steps;i++){
            cur=cur.next;
        }
        return cur;
    }
    // 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
    // 如果有两个中间结点，则返回第二个中间结点。
    // 1.先求链表长度
    // 2.根据链表长度/2的结果，让一个引用从头开始走这些步数即可。
    public ListNode middleNode (ListNode head){
        if(head==null){
            return null;
        }
        int length=getLength(head);
        int steps=length/2;
        ListNode cur=head;
        for(int i=0;i<steps;i++){
            cur=cur.next;
        }
        return cur;
    }
    //反转一个单链表
    public ListNode reverseList (ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode newHead=null;
        ListNode prevNode=null;
        ListNode curNode=head;
        while(curNode!=null){
            ListNode nextNode=curNode.next;
            if(nextNode==null){
                newHead=curNode;
            }
            curNode.next=prevNode;
            prevNode=curNode;
            curNode=nextNode;
        }
        return newHead;
    }
    //删除链表中等于给定值 val 的所有节点。
    public ListNode removeElements (ListNode head,int val){
        if(head==null){
            return null;
        }
        ListNode prev=head;
        ListNode cur=prev.next;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
                cur=prev.next;
            }else{
                prev=prev.next;
                cur=cur.next;
            }
        }
        if(head.val==val){
            head=head.next;
        }
        return head;
    }
}
