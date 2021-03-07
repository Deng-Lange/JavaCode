package LinkedList;

public class Test {
    public int getLength(ListNode head){
        int length=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            length++;
        }
        return length;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        if(fast==null||fast.next==null){
            return null;
        }
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

    public boolean hasCycle(ListNode head) {
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
            newTail.next=new ListNode(cur.val);
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
        return pHead.next;
    }

    public ListNode partition(ListNode pHead, int x){
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
        smallTail.next=largeTail.next;
        return smallHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        }else{
            newTail.next=cur1;
        }
        return newHead.next;
    }

    public ListNode FindKthToTail(ListNode head,int k) {
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

    public ListNode middleNode(ListNode head) {
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

    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode curNode=head;
        ListNode prevNode=null;
        ListNode newHead=null;
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

    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode prev=head;
        ListNode cur=head.next;
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
