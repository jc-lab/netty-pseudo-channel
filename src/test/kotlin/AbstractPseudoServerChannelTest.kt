import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.DefaultChannelId
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.handler.logging.LogLevel
import io.netty.handler.logging.LoggingHandler
import kr.jclab.netty.pseudochannel.DefaultPseudoSocketAddress
import org.junit.jupiter.api.AfterEach
import org.mockito.Mockito.spy

abstract class AbstractPseudoServerChannelTest {
    val bossGroup = NioEventLoopGroup(1)
    val workerGroup = NioEventLoopGroup()

    val channel = ServerBootstrap()
        .group(bossGroup, workerGroup)
        .channelFactory {
            spy(TestPseudoServerChannel::class.java)
        }
        .handler(LoggingHandler(LogLevel.INFO))
        .childHandler(TestChannelInitializer())
        .bind(DefaultPseudoSocketAddress())
        .sync()
        .channel() as TestPseudoServerChannel

    @AfterEach()
    fun cleanup() {
        val a = bossGroup.shutdownGracefully()
        val b = workerGroup.shutdownGracefully()
        a.get()
        b.get()
    }

    fun newChildChannel(): TestPseudoChannel {
        // spy not working...
        val child = TestPseudoChannel(channel, DefaultChannelId.newInstance())
        channel.registerChildChannel(child)
        return spy(child)
    }
}