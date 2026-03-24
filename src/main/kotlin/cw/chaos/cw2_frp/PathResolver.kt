package cw.chaos.cw2_frp

import java.io.File

class PathResolver {

    /**
     * 计算文件相对于项目根目录的相对路径
     *
     * @param projectPath 项目根目录的绝对路径
     * @param filePath 文件的绝对路径
     * @param isDirectory 是否为目录（目录会保留末尾斜杠）
     * @return 相对于项目根目录的路径
     */
    fun resolveRelativePath(
        projectPath: String,
        filePath: String,
        isDirectory: Boolean = false
    ): String {
        val projectFile = File(projectPath).canonicalPath
        val targetFile = File(filePath).canonicalPath

        val relativePath = if (targetFile.startsWith(projectFile)) {
            targetFile.removePrefix(projectFile).removePrefix(File.separator)
        } else {
            targetFile
        }

        return if (isDirectory && !relativePath.endsWith(File.separator)) {
            "$relativePath/"
        } else {
            relativePath
        }
    }
}
