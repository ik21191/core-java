package mypack2;
import java.io.Serializable;
public class StatusBean implements Runnable, Serializable {
private boolean status;

public StatusBean() {
status = false; //1
}

public synchronized boolean isCompleted() {
return status;
}

public synchronized void setStatus(boolean status) {
this.status = status;
}

public void run() {
try{
Thread.sleep(20000); //2
this.status = true; //3
}catch(InterruptedException e){
e.printStackTrace();
}
}
}

//(annotation)<#1 Processing status is false when the StatusBean is created>
//(annotation)<#2 Simmulates processing time for 20 seconds>
//(annotation)<#3 Sets the status is true once the task is completed>