package kr.jclab.netty.pseudochannel

import io.netty.channel.*
import java.net.SocketAddress

abstract class AbstractPseudoChannel(parent: Channel, id: ChannelId) : AbstractChannel(parent, id) {
    override fun metadata(): ChannelMetadata = ChannelMetadata(false)
    override fun config(): ChannelConfig = DefaultChannelConfig(this)
    override fun isCompatible(loop: EventLoop?) = true

    override fun doBind(localAddress: SocketAddress?) {
        throw UnsupportedOperationException("ChildChannel doesn't support bind()")
    }

    override fun newUnsafe(): AbstractUnsafe = NotConnectableUnsafe()

    private inner class NotConnectableUnsafe : AbstractUnsafe() {
        override fun connect(remoteAddress: SocketAddress?, localAddress: SocketAddress?, promise: ChannelPromise?) {
            throw UnsupportedOperationException("AbstractPseudoChannel doesn't support connect()")
        }
    }
}
