import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class PseudoServerChannelTest : AbstractPseudoServerChannelTest() {
    @Test()
    fun doBeginRead_should_call() {
        verify(channel, atLeastOnce()).doBeginRead()
    }

    @Test
    fun doClose_should_call() {
        channel.close().get()
        verify(channel, atLeastOnce()).doClose()
    }
}