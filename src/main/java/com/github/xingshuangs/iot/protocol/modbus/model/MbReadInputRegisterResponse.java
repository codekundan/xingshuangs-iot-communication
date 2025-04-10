/*
 * MIT License
 *
 * Copyright (c) 2021-2099 Oscura (xingshuang) <xingshuang_cool@163.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.xingshuangs.iot.protocol.modbus.model;


import com.github.xingshuangs.iot.common.buff.ByteReadBuff;
import com.github.xingshuangs.iot.common.buff.ByteWriteBuff;
import com.github.xingshuangs.iot.protocol.modbus.enums.EMbFunctionCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Read input register response
 * (响应读输入寄存器)
 *
 * @author xingshuang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class MbReadInputRegisterResponse extends MbPdu {

    /**
     * Byte count.
     * 字节数<br>
     * 字节大小：1个字节
     */
    private int count;

    /**
     * Register count.
     * 输入寄存器值，N＝寄存器的数量，N*×2 个字节
     * 字节大小：N*×2 个字节
     */
    private byte[] register;

    public MbReadInputRegisterResponse() {
        this.functionCode = EMbFunctionCode.READ_INPUT_REGISTER;
    }

    @Override
    public int byteArrayLength() {
        return super.byteArrayLength() + 1 + this.register.length;
    }

    @Override
    public byte[] toByteArray() {
        return ByteWriteBuff.newInstance(this.byteArrayLength())
                .putByte(this.functionCode.getCode())
                .putByte(this.count)
                .putBytes(this.register)
                .getData();
    }

    /**
     * Parses byte array and converts it to object.
     * (解析字节数组数据)
     *
     * @param data byte array
     * @return MbReadInputRegisterResponse
     */
    public static MbReadInputRegisterResponse fromBytes(final byte[] data) {
        return fromBytes(data, 0);
    }

    /**
     * Parses byte array and converts it to object.
     * (解析字节数组数据)
     *
     * @param data   byte array
     * @param offset index offset
     * @return MbReadInputRegisterResponse
     */
    public static MbReadInputRegisterResponse fromBytes(final byte[] data, final int offset) {
        ByteReadBuff buff = new ByteReadBuff(data, offset);
        MbReadInputRegisterResponse res = new MbReadInputRegisterResponse();
        res.functionCode = EMbFunctionCode.from(buff.getByte());
        res.count = buff.getByteToInt();
        res.register = buff.getBytes(res.count);
        return res;
    }
}
