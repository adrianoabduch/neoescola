package br.com.nce.neoescola.commons;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.
          createEntityManagerFactory("entidades");

    factory.close();
  }
}