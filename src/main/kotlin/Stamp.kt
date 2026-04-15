package io.github.amirisback

object Stamp {

    fun result(text: String): String {
        return """
            /**
                 * $text
                 */
        """.trimIndent()
    }

}