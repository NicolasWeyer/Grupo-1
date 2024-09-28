/*
 Tenemos 4 nodos y las siguientes aristas con sus respectivos pesos:

 1 --> 2, peso 2
 2 --> 4, peso 4
 1 --> 4, peso 5
 4 --> 3, peso 2

Inicializacion de la matriz de distancias

       1      2    3    4
    1  [0]   [2] [INF] [5]
    2 [INF]  [0] [INF] [4]
    3 [INF] [INF] [0] [INF]
    4 [INF] [INF] [2]  [0]

Explicacion de la matriz:
nodo 1 a 1: Distancia 0, ya que es el mismo nodo
nodo 1 a 2: Distancia 2 (Directo, como dado)
nodo 1 a 3: No hay camino directo, asi que INF
nodo 1 a 4: Distancia 5 (Directo, como dado)
nodo 2 a 1: No hay camino directo, asi que INF
nodo 2 a 2: Distancia 0, ya que es el mismo nodo
nodo 2 a 3: No hay camino directo, asi que INF
nodo 2 a 4: Distancia 4 (Directo, como dado)
nodo 3 a 1: No hay camino directo, asi que INF
nodo 3 a 2: No hay camino directo, asi que INF
nodo 3 a 3: Distancia 0, ya que es el mismo nodo
nodo 3 a 4: No hay camino directo, asi que INF
nodo 4 a 1: No hay camino directo, asi que INF
nodo 4 a 2: No hay camino directo, asi que INF
nodo 4 a 3: Distancia 2 (Directo, como dado)
nodo 4 a 4: Distancia 0, ya que es el mismo nodo

*/