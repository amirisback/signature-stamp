package io.github.amirisback

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBPanel
import com.intellij.util.ui.JBUI
import java.text.SimpleDateFormat
import java.util.*
import javax.swing.JOptionPane


class MyToolWindow(private val project: Project) {
    val content = JBPanel<JBPanel<*>>().apply {

        layout = javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS)
        border = JBUI.Borders.empty(16)

        add(propTextTitle())
        add(emptyVerticalSpace(10))
        add(propTextDescription())
        add(emptyVerticalSpace(20))
        add(propButtonAddStamp {
            val editor = FileEditorManager.getInstance(project).selectedTextEditor
            if (editor != null) {
                val document = editor.document
                val caretModel = editor.caretModel
                val offset = caretModel.offset

                val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                val dateString = dateFormat.format(Date())

                val stampText = "// Signature Stamp: amirisback - $dateString\n"

                WriteCommandAction.runWriteCommandAction(project) {
                    document.insertString(offset, stampText)
                    caretModel.moveToOffset(offset + stampText.length)
                }
            } else {
                JOptionPane.showMessageDialog(this, "No active editor found! Please open a code file.")
            }
        })
    }
}
