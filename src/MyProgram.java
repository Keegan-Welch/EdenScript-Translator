import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgram {
    public static void main(String[] args) {
        //creating instance of JFrame
        JFrame f= new JFrame();
        
        JLabel label1 = new JLabel("EdenScript Translator");
        JLabel label2 = new JLabel("EdenScript Translator");
        JButton b1 = new JButton("Translate!!");
        JTextArea ta1 = new JTextArea();
        JTextArea ta2 = new JTextArea();
        b1.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Scanner input = new Scanner(System.in);
                    StringBuilder builder = new StringBuilder();
                    String outputString = "";
                    
                    ArrayList<String> userInput = new ArrayList<String>(Arrays.asList(ta1.getText().split(" ")));
                    ArrayList<String> translated = new ArrayList<String>();
                    
                    for (String word : userInput) {
                        word = word.replaceAll("[^a-zA-Z]", "");
                        
                        StringBuffer buffer = new StringBuffer(word);
                        buffer.reverse();
                        
                        translated.add(buffer.toString().toLowerCase());
                    }
                    
                    for (int i = 0; i < translated.size(); i++) {
                        if (i == translated.size() - 1) {
                            //System.out.print(translated.get(i));
                            outputString += translated.get(i);
                        } else {
                            outputString += translated.get(i) + " ";
                        }
                    }
                    
                    ta2.setText(outputString);
                }
            }
        );
        
        
        label1.setBounds(0,10,155,20);
        b1.setBounds(155,0, 155, 40);
        ta1.setBounds(0,40,155,120);
        ta2.setBounds(155,40,155,120);
        
        f.add(label1);
        f.add(b1);
        f.add(ta1);
        f.add(ta2);
        
        ta2.setEditable(false);
        
        ta1.setLineWrap(true);
        ta2.setLineWrap(true);

        f.setSize(310, 160);
        f.setLayout(null);
        f.setResizable(false);
        f.setAlwaysOnTop(true);
        f.setTitle("EdenScript Translator");

        f.setVisible(true);
        boolean running = true;

        while (running) {
            if (running == false) {
                f.hide();
            }
        }
    }
}