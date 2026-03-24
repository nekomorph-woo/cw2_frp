package cw.chaos.cw2_frp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class FRPGeneratorTest {

    private val generator = FRPGenerator()

    @Nested
    @DisplayName("多行选择")
    inner class MultiLineSelection {

        @Test
        @DisplayName("生成正确格式")
        fun `should return correct format for multi-line selection`() {
            val result = generator.generateTextSelection(
                index = 1,
                relativePath = "src/main/java/Example.java",
                startLine = 20,
                endLine = 30
            )

            assertEquals("#frp1 to src/main/java/Example.java #L20-30", result)
        }

        @Test
        @DisplayName("不同索引生成对应编号")
        fun `should use correct index number`() {
            val result = generator.generateTextSelection(
                index = 5,
                relativePath = "src/main/java/Example.java",
                startLine = 1,
                endLine = 10
            )

            assertEquals("#frp5 to src/main/java/Example.java #L1-10", result)
        }

        @Test
        @DisplayName("索引 10 应该正常工作")
        fun `should handle index 10`() {
            val result = generator.generateTextSelection(
                index = 10,
                relativePath = "Example.kt",
                startLine = 1,
                endLine = 5
            )

            assertEquals("#frp10 to Example.kt #L1-5", result)
        }
    }

    @Nested
    @DisplayName("单行选择")
    inner class SingleLineSelection {

        @Test
        @DisplayName("生成单行格式（无范围）")
        fun `should return single line format without range`() {
            val result = generator.generateSingleLineSelection(
                index = 1,
                relativePath = "src/main/java/Example.java",
                line = 42
            )

            assertEquals("#frp1 to src/main/java/Example.java #L42", result)
        }

        @Test
        @DisplayName("不同索引生成对应编号")
        fun `should use correct index number for single line`() {
            val result = generator.generateSingleLineSelection(
                index = 7,
                relativePath = "Test.kt",
                line = 100
            )

            assertEquals("#frp7 to Test.kt #L100", result)
        }
    }

    @Nested
    @DisplayName("文件引用")
    inner class FileReference {

        @Test
        @DisplayName("生成文件级引用格式")
        fun `should return file reference format`() {
            val result = generator.generateFileReference(
                index = 1,
                relativePath = "src/main/java/Example.java"
            )

            assertEquals("#frp1 to src/main/java/Example.java", result)
        }

        @Test
        @DisplayName("不同索引生成对应编号")
        fun `should use correct index number for file reference`() {
            val result = generator.generateFileReference(
                index = 3,
                relativePath = "app/src/main.kt"
            )

            assertEquals("#frp3 to app/src/main.kt", result)
        }
    }
}
