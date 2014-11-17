package nbsDiv;

import java.io.Console;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NbsDiv extends Screen{
	

	static String title = "Divisors calculater";
	static JLabel titleLabel = new JLabel(title);
	static JTextField text1 = new JTextField();
	static JLabel label1 = new JLabel("Calculate an int's divisors");
	static JButton button1 = new JButton("Calc");
	static JLabel label2 = new JLabel("Calculate smallest int");
	static JLabel label21 = new JLabel("with x divisors");
	static JTextField text2 = new JTextField();
	static JButton button2 = new JButton("Calc");
	static JLabel label3 = new JLabel("Set console int printer");
	static JTextField text3 = new JTextField();
	static JButton button3 = new JButton("Set");
	static JLabel label4 = new JLabel("Count 1 and it self as");
	static JLabel label41 = new JLabel("divisors");
	static JTextField text4 = new JTextField();
	static JButton button4 = new JButton("Set");
	
	public static void main(String[] args) {
		
		Screen screen = new Screen();
		screen.setDefaultCloseOperation(EXIT_ON_CLOSE);
		screen.setSize(Reference.width, Reference.height);
		screen.setVisible(true);
		screen.setLocation(Reference.xPos, Reference.yPos);
		screen.setResizable(false);

		screen.add(titleLabel);
		screen.add(label1);
		screen.add(text1);
		screen.add(button1);
		screen.add(label2);
		screen.add(label21);
		screen.add(text2);
		screen.add(button2);
		screen.add(label3);
		screen.add(text3);
		screen.add(button3);
		screen.add(label4);
		screen.add(label41);
		screen.add(text4);
		screen.add(button4);
		titleLabel.setBounds(Reference.width / 2 - 50, 3, 300, 20);
		label1.setBounds(5, 40, 150, 20);
		text1.setBounds(5, 60, 75, 20);
		button1.setBounds(85, 60, 60, 20);
		label2.setBounds(5, 100, 150, 20);
		label21.setBounds(5, 120, 150, 20);
		text2.setBounds(5, 140, 75, 20);
		button2.setBounds(85, 140, 60, 20);
		label3.setBounds(200, 40, 150, 20);
		text3.setBounds(200, 60, 75, 20);
		button3.setBounds(280, 60, 60, 20);
		label4.setBounds(200, 100, 150, 20);
		label41.setBounds(200, 120, 150, 20);
		text4.setBounds(200, 140, 75, 20);
		button4.setBounds(280, 140, 60, 20);
		
		Handler handler = new Handler();
		button1.addActionListener(handler);
		button2.addActionListener(handler);
		button3.addActionListener(handler);
		button4.addActionListener(handler);
	}
	
	public static void startTimer() {
		Reference.startTime = System.nanoTime();
	}

	public static void stopTimer() {
		Reference.stopTime = System.nanoTime();
	}

	public static String getTime() {
		return Long.toString((Reference.stopTime - Reference.startTime)/1000000000) + "s. or " + Long.toString(Reference.stopTime - Reference.startTime) + " nano s.";
	}

	public static int nbsDiv(int x){
		int divisorNb = 0;
		if(x != Reference.primes[Reference.nextPrime]){
			//System.out.println("Not prime.");
			int divisor = 2;
			while(x % divisor != 0 && divisor < x){
				divisor++;
			}
			//System.out.println("First devisor: " + divisor);
			if (x != divisor && x != 1){
				//System.out.println("x different then " + divisor);
				divisorNb++;
				int smallOppDevisor = x / divisor;
				//System.out.println(divisor + " and " + smallOppDevisor + " divide " + x);
				
				if(divisor != smallOppDevisor){
					divisorNb++;
				}
				divisor++;
				while(divisor < smallOppDevisor){
					if(x % divisor == 0){
						divisorNb++;
						smallOppDevisor = x / divisor;
						//System.out.println(divisor + " and " + smallOppDevisor + " divide " + x);
						if(divisor != smallOppDevisor){
							divisorNb++;
						}
					}
					divisor++;
					
				}
			}
		}else{
			if(Reference.nextPrime + 1 < Reference.primes.length){
				Reference.nextPrime++;
			}
		}
		if (divisorNb > Reference.maxDiv){
			Reference.maxDiv = divisorNb;
		}
		return divisorNb;
	}

}
