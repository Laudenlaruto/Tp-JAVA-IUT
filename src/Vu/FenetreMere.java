package Vu;
import javax.swing.JFrame;

public class FenetreMere extends JFrame 
{
	public static void main(String[] args)
	{
		new FenetreMere("Calendrier");
	}
	
	public FenetreMere(String parTitre)
	{
		super(parTitre);
		PanelFils contentPane = new PanelFils();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		setSize(1000,600);
		setVisible(true); setLocation(200,50);
	}
	
}