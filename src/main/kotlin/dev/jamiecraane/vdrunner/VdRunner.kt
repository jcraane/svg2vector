package dev.jamiecraane.vdrunner

import com.android.ide.common.vectordrawable.Svg2Vector
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintWriter

/**
 * Simple main method to test Svg2Vector.
 */
fun main(args: Array<String>) {
    val inputSvg = File("input/vas5.svg")
    val baos = ByteArrayOutputStream()

    val outputFile = File("output/vas5.xml")
    outputFile.delete()

    val error = Svg2Vector.parseSvgToXml(inputSvg, baos)
    if (error.isNotEmpty()) {
        println(error)
    } else {
        val vectorXmlContent = baos.toString()
        PrintWriter(outputFile).also { writer ->
            writer.write(vectorXmlContent)
            writer.flush()
        }
    }
}
