package io.github.amirisback

import com.intellij.ui.components.JBLabel
import javax.swing.JButton

fun varJLabel(text: String, params: Any? = null): JBLabel {
    return JBLabel(MyMessageBundle.message(text, params))
}

fun varJButton(text: String, params: Any? = null): JButton {
    return JButton(MyMessageBundle.message(text, params))
}