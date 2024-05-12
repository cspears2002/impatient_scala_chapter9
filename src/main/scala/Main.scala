import java.io.PrintWriter
import java.nio.file.*

import scala.collection.mutable.ArrayBuffer
import scala.compiletime.ops.double
import scala.io.Source
import scala.math.*

@main def hello(): Unit =
    println("Hello world!")
    println(msg)

    var path = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex1.txt"
    var outputPath = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex1_answer.txt"
    // reverseLines(path, outputPath)

    var path1 = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex2.txt"
    var outputPath1 = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex2_answer.txt"
    // replaceWhitespace(path1, outputPath1, 1)

    var path2 = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex3.txt"
    // findTwelveOrMore(path2)

    var path3 = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex4.txt"
    // floatOps(path3)

    val cwd = System.getProperty("user.dir")
    val path4 = Paths.get(cwd, "src", "main", "scala", "ex5.txt")
    powersOfTwo(path4.toString())


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


def findTwelveOrMore(path: String): Unit =
    var source = Source.fromFile(path)
    val findWhitespace = """\s+""".r
    val fileArray = findWhitespace.split(source.mkString).filter(_.length >= 12).foreach(println)


def floatOps(path: String): Unit =
    val source = Source.fromFile(path)
    val floatsArray = source.getLines.map(_.toFloat).toArray
    val sum = floatsArray.sum
    println(sum)
    println(sum/floatsArray.length)
    println(floatsArray.min)
    println(floatsArray.max)


def powersOfTwo(filename: String): Unit =
    var powers = ArrayBuffer[Double]()
    var reciprocals = ArrayBuffer[Double]()

    for idx <- 0 to 20
    do
        powers += pow(2, idx)
        reciprocals += pow(2, -1 * idx)
    
    val maxLength = powers.last.toString().length()

    val out = PrintWriter(filename)
    for ((p, r) <- (powers zip reciprocals))
        val powersLength = p.toString().length()
        val numSpaces = maxLength - powersLength + 2
        val newStr = p.toString() + " ".toString() * numSpaces + r.toString()
        out.println(newStr)
    println(s"Wrote numbers to $filename")
    out.close()
