package kr.jclab.netty.pseudochannel

import io.netty.channel.ChannelConfig
import io.netty.channel.ChannelFuture
import io.netty.channel.DefaultChannelConfig
import java.net.SocketAddress

open class DefaultPseudoServerChannel : AbstractPseudoServerChannel() {
    private val config = DefaultChannelConfig(this)

    override fun config(): ChannelConfig = config

    fun registerChildChannel(child: AbstractPseudoChannel) =
        this.pipeline().fireChannelRead(child)
}