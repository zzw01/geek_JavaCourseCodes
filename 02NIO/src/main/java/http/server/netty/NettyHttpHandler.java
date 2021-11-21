package http.server.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @ClassName NettyHttpHandler
 * @Description TODO
 * @Date 2021/11/13 23:05
 * @Author kevin
 **/
public class NettyHttpHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        FullHttpRequest request = (FullHttpRequest) msg;
        String uri = request.uri();
        if (uri.equals("/")) {
            handleIndex(request, ctx);
        } else if (uri.contains("/test")) {
            handleTest(request, ctx);
        } else {
            handleNotFound(request, ctx);
        }
    }

    private void handleIndex(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        handleResponse(fullRequest, ctx, HttpResponseStatus.OK,
                "text/html",
                "<h1>Hello!</h1> " +
                        "<body>I am a netty http server!</body>");
    }

    private void handleTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        handleResponse(fullRequest, ctx, HttpResponseStatus.OK,
                "application/json",
                "{\"status\":\"ok\", \"data\": {\"msg\":\"test\"}}");
    }

    private void handleNotFound(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        handleResponse(fullRequest, ctx, HttpResponseStatus.NOT_FOUND,
                "application/json",
                "{\"status\":\"err\", \"data\": {\"msg\":\"not found\"}}");
    }

    private void handleResponse(FullHttpRequest fullRequest, ChannelHandlerContext ctx,
                                HttpResponseStatus status, String contentType, String body) {
        FullHttpResponse response = null;
        try {
            response = new DefaultFullHttpResponse(HTTP_1_1, status,
                    Unpooled.wrappedBuffer(body.getBytes("UTF-8")));
            response.headers().set("Content-Type", contentType);
            response.headers().setInt("Content-Length", response.content().readableBytes());

        } catch (Exception e) {
            System.out.println("处理出错:" + e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
                ctx.flush();
            }
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
