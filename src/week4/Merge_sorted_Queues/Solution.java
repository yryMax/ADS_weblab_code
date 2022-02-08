package week4.Merge_sorted_Queues;

import java.util.*;
class Solution {

    /**
     * @param queue1 first sorted Queue to be merged
     * @param queue2 second sorted Queue to be merged
     * @return sorted Queue containing all elements from both Queues
     */
    public static LibraryQueue<Integer> merge(
            LibraryQueue<Integer> queue1, LibraryQueue<Integer> queue2) {
        // TODO
        List<Integer> tmp1 = new ArrayList();
        List<Integer> tmp2 = new ArrayList();
        LibraryQueue<Integer> ans = new LibraryQueue();
        if(queue1 == null && queue2 == null)return null;
        if(queue1 == queue2){
            while(!queue2.isEmpty())tmp2.add(queue2.dequeue());
            for(int el: tmp2){
                queue2.enqueue(el);
                ans.enqueue(el);
                ans.enqueue(el);
            }
            return ans;
        }
        if(queue2 != null){
            while(!queue2.isEmpty())tmp2.add(queue2.dequeue());
        }
        if(queue1 != null){
            while(!queue1.isEmpty())tmp1.add(queue1.dequeue());
        }
        int i=0;
        int j=0;
        while(i<tmp1.size() || j<tmp2.size()){
            if(i == tmp1.size())ans.enqueue(tmp2.get(j++));
            else if(j == tmp2.size())ans.enqueue(tmp1.get(i++));
            else if(tmp1.get(i)>tmp2.get(j))ans.enqueue(tmp1.get(i++));
            else ans.enqueue(tmp2.get(j++));
        }
        if(queue1 !=null)for(int el: tmp1)queue1.enqueue(el);
        if(queue2 !=null)for(int el: tmp2)queue2.enqueue(el);
        return ans;
    }
}

class LibraryQueue<T> {

    private LinkedList<T> q;

    public LibraryQueue() {
        this.q = new LinkedList<>();
    }

    public void enqueue(T e) {
        q.add(e);
    }

    public T dequeue() {
        return q.poll();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T front() {
        return q.peek();
    }
}
