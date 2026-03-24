package cw.chaos.cw2_frp

class FRPGenerator {

    fun generateTextSelection(
        index: Int,
        relativePath: String,
        startLine: Int,
        endLine: Int
    ): String {
        return "#frp$index to $relativePath #L$startLine-$endLine"
    }

    fun generateSingleLineSelection(
        index: Int,
        relativePath: String,
        line: Int
    ): String {
        return "#frp$index to $relativePath #L$line"
    }

    fun generateFileReference(
        index: Int,
        relativePath: String
    ): String {
        return "#frp$index to $relativePath"
    }
}
