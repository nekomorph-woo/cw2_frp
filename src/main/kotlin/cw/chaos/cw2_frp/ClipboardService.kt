package cw.chaos.cw2_frp

import com.intellij.openapi.ide.CopyPasteManager
import java.awt.datatransfer.StringSelection

/**
 * 剪贴板服务
 */
object ClipboardService {

    /**
     * 复制文本到系统剪贴板
     */
    fun copyToClipboard(text: String) {
        val stringSelection = StringSelection(text)
        CopyPasteManager.getInstance().setContents(stringSelection)
    }
}
