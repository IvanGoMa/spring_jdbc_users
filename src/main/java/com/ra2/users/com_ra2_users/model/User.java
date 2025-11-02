package com.ra2.users.com_ra2_users.model;

import java.sql.Timestamp;


public class User {
    private long id;
    private String nom;
    private String descripcio;
    private String email;
    private String contrasenya;
    private Timestamp ultimAcces;
    private Timestamp dataCreated;
    private Timestamp dataUpdated;
    
    public User(long id, String nom, String descripcio, String email, String contrasenya, Timestamp ultimAcces,
            Timestamp dataCreated, Timestamp dataUpdated) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.email = email;
        this.contrasenya = contrasenya;
        this.ultimAcces = ultimAcces;
        this.dataCreated = dataCreated;
        this.dataUpdated = dataUpdated;
    }
    public User(){}
    public void setId(long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    public void setUltimAcces(Timestamp ultimAcces) {
        this.ultimAcces = ultimAcces;
    }
    public void setDataCreated(Timestamp dataCreated) {
        this.dataCreated = dataCreated;
    }
    public void setDataUpdated(Timestamp dataUpdated) {
        this.dataUpdated = dataUpdated;
    }
    public long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getDescripcio() {
        return descripcio;
    }
    public String getEmail() {
        return email;
    }
    public String getContrasenya() {
        return contrasenya;
    }
    public Timestamp getUltimAcces() {
        return ultimAcces;
    }
    public Timestamp getDataCreated() {
        return dataCreated;
    }
    public Timestamp getDataUpdated() {
        return dataUpdated;
    }
    @Override
    public String toString() {
        return "User [Nom: " + getNom() + ", Descripció: " + getDescripcio()
                + ", Email:" + getEmail() + ", Contrasenya: " + getContrasenya() + ", Ultim Accés: "
                + getUltimAcces() + ",  Data Creació: " + getDataCreated() + ", Data Actualitzat: "
                + getDataUpdated() + "]";
    }
    
    
}
