package com.ipme.ortiecare.model;

import java.util.*;
import java.sql.*;

public class dbProvider {

  public static void main(java.lang.String[] args) {
    Connection con = null;
    Statement stmt = null;
    ResultSet resultats = null;
    String requete = "";

    // chargement du pilote
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(99);
    }

    try {
      String DBurl = "jdbc:mysql://localhost:3306/testjava";
      con = DriverManager.getConnection(DBurl);
      stmt = con.createStatement();

      stmt.executeUpdate(
          "INSERT INTO personne (nom, prenom, taille) "
              + "values ('nom1', 'prenom1', 174)",
            Statement.RETURN_GENERATED_KEYS);
      int idGenere = -1;
      resultats = stmt.getGeneratedKeys();
      if (resultats.next()) {
        idGenere = resultats.getInt(1);
      } else {
        System.out.println("Impossible d'obtenir la valeur generee");
      }
      resultats.close();
      resultats = null;
      System.out.println("valeur id genere = " + idGenere);

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (resultats != null) {
        try {
          resultats.close();
        } catch (SQLException ex) {
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
        }
      }
      if (con != null) {
        try {
          con.close();
        } catch (SQLException ex) {
        }
      }
    }

    System.exit(0);
  }

}