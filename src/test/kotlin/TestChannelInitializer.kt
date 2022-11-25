import io.netty.channel.ChannelInitializer

class TestChannelInitializer : ChannelInitializer<TestPseudoChannel>() {
    override fun initChannel(ch: TestPseudoChannel) {
        println("initChannel: " + ch)
    }
}