package Test0328;

public class TestMyHashMap {
    private HashNode[] array=new HashNode[16];
    private int size=0;
    public void push(int key,int value){
        int index=key%array.length;
        for(HashNode cur=array[index];cur!=null;cur=cur.next){
            if(cur.key==key){
                cur.value=value;
                return;
            }
        }
        HashNode newNode=new HashNode(key,value);
        newNode.next=array[index];
        array[index]=newNode;
        size++;
        if(loadFactor()>0.75){
            resize();
        }
    }
    private void resize() {
        HashNode[] newArray=new HashNode[array.length*2];
        for(int i=0;i<array.length;i++){
            HashNode next=null;
            for(HashNode cur=array[i];cur!=null;cur=next){
                next=cur.next;
                int indexNew=cur.key%newArray.length;
                cur.next=newArray[indexNew];
                newArray[indexNew]=cur;
            }
        }
    }
    private double loadFactor(){
        return (double)size/array.length;
    }

    public Integer get(int key) {
        int index=key%array.length;
        for(HashNode cur=array[index];cur!=null;cur=cur.next){
            if(cur.key==key){
                return cur.value;
            }
        }
        return null;
    }
}
