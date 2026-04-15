package io.github.amirisback

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import java.text.SimpleDateFormat
import java.util.Date
import javax.swing.JButton
import javax.swing.JOptionPane

class MyToolWindow(private val project: Project) {

    val content = JBPanel<JBPanel<*>>().apply {
        layout = javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS)

        val textTitle = "Welcome to Signature Stamp"

        val textDescription = "<html>This plugin allows you to easily add a signature stamp to your code files.<br/>" +
                "You can customize the stamp with your name, date, and a custom message.<br/>" +
                "To get started, simply click the button below to generate your signature stamp.</html>"

        add(JBLabel(textTitle).apply {
            font = font.deriveFont(18f)
            alignmentX = java.awt.Component.LEFT_ALIGNMENT

        })
        add(javax.swing.Box.createRigidArea(java.awt.Dimension(0, 10)))
        add(JBLabel(textDescription).apply {
            font = font.deriveFont(14f)
            alignmentX = java.awt.Component.LEFT_ALIGNMENT
        })
        add(javax.swing.Box.createRigidArea(java.awt.Dimension(0, 20)))

        add(JButton("Add Stamp").apply {
            alignmentX = java.awt.Component.LEFT_ALIGNMENT
            addActionListener {
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
            }
        })
    }
}
