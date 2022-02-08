package week4.Merge_sort_lawyers;
import java.util.*;
class Solution {

    public static LibraryQueue<Lawyer> sortingSomeLawyer(LibraryQueue<Lawyer> queue) {
        // TODO
        LibraryQueue<Lawyer>tmp1 = new LibraryQueue();
        LibraryQueue<Lawyer>tmp2 = new LibraryQueue();
        while(!queue.isEmpty()){
            Lawyer t = queue.dequeue();
            tmp1.enqueue(t);
            tmp2.enqueue(t);
        }
        while(!tmp1.isEmpty())queue.enqueue(tmp1.dequeue());
        sort(tmp2);
        return tmp2;
    }
    static boolean compare(Lawyer x,Lawyer y){
        if(x.getHourlyWage() == y.getHourlyWage())return x.getTotalIncome()>y.getTotalIncome();
        return x.getHourlyWage()>y.getHourlyWage();
    }
    public static void sort(LibraryQueue<Lawyer> queue) {
        // TODO
        if(queue == null)return;
        int n = queue.size();
        if(n == 0 ||n == 1)return;
        int mid = n/2;
        LibraryQueue<Lawyer>left = new LibraryQueue();
        LibraryQueue<Lawyer>right = new LibraryQueue();
        for(int i=0;i<mid;i++)left.enqueue(queue.dequeue());
        while(!queue.isEmpty())right.enqueue(queue.dequeue());
        sort(left);
        sort(right);
        while(n-- >0){
            if(left.isEmpty())queue.enqueue(right.dequeue());
            else if(right.isEmpty())queue.enqueue(left.dequeue());
            else if(compare(left.front(),right.front()))queue.enqueue(left.dequeue());
            else queue.enqueue(right.dequeue());
        }

    }
}

class Lawyer {

    private int badgeNumber;

    private int numberOfTrials;

    private double hourlyWage;

    private double totalIncome;

    private int numberOfObjections;

    public Lawyer(
            int badgeNumber,
            int numberOfTrials,
            double hourlyWage,
            double totalIncome,
            int numberOfObjections) {
        this.badgeNumber = badgeNumber;
        this.numberOfTrials = numberOfTrials;
        this.hourlyWage = hourlyWage;
        this.totalIncome = totalIncome;
        this.numberOfObjections = numberOfObjections;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public int getNumberOfObjections() {
        return numberOfObjections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lawyer)) return false;
        Lawyer className = (Lawyer) o;
        return badgeNumber == className.badgeNumber
                && numberOfTrials == className.numberOfTrials
                && Double.compare(className.hourlyWage, hourlyWage) == 0
                && Double.compare(className.totalIncome, totalIncome) == 0
                && numberOfObjections == className.numberOfObjections;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                badgeNumber, numberOfTrials, hourlyWage, totalIncome, numberOfObjections);
    }

    @Override
    public String toString() {
        return "Lawyer{"
                + "badgeNumber="
                + badgeNumber
                + ", numberOfTrials="
                + numberOfTrials
                + ", hourlyWage="
                + hourlyWage
                + ", totalIncome="
                + totalIncome
                + ", numberOfObjections="
                + numberOfObjections
                + '}';
    }
}

/**
 * Implements the Queue ADT from the book.
 */
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
