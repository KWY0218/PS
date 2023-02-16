package ps

fun main() {
    val n = readln().toInt()
    val cards = readln().split(" ").map{it.toInt()}
    val m = readln().toInt()
    val nums = readln().split(" ").map{it.toInt()}

    val coms = hashMapOf<Int,Boolean>().apply{
        cards.forEach{
            this[it] = true
        }
    }

    nums.forEach{
        if(coms[it] != null) print("1 ")
        else print("0 ")
    }
}