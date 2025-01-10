package org.example.exoservlet.persons;

public class Person {
    private int age;
    private String prenom;
    private String nom;


    public Person() {
    }

    public Person(int age, String prenom, String nom) {
        this.age = age;
        this.prenom = prenom;
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return nom + " " +prenom + " : " + age + " ans.";
    }
}
