package main.java.muestras;

import java.util.List;

public class AdministradorDeMuestras {
    private List<Muestra> muestras;

    public List<Muestra> getMuestras() {
        return muestras;
    }

    AdministradorDeMuestras(List<Muestra> muestrasAPoner){
        muestras = muestrasAPoner;
    }

    public void agregarNuevaMuestra(Muestra muestra){
        this.getMuestras().add(muestra);
    }

}
