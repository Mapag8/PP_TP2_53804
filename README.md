# SALIDA POR CONSOLA

```
=== EJERCICIO 1: Excepciones y persistencia ===
Evento creado: EV001 - Congreso de Tecnología
Sala asignada: Aula Magna
Actividad creada: Taller de Java (cupo máx: 1)

Inscribiendo a Juan Pérez... OK
Inscribiendo a María López...
ERROR: Cupo excedido en actividad 'Taller de Java'. Cupo máximo: 1

Persistiendo evento EV001...
Evento persistido correctamente en evento_EV001.dat

Recuperando evento EV001...
Evento recuperado: EV001 - Congreso de Tecnología

Recuperando evento inexistente EV999 (caso fallido controlado)...
[ERROR recuperación] evento_EV999.dat (No existe el fichero o el directorio)
El evento EV999 no existe: el flujo continuó correctamente.

[finally] Bloque finally ejecutado: fin del flujo de persistencia.

=== EJERCICIO 2: Certificados ===
--- Evento: EV001 - Congreso de Tecnología ---
Sala: Aula Magna
Costo estimado: $13000.0
Actividades:
[Charla] IA aplicada
[Taller] Taller de Java
[Curso] Curso de Spring
Inscripciones:
  Juan Pérez (legajo 1001) -> IA aplicada (PENDIENTE)
  Juan Pérez (legajo 1001) -> Taller de Java (CONFIRMADA)
  María López (legajo 1002) -> Curso de Spring (CONFIRMADA)

Certificados emitidos:
  Certificado de Taller 'Taller de Java' otorgado a Juan Pérez (legajo 1001)
  Certificado de Curso 'Curso de Spring' otorgado a María López (legajo 1002)
Nota: La Charla 'IA aplicada' NO es certificable.

--- Evento: EV002 - Jornadas de Robótica ---
Sala: Laboratorio 3
Costo estimado: $10000.0
Actividades:
[Charla] Robots del futuro
[Taller] Taller de Arduino
[Curso] Curso de ROS
Inscripciones:
  María López (legajo 1002) -> Taller de Arduino (CONFIRMADA)
  Juan Pérez (legajo 1001) -> Curso de ROS (CONFIRMADA)

Certificados emitidos:
  Certificado de Taller 'Taller de Arduino' otorgado a María López (legajo 1002)
  Certificado de Curso 'Curso de ROS' otorgado a Juan Pérez (legajo 1001)

=== EJERCICIO 3: Filtrado por tipo y cálculo de costos ===

--- Evento: EV001 - Congreso de Tecnología ---
Filtrado por Charla: 1 actividad(es)
[Charla] IA aplicada
  Costo materiales Charlas: $0.0
Filtrado por Taller: 1 actividad(es)
[Taller] Taller de Java
  Costo materiales Talleres: $5000.0
Filtrado por Curso: 1 actividad(es)
[Curso] Curso de Spring
  Costo materiales Cursos: $3000.0

Costo materiales TOTAL del evento EV001: $8000.0

--- Evento: EV002 - Jornadas de Robótica ---
Filtrado por Charla: 1 actividad(es)
[Charla] Robots del futuro
  Costo materiales Charlas: $0.0
Filtrado por Taller: 1 actividad(es)
[Taller] Taller de Arduino
  Costo materiales Talleres: $2000.0
Filtrado por Curso: 1 actividad(es)
[Curso] Curso de ROS
  Costo materiales Cursos: $4000.0

Costo materiales TOTAL del evento EV002: $6000.0

Tipos de listas verificados:
  List<Charla> OK
  List<Taller> OK
  List<Curso> OK

Cantidad total de eventos creados: 3
```
