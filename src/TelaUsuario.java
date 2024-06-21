import java.awt.*;

public class TelaUsuario extends Frame {
    // creating instances of TextField and Button class  
    TextField tf1, tf2, tf3;    
    Button b1, b2;   

    /* 
     * double valorFinanciamento, int duracaoFinanciamento, double  taxaJurosAnual
     */

    public void exibir() {

    // instantiating objects of text field and button  
        // setting position of components in frame  
        tf1 = new TextField();    
        tf1.setBounds(50, 50, 150, 20);    
        tf2 = new TextField();    
        tf2.setBounds(50, 100, 150, 20);    
        tf3 = new TextField();    
        tf3.setBounds(50, 150, 150, 20);  
        tf3.setEditable(false);   
        b1 = new Button("+");    
        b1.setBounds(50, 200, 50, 50);  
        b2 = new Button("-");    
        b2.setBounds(120,200,50,50);    
        

        // adding components to frame  
        add(tf1);  
        add(tf2);  
        add(tf3);  
        add(b1);  
        add(b2);   
        // setting size, layout and visibility of frame   
        setSize(300,300);    
        setLayout(null);    
        setVisible(true); 

    }
    
}
