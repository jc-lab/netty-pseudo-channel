import org.junit.jupiter.api.Test

class PseudoChannelTest : AbstractPseudoServerChannelTest() {
    @Test
    fun isRegister_should_true() {
        val child = newChildChannel()
        assert(child.isRegistered)
    }
}