package io.github.amirisback

import com.intellij.ui.components.JBLabel
import javax.swing.JButton

fun propTextTitle(): JBLabel {
    val text = "Welcome to Signature Stamp"

    return JBLabel(text).apply {
        font = font.deriveFont(18f)
        alignmentX = java.awt.Component.LEFT_ALIGNMENT
    }
}

fun propTextDescription(): JBLabel {
    val text = """
            <html>
                <ul>
                    <li>This plugin allows you to easily add a signature stamp to your code files.</li>
                    <li>You can customize the stamp with your name, date, and a custom message.</li>
                    <li>To get started, simply click the button below to generate your signature stamp.</li>
                </ul>
            </html>
        """.trimIndent()

    return JBLabel(text).apply {
        font = font.deriveFont(14f)
        alignmentX = java.awt.Component.LEFT_ALIGNMENT
    }
}

fun propButtonAddStamp(action: () -> Unit): JButton {
    val text = "Add Stamp"

    return JButton(text).apply {
        // alignmentX = java.awt.Component.LEFT_ALIGNMENT
        addActionListener {
            action()
        }
    }
}