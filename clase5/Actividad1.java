import java.util.*;

class Usuario {
    int id;

    public Usuario(int id) {
        this.id = id;
    }
}

class Actividad1 {
    private final Map<Integer, List<Integer>> adjList;

    public Actividad1() {
        this.adjList = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(int id) {
        if (!adjList.containsKey(id)) {
            adjList.put(id, new ArrayList<>());
        }
    }

    // Seguir a un usuario
    public void seguir(int usuario1, int usuario2) {
        if (adjList.containsKey(usuario1) && adjList.containsKey(usuario2)) {
            List<Integer> seguidos = adjList.get(usuario1);
            if (!seguidos.contains(usuario2)) {
                seguidos.add(usuario2);
            }
        }
    }

    // Dejar de seguir a un usuario
    public void dejarDeSeguir(int usuario1, int usuario2) {
        if (adjList.containsKey(usuario1) && adjList.containsKey(usuario2)) {
            adjList.get(usuario1).remove(Integer.valueOf(usuario2));
        }
    }

    // Lista de usuarios que sigue un usuario
    public List<Integer> listaDeSeguidos(int id) {
        return adjList.getOrDefault(id, new ArrayList<>());
    }

    // Lista de seguidores de un usuario
    public List<Integer> listaDeSeguidores(int id) {
        List<Integer> seguidores = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            if (entry.getValue().contains(id)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }

    public static void main(String[] args) {
        Actividad1 redSocial = new Actividad1();

        redSocial.agregarUsuario(1);
        redSocial.agregarUsuario(2);
        redSocial.agregarUsuario(3);

        redSocial.seguir(1, 2);
        redSocial.seguir(2, 3);
        redSocial.seguir(3, 1);

        redSocial.dejarDeSeguir(1, 2);

        System.out.println("Usuarios seguidos por 1: " + redSocial.listaDeSeguidos(1));
        System.out.println("Usuarios que siguen a 1: " + redSocial.listaDeSeguidores(1));
    }
}
