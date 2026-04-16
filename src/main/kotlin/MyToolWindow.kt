package io.github.amirisback

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBPanel
import com.intellij.util.ui.JBUI
import io.github.amirisback.ext.emptyVerticalSpace
import io.github.amirisback.ext.getDateTodayExt
import javax.swing.JOptionPane


class MyToolWindow(private val project: Project) {
    val content = JBPanel<JBPanel<*>>().apply {

        layout = javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS)
        border = JBUI.Borders.empty(16)

        add(propTextTitle())
        add(propTextSubtitle())
        add(emptyVerticalSpace(10))
        add(propTextDescription())
        add(emptyVerticalSpace(20))
        add(propButtonAddStamp {
            val editor = FileEditorManager.getInstance(project).selectedTextEditor
            if (editor != null) {
                val document = editor.document
                val caretModel = editor.caretModel
                val offset = caretModel.offset

                val state = io.github.amirisback.settings.SignatureStampSettingsState.instance
                val stampText = if (state.isDefaultStamp) {
                    Stamp.result("Created by : ${state.customUserName} - ${getDateTodayExt()}")
                } else {
                    state.customMessage
                        .replace("\$USERNAME", state.customUserName)
                        .replace("\$DATE", getDateTodayExt())
                }

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
