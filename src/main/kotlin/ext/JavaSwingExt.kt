package io.github.amirisback.ext

import com.intellij.ui.components.JBLabel
import io.github.amirisback.MyMessageBundle
import java.awt.Component
import java.awt.Dimension
import javax.swing.Box
import javax.swing.JButton

fun varJLabel(text: String, params: Any? = null): JBLabel {
    return JBLabel(MyMessageBundle.message(text, params))
}

fun varJButton(text: String, params: Any? = null): JButton {
    return JButton(MyMessageBundle.message(text, params))
}

fun emptyVerticalSpace(dimen: Int): Component {
    return Box.createRigidArea(Dimension(0, dimen))
}