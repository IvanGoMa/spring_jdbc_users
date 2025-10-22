package com.ra2.users.com_ra2_users.model;

import java.util.Date;


public class User {
    private long id;
    private String nom;
    private String descripcio;
    private String email;
    private String contrasenya;
    private Date ultimAcces;
    private Date data_creacio;
    private Date data_actualitzat;
    
    public User(long id, String nom, String descripcio, String email, String contrasenya, Date ultimAcces,
            Date data_creacio, Date data_actualitzat) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.email = email;
        this.contrasenya = contrasenya;
        this.ultimAcces = ultimAcces;
        this.data_creacio = data_creacio;
        this.data_actualitzat = data_actualitzat;
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
    public void setUltimAcces(Date ultimAcces) {
        this.ultimAcces = ultimAcces;
    }
    public void setData_creacio(Date data_creacio) {
        this.data_creacio = data_creacio;
    }
    public void setData_actualitzat(Date data_actualitzat) {
        this.data_actualitzat = data_actualitzat;
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
    public Date getUltimAcces() {
        return ultimAcces;
    }
    public Date getData_creacio() {
        return data_creacio;
    }
    public Date getData_actualitzat() {
        return data_actualitzat;
    }
    
    
}
