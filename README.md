# Puente

### Identifique las variables compartidas y qué métodos actúan sobre ellas
Las variables compartidas seran niñosCruzando y adultosCruzando y los metodos que actuan sobre ellas son quieroCruzar y yaLlegue

### ¿Por qué las variables de instancia adultosCruzando y niñosCruzando son privadas?
Para que la clase Puente sea la unica que las pueda modificar

### Indique qué característica adicional aporta el uso de la palabra synchronized en la definición de los métodos de la clase Puente
Que se puedan ejecutar ambos metodos a la vez

### Indique la funcionalidad de los métodos wait(), notify() y notifyAll()
Permite abrir el lock antes de finalizar la ejecucion del metodo sincronizado

### ¿Cuál sería el resultado si no se llamara al método notifyAll() antes de finalizar la ejecución del método sincronizado yaLlegue()?
Que no se despierta a los hilos de la cola de condicion y como se cierra el lock al entrar al metodo, cualquier hilo que 
pretenda acceder al metodo sincronizado sera bloqueado por la cola principal

### ¿Por qué el método wait() va ubicado dentro de un bloque try-catch?
Para que en caso de no poder recuperar el hilo no se produzca un error en el programa

### Una vez es desbloqueado un hilo, ¿en qué línea de código de la clase Puente se restaura su ejecución?
En el notifyAll(), cuando se avisa al resto de hilos

### Suponga 4 niños cruzando el puente (niñosCruzando=4), y que uno de los niños llega al final del puente (ejecuta yaLlegue()), ¿Qué pasará con los hilos bloqueados?
Seguiran bloqueados hasta que haya otro niño (un cuarto niño) para poder cruzar

### Suponga 2 niños y 1 adulto cruzando el puente (niñosCruzando=2 y adultosCruzando=1), y que el adulto llega al final del puente (ejecuta yaLlegue()), ¿Qué pasará con los hilos bloqueados?
Seguiran bloqueado hasta que haya un adulto u otros dos niños para cruzar el puente

# Adulto

### Indique la función de cada una de las variables de instancia, justificando el motivo por el que están declaradas como privadas
Con puente nos traemos un objeto de tipo puente el cual nos permitira añadir un adulto para que cruce el puente o avisar de que ha llegado. id le instaura un idenficador unico a cada adulto nuevo. x sera un valor numerico el cual multiplicado por 1000 establecera un tiempo para que llegue dicho adulto al final del puente.

### ¿Por qué se llama a los métodos sincronizados con el parámetro true?
Para establecer que la persona que esta entrando al puente es un adulto

### ¿De qué modo se garantiza que un adulto cruce el puente cuando se cumplan las limitaciones de peso?
Esperando un tiempo x * 1000 (en milisegundos) para que lo cruce


# NoAdulto

### Indique las principales diferencias con respecto a la clase Adulto
La clase es exactamente igual, lo unico que cambia es que esta clase esta preparada para usarla cuando entre un niño en vez de un adulto y, por tanto, esAdulto de los metodos sincronizados ha de estar en false y el tiempo de espera sera diferente, definido por un tiempo "y"

### ¿Es de esperar alguna diferencia de comportamiento entre los objetos creados de la clase Adulto y los creados de la clase NoAdulto?
Actuaran de forma diferente en la clase Puente, causando diferencias en la forma en que se usen los condicionales de esta o sus bucles hijos


# TestMonitor

### ¿Cuál es la intención de la instrucción Thread.sleep(500)?
Provocar un delay de medio segundo en la ejecucion de cada hilo. Esto es muy util para entender el correcto funcionamiento del programa

### ¿Para qué se utiliza la variable i en las llamadas a los constructores Adulto y NoAdulto?
Con i generamos un bucle for entre 1 y 10. El valor de i en cada vuelta del bucle sera el id establecido para cada adulto o niño

### ¿Cómo se decide crear un objeto Adulto o NoAdulto?
Dependera si el numero random que creamos en cada iteracion del bucle for es par o impar {(num % 2 == 0)}

### ¿Sería posible que llegaran a crearse 10 objetos de un mismo tipo?
Si totalmente, aunque poco probable porque esto significa que cada uno de los 10 numeros aleatorios que se han generado sean pares o impares por igual

### ¿Podría quedarse algún individuo sin poder cruzar el puente?
Si, en el caso de crear un niño al final, teniendo otros tres niños, se quedarian tres de ellos sin cruzar. Pasa igual con la otra condicion, si se crea un niño y y acaba de cruzar un adulto, tendremos tres niños esperando que no podran cruzar. En caso de crear un adulto, si no tenemos sino dos niños tampoco podremos pasar.
Basicamente dependeremos de las condiciones de los metodos sincronizados.