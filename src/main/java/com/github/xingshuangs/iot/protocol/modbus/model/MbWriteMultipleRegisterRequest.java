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
 * Write multiple register request.
 * (请求写多个寄存器)
 *
 * @author xingshuang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class MbWriteMultipleRegisterRequest extends MbPdu {

    /**
     * Address.
     * 输出地址 说是从0x0000 至 0xFFFF，但对应实际却只是0001-9999，对应0x0000-0x270F <br>
     * 字节大小：2个字节
     */
    private int address;

    /**
     * Quantity.
     * 寄存器数量 0x0001 至 0x0078 <br>
     * 字节大小：2个字节
     */
    private int quantity;

    /**
     * Byte count.
     * 字节数 2×N* <br>
     * 字节大小：1个字节
     */
    private int count;

    /**
     * Register data.
     * 寄存器值
     * 字节大小：N*×2 个字节 个字节
     */
    private byte[] value;

    public MbWriteMultipleRegisterRequest() {
        this.functionCode = EMbFunctionCode.WRITE_MULTIPLE_REGISTER;
    }

    public MbWriteMultipleRegisterRequest(int address, int quantity, byte[] value) {
        this.functionCode = EMbFunctionCode.WRITE_MULTIPLE_REGISTER;
        this.address = address;
        this.quantity = quantity;
        this.count = value.length;
        this.value = value;
    }

    @Override
    public int byteArrayLength() {
        return super.byteArrayLength() + 5 + this.value.length;
    }

    @Override
    public byte[] toByteArray() {
        return ByteWriteBuff.newInstance(this.byteArrayLength())
                .putByte(this.functionCode.getCode())
                .putShort(this.address)
                .putShort(this.quantity)
                .putByte(this.count)
                .putBytes(this.value)
                .getData();
    }

    /**
     * Parses byte array and converts it to object.
     * (解析字节数组数据)
     *
     * @param data byte array
     * @return MbWriteMultipleRegisterRequest
     */
    public static MbWriteMultipleRegisterRequest fromBytes(final byte[] data) {
        return fromBytes(data, 0);
    }

    /**
     * Parses byte array and converts it to object.
     * (解析字节数组数据)
     *
     * @param data   byte array
     * @param offset index offset
     * @return MbWriteMultipleRegisterRequest
     */
    public static MbWriteMultipleRegisterRequest fromBytes(final byte[] data, final int offset) {
        ByteReadBuff buff = new ByteReadBuff(data, offset);
        MbWriteMultipleRegisterRequest res = new MbWriteMultipleRegisterRequest();
        res.functionCode = EMbFunctionCode.from(buff.getByte());
        res.address = buff.getUInt16();
        res.quantity = buff.getUInt16();
        res.count = buff.getByteToInt();
        res.value = buff.getBytes(res.count);
        return res;
    }
}
