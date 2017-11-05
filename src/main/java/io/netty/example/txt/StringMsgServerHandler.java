package io.netty.example.txt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by caiyl on 2017/4/7.
 */
public class StringMsgServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] reqbyte = new byte[buf.readableBytes()];
        buf.readBytes(reqbyte);
        System.out.println("req:"+new String(reqbyte));

        ByteBuf rep = Unpooled.copiedBuffer(reqbyte);

        ctx.writeAndFlush(rep);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}