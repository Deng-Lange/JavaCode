package Test0328;

import java.util.*;

public class Test {
    public int singleNumber1(int[] nums) {
        int ret=0;
        for(int x:nums){
            ret^=x;
        }
        return ret;
    }
    public int singleNumber2(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            Integer value=map.get(x);
            if(value==null){
                map.put(x,1);
            }else{
                map.put(x,value+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        for(Node cur=head;cur!=null;cur=cur.next){
            map.put(cur,new Node(cur.val));
        }
        for(Node oldNode=head;oldNode!=null;oldNode=oldNode.next){
            Node newNode=map.get(oldNode);
            Node newNodeNext=map.get(oldNode.next);
            Node newNodeRandom=map.get(oldNode.random);
            newNode.next=newNodeNext;
            newNode.random=newNodeRandom;
        }
        return map.get(head);
    }

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            Integer value=map.get(word);
            if(value==null){
                map.put(word,1);
            }else{
                map.put(word,value+1);
            }
        }
        List<String> wordList=new ArrayList<>(map.keySet());
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1=0;
                int count2=0;
                if(count1==count2){
                    return o1.compareTo(o2);
                }
                return count2-count1;
            }
        });
        return wordList.subList(0,k);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String expected=scanner.next();
            String actual=scanner.next();
            expected=expected.toUpperCase();
            actual=actual.toUpperCase();
            Set<Character> actualSet=new HashSet<>();
            for(int i=0;i<actual.length();i++){
                actualSet.add(actual.charAt(i));
            }
            Set<Character> brokenSet=new HashSet<>();
            for(int i=0;i<expected.length();i++){
                char c=expected.charAt(i);
                if(actualSet.contains(c)){
                    continue;
                }
                if(brokenSet.contains(c)){
                    continue;
                }
                System.out.println(c);
                brokenSet.add(c);
            }
        }
        System.out.println();
    }
}
