import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class Matrix extends JFrame{
	
	private JTextField mat[][];
	private JCheckBox c_cols,c_rows,c_main_diagonal,c_secondary_diagonal;
	private JButton sum;
	private JLabel answer;	
	private int rows,cols;
	
	private int col_min;
	private int row_min;
	private int min;
	
	private String cad_sum="Sum = ";
	
	public Matrix(int n, int m){
		setSize(500,500);
		rows=n;
		cols=m;
		setLayout(new BorderLayout( 5, 5 ));
		c_rows=new JCheckBox("Rows");
		c_cols=new JCheckBox("Cols");
		c_main_diagonal=new JCheckBox("Main Diagonal");
		c_secondary_diagonal=new JCheckBox("Secondary Diagonal");
		sum=new JButton("Sum");
		answer=new JLabel("Sum = ");
		
		JPanel jp=new JPanel(new GridLayout(n,m));
		
		JPanel controls=new JPanel(new GridLayout(4,1));
		controls.add(c_rows);
		controls.add(c_cols);
		controls.add(c_main_diagonal);
		controls.add(c_secondary_diagonal);
		
		JPanel botones=new JPanel(new GridLayout(3,1));
		botones.add(controls);
		botones.add(sum);
		botones.add(answer);
		
		
		mat=new JTextField[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				mat[i][j]=new JTextField();
				mat[i][j].setForeground(Color.BLUE);
				jp.add(mat[i][j]);
			}
		}
		
		add(jp,BorderLayout.CENTER);
		add(botones,BorderLayout.SOUTH);
		
		setVisible(true);
		
		
		sum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetColor();
				getPositionMatrixMin();
				int sum=min; 
				cad_sum="Sum = "+sum+" ";
				
				if(c_rows.isSelected())
					sum+=sumRowElements();
				if(c_cols.isSelected())
					sum+=sumColElements();
				if(c_main_diagonal.isSelected())
					sum+=sumMainDiagonal();
				if(c_secondary_diagonal.isSelected())
					sum+=sumSecondaryDiagonal();
				
				answer.setText(cad_sum +" = "+sum);
			}
		});
		
	}
	
	public int getTextFieldValue(int r,int c){
		return Integer.parseInt(mat[r][c].getText());
	}
	
	public int sumRowElements(){
		int s=0;
		for(int j=0;j<cols;j++){
			if(j!=col_min){
				s+=getTextFieldValue(row_min,j);
				cad_sum+="+ "+getTextFieldValue(row_min,j);
				mat[row_min][j].setForeground(Color.RED);
			}
		}
		return s;
	}
	
	public int sumColElements(){
		int s=0;
		for(int i=0;i<rows;i++){
			if(i!=row_min){
				s+=getTextFieldValue(i,col_min);
				cad_sum+="+ "+getTextFieldValue(i,col_min);
				mat[i][col_min].setForeground(Color.RED);
			}
		}
		return s;
	}
	
	public int sumSecondaryDiagonal(){
		int s=0;
		int j=col_min;
		int i=row_min;
		while(i>=0 && j<=cols-1){
			if(i!=row_min && j!=col_min){
				s+=getTextFieldValue(i,j);
				cad_sum+="+ "+getTextFieldValue(i,j);
				mat[i][j].setForeground(Color.RED);
			}
			i=i-1;
			j=j+1;
		}
		j=col_min;
		i=row_min;
		while(i<=(rows-1) && j>=0){
			if(i!=row_min && j!=col_min){
				s+=getTextFieldValue(i,j);
				cad_sum+="+ "+getTextFieldValue(i,j);
				mat[i][j].setForeground(Color.RED);
			}
			i=i+1;
			j=j-1;
		}
		return s;
	}
	
	public int sumMainDiagonal(){
		int s=0;
		int j=col_min;
		int i=row_min;
		while(i>=0 && j>=0){
			if(i!=row_min && j!=col_min){
				s+=getTextFieldValue(i,j);
				mat[i][j].setForeground(Color.RED);
				cad_sum+="+ "+getTextFieldValue(i,j);
			}
			i=i-1;
			j=j-1;
		}
		j=col_min;
		i=row_min;
		while(i<=(rows-1) && j<=(cols-1)){
			if(i!=row_min && j!=col_min){
				s+=getTextFieldValue(i,j);
				mat[i][j].setForeground(Color.RED);
				cad_sum+="+ "+getTextFieldValue(i,j);
			}
			i=i+1;
			j=j+1;
		}
		return s;
	}
	
	
	public void resetColor(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				mat[i][j].setForeground(Color.BLUE);
			}
		}
	}
	
	public void getPositionMatrixMin(){
		this.min=getTextFieldValue(0,0);
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(min>getTextFieldValue(i,j)){
					min=getTextFieldValue(i,j);
					col_min=j;
					row_min=i;
				}
			}
		}
		
		mat[row_min][col_min].setForeground(Color.RED);
	}
	
}
