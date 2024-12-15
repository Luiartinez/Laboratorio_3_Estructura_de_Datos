import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("Seleccione una opcion:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un numero")
        println("4. Resolver las Torres de Hanoi")
        println("5. Salir")

        when (readLine()?.toIntOrNull()) {
            1 -> ordenarListaBubbleSort()
            2 -> ordenarListaQuickSort()
            3 -> calcularFactorial()
            4 -> resolverTorresDeHanoi()
            5 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opcion no valida. Intente nuevamente.")
        }
    }
}

fun ordenarListaBubbleSort() {
    println("Ingrese una lista de numeros separados por comas:")
    val input = readLine()
    val lista = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() }?.toMutableList()

    if (lista.isNullOrEmpty()) {
        println("Entrada no valida. Por favor, intente nuevamente.")
        return
    }

    val tiempoEjecucion = measureTimeMillis {
        bubbleSort(lista)
    }

    println("Lista ordenada usando Bubble Sort: $lista")
    println("Tiempo de ejecucion: ${tiempoEjecucion / 1000.0} segundos")
}

fun bubbleSort(lista: MutableList<Int>) {
    for (i in 0 until lista.size - 1) {
        for (j in 0 until lista.size - i - 1) {
            if (lista[j] > lista[j + 1]) {
                val temp = lista[j]
                lista[j] = lista[j + 1]
                lista[j + 1] = temp
            }
        }
    }
}

fun ordenarListaQuickSort() {
    println("Ingrese una lista de numeros separados por comas:")
    val input = readLine()
    val lista = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() }?.toMutableList()

    if (lista.isNullOrEmpty()) {
        println("Entrada no valida. Por favor, intente nuevamente.")
        return
    }

    val tiempoEjecucion = measureTimeMillis {
        val sortedList = quickSort(lista)
        println("Lista ordenada usando Quick Sort: $sortedList")
    }

    println("Tiempo de ejecucion: ${tiempoEjecucion / 1000.0} segundos")
}

fun quickSort(lista: List<Int>): List<Int> {
    if (lista.size <= 1) return lista
    val pivot = lista[lista.size / 2]
    val menores = lista.filter { it < pivot }
    val iguales = lista.filter { it == pivot }
    val mayores = lista.filter { it > pivot }
    return quickSort(menores) + iguales + quickSort(mayores)
}

fun calcularFactorial() {
    println("Ingrese un numero:")
    val numero = readLine()?.toIntOrNull()

    if (numero == null || numero < 0) {
        println("Entrada no valida. Ingrese un numero entero positivo.")
        return
    }

    println("El factorial de $numero es: ${factorial(numero)}")
}

fun factorial(n: Int): Long {
    return if (n == 0) 1 else n * factorial(n - 1)
}

fun resolverTorresDeHanoi() {
    println("Ingrese el numero de discos:")
    val numeroDeDiscos = readLine()?.toIntOrNull()

    if (numeroDeDiscos == null || numeroDeDiscos <= 0) {
        println("Entrada no valida. Ingrese un numero entero positivo.")
        return
    }

    moverTorresDeHanoi(numeroDeDiscos, 'A', 'C', 'B')
}

fun moverTorresDeHanoi(n: Int, origen: Char, destino: Char, auxiliar: Char) {
    if (n == 1) {
        println("Mover disco 1 de Torre $origen a Torre $destino")
        return
    }
    moverTorresDeHanoi(n - 1, origen, auxiliar, destino)
    println("Mover disco $n de Torre $origen a Torre $destino")
    moverTorresDeHanoi(n - 1, auxiliar, destino, origen)
}