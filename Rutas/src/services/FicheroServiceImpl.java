package services;

import bean.Arista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FicheroServiceImpl implements FicheroService{

    @Override
    public Map<String, List<Arista>> cargarMapa() {
            Map<String, List<Arista>> mapa = new HashMap<>();
            File archivo;
            FileReader fr = null;
            BufferedReader br;        
        try {
            archivo = new File(MAPA);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            String[] partes;
            while((linea=br.readLine()) != null){
                partes = linea.split(",");
                anadirCiudadDestinoACiudadOrigen(mapa, partes[0], partes[1], partes[2]);
                anadirCiudadDestinoACiudadOrigen(mapa, partes[1], partes[0], partes[2]);
            }
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(FicheroServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try { 
                if( fr != null ){                       
                    fr.close();
                } 
            } catch (IOException ex) {
                Logger.getLogger(FicheroServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        return mapa;
    }    
    
    private void anadirCiudadDestinoACiudadOrigen(Map<String, List<Arista>> mapa, String ciudadOrigen, String ciudadDestino, String distancia){
        List<Arista> aristas;
        
        Arista arista = new Arista();
        arista.setCoste(Double.parseDouble(distancia));
        arista.setNodo(ciudadDestino);
        
        if(mapa.containsKey(ciudadOrigen)){            
            mapa.get(ciudadOrigen).add(arista);
        } else {
            aristas = new ArrayList<>();
            aristas.add(arista);            
            mapa.put(ciudadOrigen, aristas);
        }        
    }
}