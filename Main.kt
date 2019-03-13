import com.sun.jdi.IntegerValue
import jdk.jfr.Frequency
import java.io.*
import java.lang.Exception

fun readFileBook(fileName: String): String {
    try {
        var fileObject = File(fileName)
        var editBook = fileObject.readText()
        return editBook
    } catch (e:Exception){
        e.message
        return ""
    }
}

fun writeFileBook(bookName: String){
    val fileName = "out.txt"
    var fileObject = File(fileName)

    fileObject.writeText(bookName)
}

fun isNumeric(string: String) : Boolean{
    try{
        Integer.parseInt(string)
        return true
    } catch (e: Exception){
        return false
    }
}

//fun highFrequency(lista: ArrayList<String>): Int {
//    val arr = IntArray(lista.size)
//    var count = 0
//        for(it in lista){
//        if(lista.contains(it)){
//            count++
//            arr[lista.indexOf(it)] = count
//        }
//    }
//    arr.sort()
//    return arr.get(0)
//}




fun main() {


    //Memorare all line in string array
    var stringList = mutableListOf<String>()
    val bf = BufferedReader(FileReader("Shadows-of-Childhood.txt"))

    try {
        var temp = bf.readLine()
        while (!temp.equals(null)) {
            stringList.add(temp)
            temp = bf.readLine()
        }
    }catch (e:Exception){
        e.message
    }

    //Delete no of page
    try {
        var iter = stringList.iterator()
        while (iter.hasNext()){
            var str = iter.next()

            if(isNumeric(str.trim())){
                iter.remove()
            }
        }
    } catch (e: Exception){
        e.message
    }


    //Delete multiple space

    for(i in stringList){
        stringList.set(stringList.indexOf(i), i.replace("  +".toRegex()," "))
    }

    //Delete multiple new line

    try{
        var iter = stringList.iterator()
        while(iter.hasNext()){
            var str = iter.next()

            if(str.equals("")){
                iter.remove()
            }
        }
    } catch (e: Exception){
        e.message
    }



    //Delete author
    var map = mutableMapOf<String, Int>()
    for(i in stringList){
        if(map.containsKey(i)){
            map.put(i, map.get(i)!!.plus(1))
        } else {
            map.put(i, 1);
        }
        //val maximumPossibleFrequency = map.get()
    }
//    val keys = map.toList()
//        .sortedBy { (key, value) -> value }
//        .toMap()

    var temp = 0
    var tempK = ""
    map.forEach {
        if(it.value > temp) {
            temp = it.value
            tempK = it.key
        }
    }

    try{
        var iter = stringList.iterator()
        while (iter.hasNext()){
            var str = iter.next()

            if(str.equals(tempK)){
                iter.remove()
            }
        }
    }catch (e: Exception){
        e.message
    }





    var eBook: String = readFileBook("Shadows-of-Childhood.txt")
    print(eBook)


    //Delete chapter

    for(i in stringList){
        stringList.set(stringList.indexOf(i), i.replace("Chapter [0-9]+.*".toRegex(), "\n"))
    }

    //Replace romanian character
    eBook = eBook.replace("ă".toRegex(), "a")
                .replace("Ă".toRegex(), "A")
                .replace("ș".toRegex(), "s")
                .replace("Ș".toRegex(), "S")
                .replace("t".toRegex(), "t")
                .replace("T".toRegex(), "T")
    print(eBook)


    //Scriere din array List<String> in fisier
    try{
        val fw = FileWriter("cleanText.txt")
        var bw = BufferedWriter(fw)

        for (t in stringList){
            bw.write(t)
            bw.newLine()
        }
        bw.close()
    }catch (e: Exception){
        e.message
    }

}