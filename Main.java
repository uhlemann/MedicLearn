package main;
import javax.swing.*;

import org.omg.CORBA.portable.OutputStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame implements ActionListener {

	private JButton ok;
	private JButton back;
	
	private static JCheckBox cb_a;
	private static JCheckBox cb_b;
	private static JCheckBox cb_C;
	private static JLabel question;
	private static JLabel answer_a;
	private static JLabel answer_b;
	private static JLabel answer_C;
	
	public static String frage ;
	
	public static void main(String[] args) {
		
		Main frame = new Main ("Medic Learn V 0.1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 320);
		frame.setLocation(450, 200);

		frame.question = new JLabel(frage);
		frame.question.setLocation(5, 5);
		frame.question.setSize(200, 20);
		frame.question.setBackground(Color.orange);
		frame.getContentPane().add(question);
		
		frame.answer_a = new JLabel("Antwort A ");
		frame.answer_a.setLocation(15, 125);
		frame.answer_a.setSize(200, 20);
		frame.answer_a.setBackground(Color.orange);
		frame.getContentPane().add(answer_a);

		frame.answer_b = new JLabel("Antowrt B ");
		frame.answer_b.setLocation(15, 180);
		frame.answer_b.setSize(200, 20);
		frame.answer_b.setBackground(Color.orange);
		frame.getContentPane().add(answer_b);

		frame.answer_C = new JLabel("Antwort C ");
		frame.answer_C.setLocation(15, 235);
		frame.answer_C.setSize(200, 20);
		frame.answer_C.setBackground(Color.orange);
		frame.getContentPane().add(answer_C);		

		frame.setLayout(null);
		frame.setVisible(true);
	}

	public Main(String title){
		
		super(title);

		ok = new JButton("OK");
		ok.setBounds(285, 265, 55, 20);
		ok.addActionListener(this);
		//ok.setBackground(Color.orange);
		add(ok);
		
		back = new JButton("weiter");
		back.setBounds(345, 265, 70, 20);
		back.addActionListener(this);
		//back.setBackground(Color.orange);
		add(back);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok){
			System.out.println("ok gedrückt");
			lesen();
			
		}
		
		if (e.getSource() == back){
			System.out.println("weiter gedrückt");
			
			
		}
		
	}
	
	public void lesen() {
	BufferedReader bufferedReader = null;
    //Der Pfad zur Textdatei
    String filePath ="C:/test.txt";
    File file = new File(filePath);
    try {
        //Der BufferedReader erwartet einen FileReader. 
        //Diesen kann man im Konstruktoraufruf erzeugen.
        bufferedReader = new BufferedReader(new FileReader(file));
      String line;
      //null wird bei EOF oder Fehler zurueckgegeben
      while (null != (line = bufferedReader.readLine())) {
        //Zeile auf der Konsole ausgeben
        System.out.println(line);
        //Hier kann Ihr Code stehen ...
        frage = line;
      }
    } catch (IOException e1) {
        e1.printStackTrace();
    } finally {
      if (null != bufferedReader) {
        try {
          bufferedReader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
      }
    } 
	}
	
}
