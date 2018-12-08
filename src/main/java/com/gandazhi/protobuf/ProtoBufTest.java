package com.gandazhi.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-02 20:23
 */
public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("gandazhi").setAge(20).setAddress("chengdu").build();

        byte[] student2ByteArray = student.toByteArray();

        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);
        System.out.println(student2);
    }
}
