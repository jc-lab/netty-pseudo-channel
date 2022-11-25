import org.junit.jupiter.api.Test

class PseudoChannelTest : AbstractPseudoServerChannelTest() {
    @Test
    fun channel_should_register() {
        val child = newChildChannel()
        while(!child.isRegistered) {
            Thread.sleep(100)
        }
        assert(child.isRegistered)
    }
}