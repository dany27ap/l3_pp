import java.io.File
import java.lang.Exception

fun readFileBook(fileName: String): String {
    try {
        var fileObject = File(fileName)
        var editBook = fileObject.readText().replace("\\s+".toRegex(), " ")
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

fun main(args: Array<String>) {

    var eBook: String = readFileBook("Shadows-of-Childhood.txt")
    print(eBook)
    //Delete multiple space

    eBook = eBook.replace("\\s+".toRegex(), " ")
    writeFileBook(eBook)

    //Delete multiple new line

    eBook = eBook.replace("\\n+".toRegex(), "\\n")

    //Delete no of page

    eBook = eBook.replace("\\s{3,}[0-9]+\\s*\\n".toRegex(), "\n")

    //Delete author



    //Delete chapter

    eBook = eBook.replace("Chapter [0-9]+.*\n".toRegex(), "\n")

    //Replace romanian character
    eBook = eBook.replace("ă".toRegex(), "a");
    eBook = eBook.replace("Ă".toRegex(), "A");
    eBook = eBook.replace("ș".toRegex(), "s");
    eBook = eBook.replace("Ș".toRegex(), "S");
    eBook = eBook.replace("t".toRegex(), "t");
    eBook = eBook.replace("T".toRegex(), "T");
}