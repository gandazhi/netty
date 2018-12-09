package com.gandazhi.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-03 20:52
 */
public class TestClientChannelHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int i = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        switch (i) {
            case 0:
                MyDataInfo.MyPerson myPerson = MyDataInfo.MyPerson.newBuilder().setName("gandazhi").setAge(20).setAddress("chengdu").build();

                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                        .setPerson(myPerson)
                        .build();
                break;
            case 1:
                MyDataInfo.Dog dog = MyDataInfo.Dog.newBuilder().setName("dog").setAge(2).build();

                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                        .setDog(dog)
                        .build();
                break;
            case 2:
                MyDataInfo.Cat cat = MyDataInfo.Cat.newBuilder().setName("cat").setCity("chengdu").build();

                myMessage = MyDataInfo.MyMessage.newBuilder()
                        .setDataType(MyDataInfo.MyMessage.DataType.CatType)
                        .setCat(cat)
                        .build();
                break;
        }

        ctx.channel().writeAndFlush(myMessage);
    }
}
