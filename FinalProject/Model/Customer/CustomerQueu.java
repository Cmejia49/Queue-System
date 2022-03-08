package Model.Customer;

 
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

public class CustomerQueu extends Observable {

    private Queue<Customer> queue;
    public CustomerQueu() {
        this.queue = new LinkedList<Customer>();
    }
    private void customerQueuChanged(){
        setChanged();
        notifyObservers();
    }

    public void addQueu(Customer customer){
        queue.add(customer);
        customerQueuChanged();
    }
    public Customer peekTop(){
       return queue.peek();
    }
    public void remove(){
             queue.poll() ;
             customerQueuChanged();     
    }
    public int size(){
        return queue.size();
    }

    public Queue<Customer> getQueue(){
        return this.queue;
    }
    
}
