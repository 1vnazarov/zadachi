fun main() {
    print(
        """
        1: на вход функция принимает строку и возвращает количество подряд идущих одинаковых символов во введенной строке
        2: на вход функция принимает строку и возвращает количество различных символов во введенной строке в алфавитном порядке
        3: на вход функция принимает число в десятичной системе и возвращает это число в двоичной системе
        4: на вход функция принимает строку с математическим примером и возвращает результат вычисления
        5: на вход функция принимает строку, содержащую два числа, n и x, разделенныые пробелом и возвращает показатель степени для которого выполняется равенство x^y = n, если он есть. Иначе - сообщение об ошибке
        6: на вход функция принимает два числа и возвращает созданные из них нечетные числа, если возможно. Иначе - сообщение об ошибке
        Выберите функцию для проверки: """.trimIndent()
    )
    when (readln()) {
        "1" -> {
            print("Введите строку: ")
            println("Количество подряд идущих одинаковых символов во введенной строке: " + zadacha1(readln()))
        }

        "2" -> {
            print("Введите строку: ")
            println("Количество различных символов во введенной строке в алфавитном порядке: " + zadacha2(readln()))
        }

        "3" -> {
            print("Введите число: ")
            println("Число в двоичной системе: " + zadacha3(readln().toInt()))
        }

        "4" -> {
            print("Введите математический пример: ")
            println("Результат вычисления: " + zadacha4(readln()))
        }

        "5" -> {
            print("Введите два числа через пробел: ")
            println("Показатель степени: " + zadacha5(readln()))
        }

        "6" -> {
            print("Введите первое число: ")
            val str1 = readln()
            print("Введите второе число: ")
            val str2 = readln()
            println("Нечетные числа, созданные из двух чисел: " + zadacha6(str1, str2))
        }
    }
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
            } else {
                res += s
            }
            counter = 1
            s = item
        } else {
            counter++
        }
    }
    return res
}

fun zadacha2(string: String): String {
    var res = ""
    val charCount = mutableMapOf<Char, Int>()
    string.forEach { char ->
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }
    charCount.toSortedMap().forEach { (char, count) ->
        res += "$char - $count\n"
    }
    return res
}

fun zadacha3(d: Int): Int {
    var d = d
    var bin = 0
    var rank = 1
    var mod: Int
    while (d > 0) {
        mod = d % 2
        d /= 2
        bin += mod * rank
        rank *= 10
    }
    return bin
}

fun zadacha4(string: String): Float {
    var op = ""
    var n1 = ""
    var n2 = ""
    for (char in string.replace(" ", "")) {
        if (n1 == "") {
            n1 += char
        } else {
            if (op != "") {
                n2 += char
            } else {
                op = char.toString()
            }
        }
    }
    var res = 0.0f
    val l = n1.toFloat()
    val r = n2.toFloat()
    when (op) {
        "+" -> res = l + r
        "-" -> res = l - r
        "*" -> res = l * r
        "/" -> res = l / r
    }
    return res
}

fun zadacha5(string: String): Any {
    var xStr = ""
    var nStr = ""
    for (char in string) {
        if (char != ' ' && nStr == "") {
            xStr += char
        } else {
            nStr += char
        }
    }
    val n = nStr.replace(" ", "").toInt()
    val x = xStr.toInt()

    if (x <= 0 || n <= 0) {
        return "Основание степени и число должны быть положительными."
    }

    var y = 0
    var power = 1
    while (power <= n) {
        if (power == n) {
            return y
        }
        y++
        power *= x
    }
    return "Целочисленного показателя не существует"
}

fun zadacha6(a: String, b: String): String {
    var str1: String? = null
    var str2: String? = null
    if ("$a$b".toInt() % 2 != 0) {
        str1 = "$a$b"
    }
    if ("$b$a".toInt() % 2 != 0) {
        str2 = "$b$a"
    }
    var res = ""
    if (str1 == null && str2 == null) return "Создать нечетное число невозможно"
    if (str1 != null) res += str1
    if (str2 != null) {
        if (str1 != null) res += " "
        res += str2
    }
    return res
}