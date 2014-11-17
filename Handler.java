package nbsDiv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Handler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == NbsDiv.button1){
			NbsDiv.startTimer();
			int x = NbsDiv.nbsDiv(Integer.parseInt(NbsDiv.text1.getText()));
			NbsDiv.stopTimer();
			JOptionPane.showMessageDialog(null, NbsDiv.text1.getText() + " has " + x + " divisors. It took " + NbsDiv.getTime());
		}else if(e.getSource() == NbsDiv.button2 && !Reference.it1){
			NbsDiv.startTimer();
			Reference.nextPrime = 0;
			Reference.currentNum = 0;
			Reference.maxDiv = 0;
			Reference.recDiv = Integer.parseInt(NbsDiv.text2.getText());
			while(Reference.maxDiv < Reference.recDiv){
				NbsDiv.nbsDiv(Reference.currentNum);
				if(Reference.currentNum % Reference.incrementer == 0){
					System.out.println(Reference.currentNum);
				}
				Reference.currentNum++;
			}
			int x = Reference.currentNum;
			if(x - 1 >= 0){
				x = Reference.currentNum - 1;
			}
			NbsDiv.stopTimer();
			JOptionPane.showMessageDialog(null, "The smallest num with at least " + NbsDiv.text2.getText() + " divisors is " + x + " with " + Reference.maxDiv + ". It took " + NbsDiv.getTime());
		}else if(e.getSource() == NbsDiv.button2 && Reference.it1){
			NbsDiv.startTimer();
			Reference.nextPrime = 0;
			Reference.currentNum = 0;
			Reference.maxDiv = 0;
			Reference.recDiv = Integer.parseInt(NbsDiv.text2.getText());
			while(Reference.maxDiv + 2 < Reference.recDiv){
				NbsDiv.nbsDiv(Reference.currentNum);
				if(Reference.currentNum % Reference.incrementer == 0){
					System.out.println(Reference.currentNum);
				}
				Reference.currentNum++;
			}
			int x = Reference.currentNum - 1;
			NbsDiv.stopTimer();
			JOptionPane.showMessageDialog(null, "The smallest num with at least " + NbsDiv.text2.getText() + " divisors is " + x + " with " + (Reference.maxDiv + 2) + ". It took " + NbsDiv.getTime());
		}else if(e.getSource() == NbsDiv.button3){
			Reference.incrementer = Integer.parseInt(NbsDiv.text3.getText());
		}else if(e.getSource() == NbsDiv.button4){
			if(Integer.parseInt(NbsDiv.text4.getText()) == 1){
				Reference.it1 = true;
			}else if(Integer.parseInt(NbsDiv.text4.getText()) != 1){
				Reference.it1 = false;
			}
		}
	}
}
