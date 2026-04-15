package io.github.amirisback.settings

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class SignatureStampConfigurable : Configurable {
    private var component: SignatureStampSettingsComponent? = null

    override fun getDisplayName(): String {
        return "Signature Stamp"
    }

    override fun createComponent(): JComponent? {
        component = SignatureStampSettingsComponent()
        return component?.panel
    }

    override fun isModified(): Boolean {
        val state = SignatureStampSettingsState.instance
        return component?.defaultStampRadio?.isSelected != state.isDefaultStamp ||
               component?.userNameTextField?.text != state.customUserName ||
               component?.customMessageTextArea?.text != state.customMessage
    }

    override fun apply() {
        val state = SignatureStampSettingsState.instance
        state.isDefaultStamp = component?.defaultStampRadio?.isSelected == true
        state.customUserName = component?.userNameTextField?.text ?: ""
        state.customMessage = component?.customMessageTextArea?.text ?: ""
    }

    override fun reset() {
        val state = SignatureStampSettingsState.instance
        if (state.isDefaultStamp) {
            component?.defaultStampRadio?.isSelected = true
        } else {
            component?.customMessageRadio?.isSelected = true
        }
        component?.userNameTextField?.text = state.customUserName
        component?.customMessageTextArea?.text = state.customMessage
        component?.updateUI()
    }

    override fun disposeUIResources() {
        component = null
    }
}
