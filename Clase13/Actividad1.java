
1)  El atacante podría intentar realizar las siguientes acciones maliciosas:

   1- Inyección de SQL: Manipular consultas en la base de datos para obtener información sensible.
   2- Fuerza bruta: Intentar adivinar credenciales de acceso mediante múltiples combinaciones.
   3- Ataque de denegación de servicio (DDoS): Sobrecargar los recursos del servidor para dejar la plataforma fuera de servicio.

2)  Funciones del sistema:

   1- Monitorización de patrones de acceso: Identificar solicitudes sospechosas, como múltiples intentos de login fallidos en poco tiempo.
   2- Análisis del tráfico en tiempo real: Detectar anomalías como grandes cantidades de solicitudes similares.
   3- Validación de entradas del usuario: Filtrar entradas sospechosas para evitar inyecciones de código.
   4- Bloqueo de direcciones IP sospechosas: Usar firewalls para evitar acceso de atacantes.
   5- Escaneo de archivos subidos: Analizar documentos en busca de malware.

3) Aplicacion de la poda Alfa-Beta:

Cuando en una rama del arbol de decisión se detecta algun tipo de ataque ya mencionado se aplica la poda
Alfa-Beta, podando esa rama en concreto

4) Arbol de decisión simplificado:

Raíz: Inicio del ataque
        ├── Opción 1: Fuerza bruta
        │     ├── Monitorear intentos de login
        │     └── Detectar alerta
        ├── Opción 2: Inyección SQL
        │     ├── Validar entrada de datos
        │     └── Detectar alerta
        └── Opción 3: Ataque DDoS
               ├── Limitar solicitudes por IP
               └── Detectar alerta
