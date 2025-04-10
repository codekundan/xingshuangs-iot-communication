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


import com.github.xingshuangs.iot.common.IObjectByteArray;
import com.github.xingshuangs.iot.common.buff.ByteWriteBuff;
import com.github.xingshuangs.iot.exceptions.ModbusCommException;
import lombok.Data;

/**
 * Modbus tcp request.
 * (TCP的modbus请求)
 *
 * @author xingshuang
 */
@Data
public class MbTcpRequest implements IObjectByteArray {

    /**
     * Package header.
     * (报文头， 报文头为 7 个字节长)
     */
    private MbapHeader header;

    /**
     * PDU.
     * (协议数据单元)
     */
    private MbPdu pdu;

    public MbTcpRequest() {
    }

    public MbTcpRequest(MbapHeader header, MbPdu pdu) {
        this.header = header;
        this.pdu = pdu;
    }

    @Override
    public int byteArrayLength() {
        return this.header.byteArrayLength() + this.pdu.byteArrayLength();
    }

    @Override
    public byte[] toByteArray() {
        return ByteWriteBuff.newInstance(this.byteArrayLength())
                .putBytes(this.header.toByteArray())
                .putBytes(this.pdu.toByteArray())
                .getData();
    }

    /**
     * Check self.
     * (自我数据校验)
     */
    public void selfCheck() {
        if (this.header == null) {
            throw new ModbusCommException("header is null");
        }
        if (this.pdu == null) {
            throw new ModbusCommException("pdu is null");
        }
        this.header.setLength(this.pdu.byteArrayLength() + 1);
    }

    /**
     * Create default request.
     * (创建默认请求对象)
     *
     * @return MbTcpRequest
     */
    public static MbTcpRequest createDefault() {
        MbTcpRequest request = new MbTcpRequest();
        request.header = new MbapHeader(MbapHeader.getNewNumber());
        return request;
    }

    /**
     * Parses byte array and converts it to object.
     * (解析字节数组数据)
     *
     * @param data byte array
     * @return MbTcpRequest
     */
    public static MbTcpRequest fromBytes(byte[] data) {
        MbTcpRequest request = new MbTcpRequest();
        request.header = MbapHeader.fromBytes(data);
        request.pdu = MbPdu.fromBytesToRequest(data, request.header.byteArrayLength());
        return request;
    }

    /**
     * Parses byte array and converts it to object.
     * (解析字节数组数据)
     *
     * @param header   package header.
     * @param pduBytes pdu byte array.
     * @return MbTcpRequest
     */
    public static MbTcpRequest fromBytes(MbapHeader header, byte[] pduBytes) {
        MbTcpRequest request = new MbTcpRequest();
        request.header = header;
        request.pdu = MbPdu.fromBytesToRequest(pduBytes);
        return request;
    }
}
