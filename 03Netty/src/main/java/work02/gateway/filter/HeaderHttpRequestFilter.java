package work02.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HeaderHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        //设置请求头
        fullRequest.headers().set("name", "zhang_zhi_wen");
    }
}
