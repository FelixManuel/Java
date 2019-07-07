# Descripcion
El código que aquí se presenta calcula la ruta más corta entre dos puntos.

La información necesaria para usar este código es:
1 Información del entorno. Este se almacenará como un mapa: 
```sh
Map<String,List<Arista>>
```
La clave del mapa será un nodo del mapa(vértice), y el valor una lista de nodos(vértices), donde cada nodo contendrá el <strong>nombre  del otro extremo del vértice</strong>, así como el <strong>coste</strong> para llegar al mismo.

# Ejemplo
El mapa necesario para usar este código lo facilitamos con el fichero <strong>mapa.txt</strong>, y que se puede encontrar en:
```sh
Rutas\mapa.txt
```
Como se puede ver cada línea contiene:
- Nombre de un extremo.
- Nombre del otro extremo.
- Coste del recorrido para ir de un extremo al otro.
