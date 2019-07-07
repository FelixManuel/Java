package services;

import bean.Arista;
import bean.Ruta;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RutaServiceImpl implements RutaService{
    
    @Override
    public Ruta getRutaCorta(Map<String, List<Arista>> mapa, String origen, String destino, PriorityQueue<Ruta> rutas){
        Ruta ruta = new Ruta();
        Arista arista = new Arista();
        arista.setNodo(origen);
        ruta.anadirArista(arista);
        
        //Mientras no se llegue a destino
        while(!ruta.getAristas().get(ruta.getAristas().size()-1).getNodo().equals(destino)){
            //Cargamos en rutas todos los adyacentes que tiene asociada la ruta
            cargarAdyacentes(mapa, rutas, ruta, origen);
            origen = rutas.peek().getAristas().get(rutas.peek().getAristas().size()-1).getNodo();
            ruta = rutas.poll();
        }
        
        return ruta;
    }
    
    private void cargarAdyacentes(Map<String, List<Arista>> mapa, PriorityQueue<Ruta> rutas, Ruta ruta, String origen){
        if(mapa.containsKey(origen)){
            Ruta copiaRuta;
            for(Arista arista:mapa.get(origen)){
                copiaRuta = ruta.crearCopia();
                if(!ruta.existe(arista.getNodo())){
                    copiaRuta.anadirArista(arista);
                    rutas.add(copiaRuta);
                }                
            }
        }
    }
}