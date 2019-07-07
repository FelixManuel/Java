package services;

import bean.Arista;
import bean.Ruta;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public interface RutaService {
    
    Ruta getRutaCorta(Map<String, List<Arista>> mapa, String origen, String destino, PriorityQueue<Ruta> rutas);
}
