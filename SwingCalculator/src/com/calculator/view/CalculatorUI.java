package com.calculator.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculatorUI extends JFrame {

	private static final String FRAME_TITLE = "CALCULATOR";
	private static final char[] OPERATORS = {'+','-','*','/'};
	private JPanel numPAdPanel;
	private JPanel operatorPanel;
	private JPanel resultPanel;
	private JTextArea textArea;
	private ActionListener numPadActionListener;
	private ActionListener clearButtunListener;
	private ActionListener eqeActionListener;
	private ActionListener opratorButtonListener;
	
	public CalculatorUI(ActionListener numPadActionListener,ActionListener clearButtunListener,ActionListener eqeActionListener,ActionListener opratorButtonListener) {
		this.numPadActionListener = numPadActionListener;
		this.clearButtunListener = clearButtunListener;
		this.eqeActionListener = eqeActionListener;
		this.opratorButtonListener = opratorButtonListener;
		setUpFrameDefaultConfigs();
		initializeNumPadPanel();
		initializeOperatorsPanel();
		initializeResultPanel();
		add(numPAdPanel,BorderLayout.CENTER);
		add(operatorPanel,BorderLayout.EAST);
		add(resultPanel,BorderLayout.NORTH);
	}
	
	public void display() {
		setVisible(true);
	}
	
	private void setUpFrameDefaultConfigs() {
		setTitle(FRAME_TITLE);		
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeResultPanel() {
		
		resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout());
		textArea = new JTextArea();
		resultPanel.add(textArea);
	}
	
	
	private void initializeNumPadPanel() {
		
		numPAdPanel = new JPanel();
		numPAdPanel.setLayout(new GridLayout(4,3));
		
		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton(""+i);
			numPAdPanel.add(button);
			button.addActionListener(numPadActionListener);
		}
		JButton button0 = new JButton("0");
		numPAdPanel.add(button0);
		button0.addActionListener(numPadActionListener);	
		initializeClearButton(numPAdPanel);
		initalizeEquelButton(numPAdPanel);
	}
	
	private void initializeClearButton(JPanel panel) {
		JButton buttonC = new JButton("C");
		buttonC.addActionListener(clearButtunListener);
		panel.add(buttonC);
	}
	
	private void initializeOperatorsPanel() {
		
		operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(2,2));
		
		for(Character operator : OPERATORS) {
			JButton button = new JButton(""+operator);
			button.addActionListener(opratorButtonListener);
			operatorPanel.add(button);
		}
	}
	
	private void initalizeEquelButton(JPanel panel) {
		JButton buttonEqu = new JButton("=");
		buttonEqu.addActionListener(eqeActionListener);
		panel.add(buttonEqu);
	}
	
	public void clearTextPanel() {
		((JTextArea)resultPanel.getComponent(0)).setText("");
	}
	
	public void setText(String text) {
		textArea.setText(text);
	}
	
	public String getText() {
		return textArea.getText();
	}

}
