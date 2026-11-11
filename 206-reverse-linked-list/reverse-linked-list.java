/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode rev(ListNode head){


    //Approch     
        if(head==null||head.next==null) return head;
        
        ListNode a = head.next;
        head.next=null;
        ListNode b = rev(a);
        a.next=head;
        return b;
    }
    public ListNode reverseList(ListNode head) {
    return rev(head);
    }

    

    // //optimized:
    //    ListNode c = head;
    //    ListNode p= null;
    //    ListNode f = null;
    //    while(c!=null){
    //     f=c.next;
    //     c.next=p;
    //     p=c;
    //     c=f;
    //    }
    //    return p;

    // }


    // //bruteforce 
    //     ListNode temp = head;
    //     ArrayList<ListNode> arr = new ArrayList<>(0);
    //     if(head==null){
    //         return null;
    //     }
    //     while(temp!=null){
    //         arr.add(temp);
    //         temp = temp.next;
    //     }
    //    int n = arr.size();
    //    for(int i =n-1;i>0;i--) {
    //     arr.get(i).next=arr.get(i-1);
    //    }
    //    arr.get(0).next=null;
    //    return arr.get(n-1);
    // }
}