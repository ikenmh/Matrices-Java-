import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{

	public JLabel l_rows;
	public JLabel l_cols;
	public JLabel main_title;
	public JLabel secondary_title;
	public JTextField rows;
	public JTextField cols;
	public JButton accept;

	public Matrix mt;
	
    public Main(){
		
		setLayout(new BorderLayout());
		setSize(300,150);
		
		l_rows=new JLabel("Row");
		l_cols=new JLabel("Col");
		main_title=new JLabel("Matrix");
		secondary_title=new JLabel("Datos");
		rows=new JTextField("5",20);
		cols=new JTextField("3",20);
		accept=new JButton("Accept");
		
		JPanel information=new JPanel(new GridLayout(2,2));
		information.add(l_rows);
		information.add(rows);
		information.add(l_cols);
		information.add(cols);
		
		add(main_title,BorderLayout.NORTH);
		add(information,BorderLayout.CENTER);
		add(accept,BorderLayout.SOUTH);
		
		setVisible(true);
		
		accept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int r,c;
				r=Integer.parseInt(rows.getText());
				c=Integer.parseInt(cols.getText());
				mt=new Matrix(r,c);
			}
		});
		
    }
    
    
    
    public static void main(String args[]){
		Main m=new Main();
    }
}
