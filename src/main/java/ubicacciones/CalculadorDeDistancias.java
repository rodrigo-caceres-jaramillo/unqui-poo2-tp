package main.java.ubicacciones;

public class CalculadorDeDistancias {
	private static CalculadorDeDistancias instancia;

    public static CalculadorDeDistancias getInstancia(){
        if (instancia == null) {
            instancia = new CalculadorDeDistancias();
        }
        return instancia;
    }
    
    public float distanciaEntreLasUbicaciones(Ubicacion ubicacion1,Ubicacion ubicacion2){
        return this.distanciaEntreLosPuntos(ubicacion1.getLatitud(),ubicacion2.getLatitud()) +    // distancia de latitudes
               this.distanciaEntreLosPuntos(ubicacion1.getLongitud(),ubicacion2.getLongitud()) ;  // distancia de longitudes
    }

    public float distanciaEntreLosPuntos(float y ,float x){
        if(y > x ){
            return y - x;
        }else{
            return x - y;
        }
    }
}
