/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermquiz2;

/**
 *
 * @author TIPQC
 */
public class MidtermQuiz2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnectionsMYSQL cm = new ConnectionsMYSQL();
        System.out.println("Checking Connections: ");
        cm.CheckConnection();
        
        java.awt.EventQueue.invokeLater(new Runnable () {
            public void run() {
                new AccountForm().setVisible(true);
            }
        });

    }
}
