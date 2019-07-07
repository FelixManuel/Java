package services;

import bean.Arista;
import java.util.List;
import java.util.Map;

public interface FicheroService {
    
    String MAPA = "./mapa.txt";

    Map<String, List<Arista>> cargarMapa();
}
