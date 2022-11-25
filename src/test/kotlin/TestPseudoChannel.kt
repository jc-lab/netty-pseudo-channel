import io.netty.channel.*
import kr.jclab.netty.pseudochannel.AbstractPseudoChannel
import kr.jclab.netty.pseudochannel.DefaultPseudoSocketAddress
import java.net.SocketAddress

open class TestPseudoChannel(parent: Channel, id: ChannelId) : AbstractPseudoChannel(parent, id) {
    val localAddress = DefaultPseudoSocketAddress()
    val remoteAddress = DefaultPseudoSocketAddress()

    var closed: Boolean = false

    override fun isOpen(): Boolean {
        return !closed
    }

    override fun isActive(): Boolean {
        return !closed
    }

    override fun localAddress0(): SocketAddress = localAddress

    override fun remoteAddress0(): SocketAddress = remoteAddress

    public override fun doDisconnect() {
        println("CLIENT: doDisconnect")
        closed = true
    }

    public override fun doClose() {
        println("CLIENT: doClose")
        closed = true
    }

    public override fun doBeginRead() {
        println("CLIENT: doBeginRead")
    }

    public override fun doWrite(`in`: ChannelOutboundBuffer?) {
        println("CLIENT: doWrite")
    }
}