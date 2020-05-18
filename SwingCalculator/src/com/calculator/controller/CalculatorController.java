package com.calculator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.calculator.view.CalculatorUI;

public class CalculatorController {

	private CalculatorUI view;
	
	
	public class NumPadButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder builder = new StringBuilder();
			builder.append(view.getText());
			builder.append(((JButton)(e.getSource())).getText());
			view.setText(builder.toString());
		}

	}
	
	public class ClearButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.clearTextPanel();
		}
		
	}
	
	private class EqualsButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	private class OperatorButtonlistener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			StringBuilder builder = new StringBuilder();
			builder.append(view.getText());
			builder.append(((JButton)(e.getSource())).getText());
			view.setText(builder.toString());
		}
		
	}
	
	public CalculatorController() {
		view = new CalculatorUI(new NumPadButtonListener(),new ClearButtonListener(),new EqualsButtonListener(),new OperatorButtonlistener());
		view.display();
	}
}
