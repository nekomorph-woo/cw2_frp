package cw.chaos.cw_2frp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PathResolverTest {

    private val resolver = PathResolver()

    @Test
    @DisplayName("文件在根目录下的相对路径")
    fun `should return relative path for file in root`() {
        // 模拟：项目根目录为 /project，文件在 /project/Example.java
        val result = resolver.resolveRelativePath(
            projectPath = "/project",
            filePath = "/project/Example.java"
        )

        assertEquals("Example.java", result)
    }

    @Test
    @DisplayName("文件在子目录下的相对路径")
    fun `should return relative path for file in subdirectory`() {
        val result = resolver.resolveRelativePath(
            projectPath = "/project",
            filePath = "/project/src/main/java/Example.java"
        )

        assertEquals("src/main/java/Example.java", result)
    }

    @Test
    @DisplayName("文件在深层嵌套目录下的相对路径")
    fun `should return relative path for deeply nested file`() {
        val result = resolver.resolveRelativePath(
            projectPath = "/Users/dev/my-project",
            filePath = "/Users/dev/my-project/app/src/main/kotlin/cw/chaos/MyClass.kt"
        )

        assertEquals("app/src/main/kotlin/cw/chaos/MyClass.kt", result)
    }

    @Test
    @DisplayName("文件夹路径保留末尾斜杠")
    fun `should preserve trailing slash for directory`() {
        val result = resolver.resolveRelativePath(
            projectPath = "/project",
            filePath = "/project/src/main/java/",
            isDirectory = true
        )

        assertEquals("src/main/java/", result)
    }
}
