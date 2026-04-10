package com.entonos.ejercicios;

import java.util.Stack;

public class Pila {
    private Stack<Integer> pila = new Stack<Integer>();
    // Añade el número solo si es mayor que 2 y menor que 20
    public void push (Integer num) {
        if (num > 2 && num < 20)
            pila.push(num);
    }
   
    public Integer pop() {
        if (pila.isEmpty())
            return null;
        else
            return pila.pop();
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public Integer top() {
        if (pila.isEmpty())
            return null;
        else
            return pila.peek();
    }
}
    