/*
 * This Class demonstrates use of Todo annotation defined in Todo.java
 * 
 * @author Yashwant Golecha (ygolecha@gmail.com)
 * @version 1.0
 * 
 */

package com.mypack.annotation;

import com.mypack.annotation.Todo.Priority;

public class BusinessLogic {
    public BusinessLogic() {
        super();
    }
    
    public void compltedMethod() {
        System.out.println("This method is complete");
    }    
    
    @Todo(priority = Priority.HIGH)
    public void notYetStartedMethod() {
        // No Code Written yet
    }
    
    @Todo(priority = Priority.MEDIUM, author = "Uday", status = Todo.Status.STARTED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet
    }

    @Todo(priority = Priority.LOW, status = Todo.Status.STARTED )
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
    }
}
