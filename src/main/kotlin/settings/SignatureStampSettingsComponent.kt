package io.github.amirisback.settings

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBRadioButton
import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTextArea
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.ButtonGroup
import javax.swing.JComponent
import javax.swing.JPanel

class SignatureStampSettingsComponent {
    val panel: JPanel
    
    val defaultStampRadio = JBRadioButton("Use Default Stamp Format (Created by : [User] - [Date])")
    val customMessageRadio = JBRadioButton("Use Custom Message (Replaces entire stamp)")
    
    val userNameTextField = JBTextField()
    val customMessageTextArea = JBTextArea(4, 40).apply {
        lineWrap = true
        wrapStyleWord = true
    }

    init {
        val buttonGroup = ButtonGroup()
        buttonGroup.add(defaultStampRadio)
        buttonGroup.add(customMessageRadio)
        
        defaultStampRadio.addActionListener { updateUI() }
        customMessageRadio.addActionListener { updateUI() }

        panel = FormBuilder.createFormBuilder()
            .addComponent(defaultStampRadio, 1)
            .addLabeledComponent(JBLabel("Default Username: "), userNameTextField, 1, false)
            .addSeparator(15)
            .addComponent(customMessageRadio, 1)
            .addLabeledComponent(JBLabel("Custom Stamp Message: "), JBScrollPane(customMessageTextArea), 1, true)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }
    
    fun updateUI() {
        userNameTextField.isEnabled = defaultStampRadio.isSelected
        customMessageTextArea.isEnabled = customMessageRadio.isSelected
    }
    
    val preferredFocusedComponent: JComponent
        get() = userNameTextField
}
