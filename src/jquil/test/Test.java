/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jquil.test;

import jquil.core.Qubit;
import jquil.math.Basis;

/**
 *
 * @author ricky_000
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Qubit q1 = new Qubit(Qubit.STANDARD_ZERO);
        q1.measure(Basis.STANDARD);
        System.out.println(q1);
        
        q1.measure(Basis.HADAMARD);
        System.out.println(q1);
    }
    
}
