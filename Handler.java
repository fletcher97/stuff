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
		}else if(e.getSource() == NbsDiv.button2){
			NbsDiv.startTimer();
			Reference.nextPrime = 0;
			Reference.currentNum = 0;
			Reference.maxDiv = 0;
			Reference.recDiv = Integer.parseInt(NbsDiv.text2.getText());
			while(Reference.maxDiv < Reference.recDiv){
				int temp = NbsDiv.nbsDiv(Reference.currentNum);
				if(Reference.currentNum % Reference.incrementer == 0){
					System.out.println(Reference.currentNum);
				}
				//System.out.println(Reference.currentNum + " has " + temp + " divisores.");
				Reference.currentNum++;
			}
			int x = Reference.currentNum - 1;
			NbsDiv.stopTimer();
			JOptionPane.showMessageDialog(null, "The smallest num with at least " + NbsDiv.text2.getText() + " divisors is " + x + " with " + Reference.maxDiv + ". It took " + NbsDiv.getTime());
		}
	}

	
}
