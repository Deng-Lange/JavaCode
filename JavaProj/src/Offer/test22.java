package Offer;


public class test22 {
    //输入一个链表，输出该链表中倒数第 k个节点
    //为了符合大多数人的习惯，本题从 1开始计数，即链表的尾节点是倒数第 1个节点
    //要想得到倒数第 k个结点，就从头开始走 len-k 步
    public int getLength(ListNode head) {
        int length=0;
        for(ListNode cur = head; cur!=null; cur=cur.next){
            length++;
        }
        return length;
    }
    public ListNode getKthFromEnd (ListNode head, int k){
        if(head==null){
            return null;
        }
        if(k<=0){
            return null;
        }
        int len=getLength(head);
        if(k>len){
            return null;
        }
        int steps=len-k;
        ListNode cur=head;
        for(int i=0;i<steps;i++){
            cur=cur.next;
        }
        return cur;
    }
}
