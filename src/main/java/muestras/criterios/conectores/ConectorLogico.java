package main.java.muestras.criterios.conectores;

import java.util.ArrayList;
import java.util.List;

import main.java.muestras.Muestra;

public interface ConectorLogico {

    public List<Muestra> conectarArray(List<Muestra> xs, List<Muestra> ys); // public ArrayList<Muestra> conectarArray(ArrayList<Muestra> xs, ArrayList<Muestra> ys)
