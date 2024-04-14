import java.io.PrintWriter
import scala.io.Source
import scala.compiletime.ops.double

@main def hello(): Unit =
  println("Hello world!")
  println(msg)

  var path = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex1.txt"
  var outputPath = "/Users/christopherspears/Documents/ScalaProjects/impatient_scala_chapter9/src/main/scala/ex1_answer.txt"
  reverseLines(path, outputPath)


def msg = "I was compiled by Scala 3. :)"


def reverseLines(path: String, outputPath: String ): Unit =
  var source = Source.fromFile(path)
  var lineArray = source.getLines.toArray
  val out = PrintWriter(outputPath)
  lineArray.reverse.foreach(out.println)
  out.close()

