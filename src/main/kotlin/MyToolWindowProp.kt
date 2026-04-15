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
                    <li>To configure a custom text or change your default username, go to:<br>
                        <b>File | Settings | Tools | Signature Stamp</b> (or <b>IntelliJ IDEA | Settings...</b> on macOS).</li>
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
        maximumSize = java.awt.Dimension(Int.MAX_VALUE, preferredSize.height)
        addActionListener {
            action()
        }
    }
}