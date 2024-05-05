import java.io.PrintWriter
import scala.io.Source
import scala.compiletime.ops.double

@main def hello(): Unit =
    println("Hello world!")
    println(msg)

    var path = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex1.txt"
    var outputPath = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex1_answer.txt"
    reverseLines(path, outputPath)

    var path1 = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex2.txt"
    var outputPath1 = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex2_answer.txt"
    replaceWhitespace(path1, outputPath1, 1)


def msg = "I was compiled by Scala 3. :)"


def reverseLines(path: String, outputPath: String): Unit =
    var source = Source.fromFile(path)
    var lineArray = source.getLines.toArray
    val out = PrintWriter(outputPath)
    lineArray.reverse.foreach(out.println)
    out.close()


def replaceWhitespace(path: String, outputPath: String, numSpaces: Int): Unit =
    var source = Source.fromFile(path)
    val findTabs = """\s+""".r
    val hashes = "#" * numSpaces
    val updatedStr = findTabs.replaceAllIn(source.mkString, hashes)
    val out = PrintWriter(outputPath)
    out.println(updatedStr)
    out.close()


