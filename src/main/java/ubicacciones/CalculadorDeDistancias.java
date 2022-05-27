package ubicacciones;

public class CalculadorDeDistancias {

    public int distanciaEntreLasUbicaciones(Ubicacion ubicacion1,Ubicacion ubicacion2){
        return this.distanciaEntreLosPuntos(ubicacion1.getLatitud(),ubicacion2.getLatitud()) +    // distancia de latitudes
               this.distanciaEntreLosPuntos(ubicacion1.getLongitud(),ubicacion2.getLongitud()) ;  // distancia de longitudes
    }

    public int distanciaEntreLosPuntos(int y ,int x){
        if(y > x ){   // siempre mayor - menor es 0 o superior
            return y - x;
        }else{
            return x - y;
        }
    }



}
