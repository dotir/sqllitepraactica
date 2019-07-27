package com.example.sqllitepraactica;

public class Automovil {
    private int id;
    private String Matricula;
    private String Color;

    public Automovil(int id, String matricula, String color) {
        this.id = id;
        Matricula = matricula;
        Color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
