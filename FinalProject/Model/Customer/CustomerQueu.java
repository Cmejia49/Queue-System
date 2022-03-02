package Model.Customer;

 
import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueu {

    private Queue<Customer> queue;
    public CustomerQueu() {
        this.queue = new LinkedList<Customer>();
    }

    public void addQueu(Customer customer){
        queue.add(customer);
    }
    public String peekTop(){
       return queue.peek().toString();
    }
    public String removeQueu(){
        return queue.poll().toString();
    }
    
}
