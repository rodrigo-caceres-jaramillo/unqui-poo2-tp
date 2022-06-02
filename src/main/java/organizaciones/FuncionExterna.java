package organizaciones;

public interface FuncionExterna {

    public Void nuevoEvento(OrganizacioneNoGubernamental organizacion,ZonaDeCobertura zona,Muestra muestra);

    public void ejecutar();
}
