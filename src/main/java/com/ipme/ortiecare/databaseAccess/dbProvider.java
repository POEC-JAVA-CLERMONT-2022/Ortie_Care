package com.ipme.ortiecare.databaseAccess;

import java.sql.*;
import java.util.*;

public class dbProvider {
	
	// INWORK

	
	private static void affiche(String message) {
	    System.out.println(message);
	  }

	  private static void arret(String message) {
	    System.err.println(message);
	    System.exit(99);
	  }

	  public static boolean testCo()
	  {
		  return true;
	  }
	  
	  public static void test() {
	    Connection con = null;
	    ResultSet resultats = null;
	    String requete = "";
	  
	    // chargement du pilote
	    try {
	      Class.forName("org.gjt.mm.mysql.Driver").newInstance();
	    } catch (Exception e) {
	      arret("Impossible decharger le pilote jdbc pour mySQL");
	    }

	    //connexion a la base de données
	    affiche("connexion a la base de donnees");
	    try {

	      String DBurl = "jdbc:mysql://localhost/testjava";
	      con = DriverManager.getConnection(DBurl);
	    } catch (SQLException e) {
	      arret("Connexion a la base de donnees impossible");
	    }

	    //creation et execution de la requête
	    affiche("creation et execution dela requête");
	    requete = "SELECT * FROM personne";

	    try {
	      Statement stmt = con.createStatement();
	      resultats = stmt.executeQuery(requete);
	    } catch (SQLException e) {
	      arret("Anomalie lors de l'execution de la requete");
	    }
	 
	    //parcours des données retournees
	    affiche("Parcours des donnees retournees");
	    try {
	      ResultSetMetaData rsmd = resultats.getMetaData();
	      int nbCols = rsmd.getColumnCount();
	      boolean encore = resultats.next();

	      while (encore) {

	        for (int i = 1; i <= nbCols; i++)
	          System.out.print(resultats.getString(i) + "");

	        System.out.println();
	        encore = resultats.next();
	      }

	      resultats.close();
	    } catch (SQLException e) {
	      arret(e.getMessage());
	    }

	    affiche("fin du programme");
	    System.exit(0);
	  }
}
