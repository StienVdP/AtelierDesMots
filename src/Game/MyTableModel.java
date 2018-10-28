package Game;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	private Object[][] donnees;
	private String[] titre;
	
	
	public MyTableModel(Object[][]data, String[] title){
		this.donnees=data;
		this.titre=title;
	}
	
	public String getColumnName(int col){
		return this.titre[col];
	}
	
	public int getColumnCount(){
		return this.titre.length;
	}
	
	public int getRowCount(){
		return this.donnees.length;
	}
	
	public Object getValueAt(int l, int c){
		return this.donnees[l][c];
	}
	
	public void setValueAt(Object value, int row, int col) {
		//On interdit la modification sur certaines colonnes !
		if(!this.getColumnName(col).equals("Modifier")&& !this.getColumnName(col).equals("Supprimer")) { 
			this.donnees[row][col] = value;
		}
	}
	   
	public boolean isCellEditable(int row, int col){
		return (this.getColumnName(col).equals("Liste des élèves"))||this.getColumnName(col).equals("Liste des mots")||this.getColumnName(col).equals("Niveau 1")||this.getColumnName(col).equals("Niveau 2")||this.getColumnName(col).equals("Nom et Prénom des joueurs")?false:true;	      
	}
	   
}
