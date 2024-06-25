package Array;


import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kesha
 */
public class Test {
    public static void main(String [] Args){
        Array <Integer> obj = new Array<>(10);
        obj.add(120);
        obj.add(200);
        obj.add(150);
        Iterator <Integer> ite = obj.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
        System.out.println(obj.contains(120));
        System.out.println(obj.contains(333));
    }
}
