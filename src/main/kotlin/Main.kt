import java.io.File
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val file = File("message_file.txt")
    println(decode(file))
}

fun decode(message_file: File): String {
    val inputMap = mutableMapOf<Int, String>()
    message_file.forEachLine {
        val line = it.split(" ")
        val number = line[0].toInt()
        inputMap[number] = line[1]
    }

    val sb = StringBuilder()
    val sortedMap = inputMap.toSortedMap()

    for (i in 1..sortedMap.size) {
        val value = i * (i + 1) / 2
        if (value > sortedMap.lastKey()) {
            break
        }
        sb.append(sortedMap[value]).append(" ")
    }

    if (sb.isNotEmpty()) {
        sb.setLength(sb.length - 1)
    }

    return sb.toString()
}
