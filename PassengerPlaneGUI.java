// WORK IN PROGRESS - NOT COMPLETE!

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PassengerPlaneGUI extends JFrame implements ActionListener{
	
	public static final int W = 500;
	public static final int H = 450;
	private final int ROWS = 7;
	private final int COLS = 4;
	private int count = 0;
	private PassengerSeat[][] Seats = new PassengerSeat[ROWS][COLS];
	
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel middlePanel = new JPanel(new BorderLayout());
	private JPanel bottomPanel = new JPanel(new BorderLayout());
	private JPanel displayPanel = new JPanel (new BorderLayout());
	private JPanel inputPanel = new JPanel(new FlowLayout());
	private JPanel actionPanel = new JPanel(new FlowLayout());
	private JPanel outputPanel = new JPanel (new BorderLayout());
	
	private JLabel rowLbl = new JLabel("Seat Row: ");
	private JLabel colLbl = new JLabel("Seat Letter: ");
	
	private JTextField rowInput = new JTextField(1);
	private JTextField colInput = new JTextField(1);
	
	//JTextPane is like JTextArea, but with the added functionality of being able to align text
	private JTextPane displayPane = new JTextPane();
	
	private JTextArea outputField = new JTextArea();
	
	// These two lines of code are used to center-align the displayPane
	private StyledDocument doc = displayPane.getStyledDocument();
	private SimpleAttributeSet center = new SimpleAttributeSet();
	
	private JButton bookBtn = new JButton("Book Seat");
	private JButton unbookBtn = new JButton("Unbook Seat");
	private JButton finishBtn = new JButton("Finish");
	
	public PassengerPlaneGUI(String title) {
		super(title);
		this.setSize(W, H);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));
		buildPanels();
		addPanelsToFrame();
		populatePlane();
		addListeners();
		displayPane.setEditable(false);
		
		
		// These three lines center the text in the displayPane
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		displayPane.setText(displaySeats());
	}
	
	
	private void buildPanels() {
		displayPanel.add(displayPane);
		
		inputPanel.add(rowLbl);
		inputPanel.add(rowInput);
		inputPanel.add(colLbl);
		inputPanel.add(colInput);
		
		actionPanel.add(bookBtn);
		actionPanel.add(unbookBtn);
		actionPanel.add(finishBtn);
		
		outputPanel.add(outputField);
		
		topPanel.add(displayPanel, BorderLayout.CENTER);
		
		middlePanel.add(inputPanel, BorderLayout.CENTER);
		middlePanel.add(actionPanel, BorderLayout.SOUTH);
		bottomPanel.add(outputPanel, BorderLayout.CENTER);
		
	}
	
	private void addListeners(){
		bookBtn.addActionListener(this);
		unbookBtn.addActionListener(this);
		finishBtn.addActionListener(this);
	}
	
	private void addPanelsToFrame() {
		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		
		if (callingBtn.equals("Book Seat")){
			String seatRow = rowInput.getText();
			String seatCol = colInput.getText();
		}
		else if (callingBtn.equals("Unbook Seat")){
			String seat = inputField.getText();
		}
		else if (callingBtn.equals("Finish")){
	
}
	}


	public void plusCount(){
		this.count++;
	}
	
	public PassengerSeat getSeat(int row, int col) {
		return this.Seats[row - 1][col - 1];
	}
	
	public void populatePlane(){
		for (int outCount = 0; outCount < ROWS; outCount++){
			for (int inCount = 0; inCount < COLS; inCount++){
				PassengerSeat tempSeat = new PassengerSeat();
				this.Seats[outCount][inCount] = tempSeat;
			}
		}
		
	}
	
	public void addSeat(int row, int col){
		PassengerSeat newSeat = new PassengerSeat();
		newSeat.occupySeat();
		Seats[row - 1][col - 1] = newSeat;
	}
	
	// The displaySeats() method has been changed to return a String instead of printing the output to work in tandem with the JTextPane
	public String displaySeats(){
		String identifier = "";
		for (int outCount = 0; outCount < ROWS; outCount++){
			identifier = identifier.concat((outCount + 1) + "\t\t");
			for (int inCount = 0; inCount < COLS; inCount++){
				switch (inCount) {
				case 0: identifier = identifier.concat(Seats[outCount][inCount].returnSeatLetter("A"));
						break;
				case 1: identifier = identifier.concat(Seats[outCount][inCount].returnSeatLetter("B"));
						break;
				case 2: identifier = identifier.concat(Seats[outCount][inCount].returnSeatLetter("C"));
						break;
				case 3: identifier = identifier.concat(Seats[outCount][inCount].returnSeatLetter("D"));
						break;
				}
				identifier = identifier.concat("\t\t");
			}
			identifier = identifier.concat("\n");
		}
		identifier = identifier.concat("\n");
		return identifier;
	}
	
	public static void main(String[] args) {
		PassengerPlaneGUI plane = new PassengerPlaneGUI("My GUI'd Plane");
		plane.setVisible(true);
		System.out.println(plane.displaySeats());
		

	}
}
