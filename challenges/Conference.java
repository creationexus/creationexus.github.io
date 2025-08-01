package challenges;

// Estás planeando una gran conferencia de programación y has recibido muchas propuestas que han pasado el proceso inicial de revisión. Ahora estás teniendo dificultades para que quepan en los espacios de tiempo previstos para el día del evento. ¡Hay muchas posibilidades! Entonces, has decidido escribir un programa que te ayude.


// La conferencia está dividida en varias temáticas. Cada temática tiene una sesión en la mañana y otra en la tarde.
// Cada sesión contiene múltiples charlas.
// Las sesiones de la mañana empiezan a las 9 AM y deben terminar a las 12 del medio día, para el almuerzo.
// Las sesiones de la tarde empiezan a la 1 PM y deben terminar a tiempo para el evento social.
// El evento social no puede empezar antes de las 4:00 ni después de las 5:00.
// Ninguno de los títulos de las charlas contienen números.
// La duración de todas las charlas está dada en minutos (no horas). También puede tratarse de una charla corta de 5 minutos (lightning).
// Los presentadores serán muy puntuales así que no hay necesidad de programar descansos entre las sesiones.


// Ten en cuenta que dependiendo de cómo resuelves el problema tu solución puede producir diferentes combinaciones u ordenaciones de las charlas en las temáticas, esto es aceptable. No tienes que duplicar exactamente el resultado de ejemplo proporcionado a continuación.


// Entrada de Ejemplo:
// Writing Fast Tests Against Enterprise Rails 60min
// Overdoing it in Python 45min
// Lua for the Masses 30min
// Ruby Errors from Mismatched Gem Versions 45min
// Common Ruby Errors 45min
// Rails for Python Developers lightning
// Communicating Over Distance 60min
// Accounting-Driven Development 45min
// Woah 30min
// Sit Down and Write 30min
// Pair Programming vs Noise 45min
// Rails Magic 60min
// Ruby on Rails: Why We Should Move On 60min
// Clojure Ate Scala (on my project) 45min
// Programming in the Boondocks of Seattle 30min
// Ruby vs. Clojure for Back-End Development 30min
// Ruby on Rails Legacy App Maintenance 60min
// A World Without HackerNews 30min
// User Interface CSS in Rails Apps 30min


// Salida de ejemplo:
// Temática 1:
// 09:00AM Writing Fast Tests Against Enterprise Rails 60min
// 10:00AM Overdoing it in Python 45min
// 10:45AM Lua for the Masses 30min
// 11:15AM Ruby Errors from Mismatched Gem Versions 45min
// 12:00PM Lunch
// 01:00PM Ruby on Rails: Why We Should Move On 60min
// 02:00PM Common Ruby Errors 45min
// 02:45PM Pair Programming vs Noise 45min
// 03:30PM Programming in the Boondocks of Seattle 30min
// 04:00PM Ruby vs. Clojure for Back-End Development 30min
// 04:30PM User Interface CSS in Rails Apps 30min
// 05:00PM Networking Event


// Temática 2:
// 09:00AM Communicating Over Distance 60min
// 10:00AM Rails Magic 60min
// 11:00AM Woah 30min
// 11:30AM Sit Down and Write 30min
// 12:00PM Lunch
// 01:00PM Accounting-Driven Development 45min
// 01:45PM Clojure Ate Scala (on my project) 45min
// 02:30PM A World Without HackerNews 30min
// 03:00PM Ruby on Rails Legacy App Maintenance 60min
// 04:00PM Rails for Python Developers lightning
// 05:00PM Networking Event

public class Conference {
    public static void main(String[] args) {
        // Aquí se puede implementar la lógica para leer las charlas, organizarlas en sesiones y temáticas,
        // y luego imprimir el horario de la conferencia.
        
        // Ejemplo de uso:
        // List<Charla> charlas = cargarCharlas();
        // List<Sesion> sesiones = organizarCharlasEnSesiones(charlas);
        // imprimirHorario(sesiones);
        
        System.out.println("Implementación de la conferencia aún no completada.");
    }
}
