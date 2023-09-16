fun main() {
    val str = readln()
    //println(zadacha1((str)))
    println(zadacha3(str.toInt()))
}

fun zadacha1(string: String): String {
    var res = ""
    var counter = 1
    var i = 1
    var s = string[0]
    for (item in string.substring(1)) {
        i++
        if (s != item || i == string.length) {
            if (counter > 1) {
                res += "$s$counter"
            }
            else {
                res += s
            }
            counter = 1
            s = item
        }
        else {
            counter++
        }
    }
    return res
}

fun zadacha2(string: String) {
    var arrSymbols = Array(string.length){}

}

fun zadacha3(d: Int): Int {
    var d = d
    var bin = 0
    var rank = 1
    var mod: Int
    rank = 1
    while (d > 0) {
        mod = d % 2
        d /= 2
        bin += mod * rank
        rank *= 10
    }
    return bin
}