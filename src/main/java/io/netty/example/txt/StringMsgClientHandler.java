package io.netty.example.txt;

/**
 * Created by caiyl on 2017/4/7.
 */
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class StringMsgClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg; // (1)

        byte[] b = new byte[m.readableBytes()];
        m.writeBytes(b);
        System.out.println("clientHandler:"+new String(b));
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) { // (1)
        byte[] msg = "hello".getBytes();
        ByteBuf buff = Unpooled.buffer(msg.length);
        buff.writeBytes(msg);
        ctx.writeAndFlush(buff);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
