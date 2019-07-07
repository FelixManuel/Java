
import bean.Ruta;
import java.util.PriorityQueue;
import services.FicheroService;
import services.FicheroServiceImpl;
import services.RutaService;
import services.RutaServiceImpl;

public class Main {

    public static void main(String args[]){
        RutaService servicioRuta = new RutaServiceImpl();
        FicheroService servicioFichero = new FicheroServiceImpl();
        PriorityQueue<Ruta> rutas = new PriorityQueue<>();
        Ruta ruta = servicioRuta.getRutaCorta(servicioFichero.cargarMapa(), "CADIZ", "GERONA", rutas);
        System.out.println(ruta.toString());
    }
}
