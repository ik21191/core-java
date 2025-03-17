package com.collection.msc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UnModifiableCollection
{
    public static void main(String arr[])
    {
        List list = new ArrayList();
        StringBuffer sb = new StringBuffer("Imran");
        list.add(sb);
        list.add("Gautam");
        list.add("Rahul");
        System.out.println("Before modifiable : " + list);
        //Collection<String> immutableCollection = Collections.unmodifiableCollection(list);//Gives UnModifiable view of Collection
//If we creating UnModifiable list using below, then the modifiable list show latest changes done in original list
        //List<String> immutableCollection = Collections.unmodifiableList(list);//Gives UnModifiable view of List
//If we are creating UnModifiable list using below, then the modifiable list don't show latest changes done in original list
//because we have created modifiable list by copying the elements from original list.
        List<String> immutableCollection = Collections.unmodifiableList(new ArrayList<String>(list));//Gives UnModifiable view of List
        //immutableCollection.add("XYZ");//Will throw UnsupportedOperationException
        list.add("XYZ");sb.append(" Khan");
        System.out.println("After modifiable : " + immutableCollection);
     }
}