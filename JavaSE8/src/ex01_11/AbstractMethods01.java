/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex01_11;

/**
 *
 * @author Tohtetsu Choh
 */
public class AbstractMethods01 {
    interface I{
        public abstract void f();
    }
    
     interface J{
        public abstract void f();
    }
     
     // オーバライドすれば、問題なく実装できる
     class Test implements I, J{

        @Override
        public void f() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
         
     }
}
