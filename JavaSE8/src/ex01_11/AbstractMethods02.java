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
public class AbstractMethods02 {

    abstract class S {

        public abstract void f();
    }

    interface J {

        public abstract void f();
    }

    // �I�[�o���C�h����΁A���Ȃ������ł���
    class Test extends S implements J {

        @Override
        public void f() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
