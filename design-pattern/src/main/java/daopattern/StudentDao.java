/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

import java.util.*;

/**
 *
 * @author harish
 */
public interface StudentDao 
{
    public List<Student> getAllStudent();
    public Student getStudent(int i);
    public void updateStudent(Student s);
    public void deleteStudent(Student s);
}
