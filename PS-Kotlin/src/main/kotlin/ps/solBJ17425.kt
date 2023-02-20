package ps

/*
* 1 ~ 100,000 값을 미리 구한 후 출력한다.
* 입출력이 많아서 buffer reader 를 사용해야 한다.
*
* 1 ~ 100,000 반복을 돌면서 i 의 배수 인덱스 전부 i 를 더한다.
* i 를 더하고 나면 i 번째의 dp 는 끝이므로 이전 dp 값과 더해서 총 g[i] 를 구한다.
* */
private val br = System.`in`.bufferedReader()
fun main()=with(System.`out`.bufferedWriter()) {
    val MAX = 1000001
    val nums = LongArray(MAX) { 1 }
    for (i in 2 until MAX) {
        for (j in i until MAX step i) {
            nums[j] += i.toLong()
        }
        nums[i] += nums[i-1]
    }
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        write("${nums[n]}\n")
    }
    close()
}