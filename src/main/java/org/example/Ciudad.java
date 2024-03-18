package org.example;

class Ciudad {
    private String nombre;
    private double temperatura;

    public Ciudad(String nombre, double temperatura) {
        this.nombre = nombre;
        this.temperatura = temperatura;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return nombre + ": " + temperatura + "°C";
    }
}