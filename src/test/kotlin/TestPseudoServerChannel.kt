import kr.jclab.netty.pseudochannel.DefaultPseudoServerChannel
import java.net.SocketAddress

open class TestPseudoServerChannel : DefaultPseudoServerChannel() {
    public override fun doBind(localAddress: SocketAddress) {}
    public override fun doBeginRead() {}
    public override fun doClose() {
        super.doClose()
    }
}