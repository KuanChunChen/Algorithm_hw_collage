
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class HW_102403203_Mergesort extends JFrame{
	private JPanel controlPanel;
	private DrawPanel drawPanel; // µe¥¬
	private BorderLayout bord;
	private GridLayout grid;
	private JButton newArrayButton; 
	private JButton MergesortButton;
	private JLabel textLabel;
	int arraynum=100;
	int[] NumArray=new int[arraynum];
	
	
	public static void main(String[] args)
	{
		HW_102403203_Mergesort frm=new  HW_102403203_Mergesort();
		 frm.setSize(600,600);
		 frm.setVisible(true);
	}

	
	
	public HW_102403203_Mergesort(){
		//title
		super("ºtºâªkmergesort");
		bord=new BorderLayout(5,5);
		grid=new GridLayout(1,3);
		setLayout(bord);
		 for(int i=0;i<arraynum;i++)
		 {
			NumArray[i]=i+1;
			System.out.print(NumArray[i]+"  ");
		 }
		
		drawPanel=new DrawPanel();
		controlPanel=new JPanel();
		
		add(drawPanel,bord.CENTER);
		add(controlPanel,bord.SOUTH);
		
		textLabel=new JLabel("");
		newArrayButton=new JButton("NewArray");
		MergesortButton=new JButton("MergeSort");
		
		controlPanel.setBackground(Color.white);
		controlPanel.setLayout(grid);
		controlPanel.add(textLabel);
		controlPanel.add(newArrayButton);
		controlPanel.add(MergesortButton);
		
		newArrayButton.addActionListener(new ButtonHandler());
		MergesortButton.addActionListener(new MergesoertButton());
		
	}
	private class ButtonHandler implements ActionListener 
    {
		public void actionPerformed(ActionEvent event) 
		{
			System.out.println("");
			Graphics g=getGraphics();
			for(int i=0;i<arraynum;i++)
			 {
				 Random rannum = new Random();
				 int ran1=rannum.nextInt(100);
				 int temp=0;
				 temp=NumArray[i];
				 NumArray[i]=NumArray[ran1];
				 g.drawLine(NumArray[i], 0, NumArray[i], NumArray[ran1]);
				 NumArray[ran1]=temp;
				 g.drawLine(NumArray[ran1], 0, NumArray[ran1],NumArray[i] );
				 drawPanel.repaint();
			}
			
			for(int i=0;i<arraynum;i++)
				System.out.print(NumArray[i]+"  ");
		}
    }
	private class MergesoertButton implements ActionListener 
	{
		public void actionPerformed(ActionEvent event) 
		{
			Mergesort(NumArray);
		}
	}
	public class DrawPanel extends JPanel {
		DrawPanel() {
			setBackground( Color.white );
		}
		public void paintComponent( Graphics g ) {
			super.paintComponent( g );
			Graphics2D g2d = ( Graphics2D ) g;
			for(int i=0;i<arraynum;i++){
				g2d.drawLine(i*10,0,i*10, NumArray[i]*5);
			}
		}
	}
	public void Mergesort(int[] NumArray){
		if(NumArray.length>1)
		{
			if(NumArray.length%2==0)
			{
				int[] NumArrayleft=new int[NumArray.length/2];
				int[] NumArrayright=new int[NumArray.length/2];
				for(int i=0;i<NumArray.length/2;i++)
				{
					NumArrayleft[i]=NumArray[i];
					NumArrayright[i]=NumArray[NumArray.length/2+i];
								}
				
				Mergesort(NumArrayleft);
				Mergesort(NumArrayright);
				Merge(NumArrayleft,NumArrayright,NumArray);
			}
			else
			{
				int[] NumArrayleft=new int[NumArray.length/2];
				int[] NumArrayright=new int[NumArray.length/2+1];
				for(int i=0;i<NumArray.length/2;i++)
				{
					NumArrayleft[i]=NumArray[i];
					NumArrayright[i]=NumArray[NumArray.length/2+i];
								}
				
				NumArrayright[NumArray.length/2]=NumArray[NumArray.length-1];
				//System.out.print(NumArray[NumArray.length-1]+"  ");
				//System.out.println("");
				Mergesort(NumArrayleft);
				Mergesort(NumArrayright);
				Merge(NumArrayleft,NumArrayright,NumArray);
			}
		}
		
			
	}
	public void Merge(int[] B,int[] C,int[] A){
		Graphics g=getGraphics();
		Graphics2D g2d = ( Graphics2D ) g;
		g2d.setStroke(new BasicStroke(2));
		int i=0,j=0,k=0;
		int p=B.length;
		int q=C.length;
		while(i<p&&j<q)
		{
			if(B[i]<C[j])
			{
				A[k]=B[i];
				g2d.drawLine(k*10, 0, k*10,B[i]);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				drawPanel.repaint();
				i=i+1;
			}else{
				A[k]=C[j];
				g2d.drawLine(k*10, 0, k*10,C[j]*5);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				drawPanel.repaint();
				j=j+1;
			}
			k=k+1;
		}
		if(i==p)
		{
			for(int num=j;num<q;num++)
			{
				A[k]=C[num];
				g2d.drawLine(k*10, 0, k*10,C[num]*5);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				drawPanel.repaint();
				k=k+1;
			}
		}
		else
		{
			for(int num=i;num<p;num++)
			{
				A[k]=B[num];
				g2d.drawLine(k*10, 0, k*10,B[num]*5);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				drawPanel.repaint();
				k=k+1;
			}
		}
	}
}

 

