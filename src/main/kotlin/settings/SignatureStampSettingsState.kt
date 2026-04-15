package io.github.amirisback.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "io.github.amirisback.settings.SignatureStampSettingsState",
    storages = [Storage("SignatureStampSettings.xml")]
)
class SignatureStampSettingsState : PersistentStateComponent<SignatureStampSettingsState> {
    var isDefaultStamp: Boolean = true
    var customUserName: String = System.getProperty("user.name")
    var customMessage: String = "Your custom message here"

    override fun getState(): SignatureStampSettingsState {
        return this
    }

    override fun loadState(state: SignatureStampSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        val instance: SignatureStampSettingsState
            get() = ApplicationManager.getApplication().getService(SignatureStampSettingsState::class.java)
    }
}
