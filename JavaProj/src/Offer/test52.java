package Offer;

public class test52 {
    //输入两个链表，找出它们的第一个公共节点。
    /*
    1、分别求出两个链表的长度 l1，l2
    2、看两个链表谁长，
       如果 l1>l2，就让 cur1 先走 l1-l2 步
       如果 l1<l2，就让 cur2 先走 l2-l1 步
    3、此时 cur1 和 cur2 处在同一起跑线上，让他俩同时往后走，看是否相遇
       相遇时的位置就是两个链表的交点
     */
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
    public int getLength(ListNode head) {
        int length=0;
        for(ListNode cur=head;cur!=null;cur=cur.next){
            length++;
        }
        return length;
    }

    /*
    设「第一个公共节点」为 node，
   「链表 headA」的节点数量为 a，「链表 headB」的节点数量为 b，
   「两链表的公共尾部」的节点数量为 c，则有：
    头节点 headA 到 node 前，共有 a−c 个节点；
    头节点 headB 到 node 前，共有 b−c 个节点；

    考虑构建两个节点指针 A，B 分别指向两链表头节点 headA，headB，做如下操作：
    指针 A 先遍历完链表 headA，再开始遍历链表 headB，当走到 node 时，共走步数为：
    a+(b−c)
    指针 B 先遍历完链表 headB，再开始遍历链表 headA，当走到 node 时，共走步数为：
    b+(a−c)
    如下式所示，此时指针 A，B 重合，有两种情况：
    a+(b−c)=b+(a−c)
    若两链表有公共尾部 (即 c>0 )：指针 A，B 同时指向「第一个公共节点」node。
    若两链表无公共尾部 (即 c=0 )：指针 A，B 同时指向 null。
    因此返回 A 即可。
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
