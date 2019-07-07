package bean;

import java.util.ArrayList;
import java.util.List;

public class Ruta implements Comparable<Ruta>{
    //Atributos
    private double coste;
    private List<Arista> aristas;
    
    //Métodos GETTER y SETTER
    public double getCoste() { return coste; }
    public void setCoste(double coste) { this.coste = coste; }

    public List<Arista> getAristas() {
        if(aristas == null){
            aristas = new ArrayList<>();
        }
        return aristas;
    }
    public void setAristas(List<Arista> aristas) { this.aristas = aristas; }    

    @Override
    public int compareTo(Ruta o) {
        if(coste < o.coste){
            return -1;
        } else if (coste > o.coste){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("La ruta a seguir es: ");
        aristas.forEach((arista) -> {
            texto.append(arista.getNodo()).append("-");
        });
        texto.deleteCharAt(texto.length()-1);
        texto.append("\nCon un coste de ").append(coste);
        
        return texto.toString();
    }    
    
    //Métodos
    public void anadirArista(Arista arista){
        getAristas().add(arista);
        coste += arista.getCoste();
    }
    
    public Ruta crearCopia(){
        Ruta copiaRuta = new Ruta();
        copiaRuta.setCoste(getCoste());
        Arista copiaArista;
        for(Arista arista: getAristas()){
            copiaArista = new Arista();
            copiaArista.setCoste(arista.getCoste());
            copiaArista.setNodo(arista.getNodo());
            copiaRuta.getAristas().add(copiaArista);
        }
        
        return copiaRuta;
    }
    
    public boolean existe(String nodo){
        boolean existe = false;
        
        for(Arista arista: getAristas()){
            if(arista.getNodo().equals(nodo)){
                existe = true;
            }
        }
        
        return existe;
    }
}