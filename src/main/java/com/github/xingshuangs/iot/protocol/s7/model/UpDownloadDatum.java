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

package com.github.xingshuangs.iot.protocol.s7.model;


import com.github.xingshuangs.iot.common.buff.ByteReadBuff;
import com.github.xingshuangs.iot.common.buff.ByteWriteBuff;
import com.github.xingshuangs.iot.exceptions.S7CommException;
import com.github.xingshuangs.iot.protocol.s7.enums.EMessageType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Upload and download data.
 * 上传下载数据
 *
 * @author xingshuang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UpDownloadDatum extends Datum {

    /**
     * Length.
     * 长度，2个字节
     */
    private int length = 0;

    /**
     * Unknown bytes
     * 未知，2个字节
     */
    private int unknownBytes = 0;

    /**
     * Data, byte array
     * 数据部分
     */
    private byte[] data = new byte[0];

    @Override
    public int byteArrayLength() {
        return 4 + this.data.length;
    }

    @Override
    public byte[] toByteArray() {
        return ByteWriteBuff.newInstance(4 + this.data.length)
                .putShort(this.length)
                .putShort(this.unknownBytes)
                .putBytes(this.data)
                .getData();
    }

    /**
     * Parses byte array and converts it to object.
     *
     * @param data        byte array
     * @param messageType message type
     * @return UpDownloadDatum
     */
    public static UpDownloadDatum fromBytes(byte[] data, EMessageType messageType) {
        return fromBytes(data, 0, messageType);

    }

    /**
     * Parses byte array and converts it to object.
     *
     * @param data        byte array
     * @param offset      index offset
     * @param messageType message type
     * @return UpDownloadDatum
     */
    public static UpDownloadDatum fromBytes(byte[] data, int offset, EMessageType messageType) {
        if (EMessageType.ACK_DATA != messageType) {
            // 不是响应数据
            throw new S7CommException("Not response data");
        }
        UpDownloadDatum res = new UpDownloadDatum();
        ByteReadBuff buff = new ByteReadBuff(data, offset);
        res.length = buff.getUInt16();
        res.unknownBytes = buff.getUInt16();
        res.data = buff.getBytes(res.length);
        return res;
    }

    /**
     * Create download data.
     * 根据字节数据创建下载数据结构
     *
     * @param data data
     * @return UpDownloadDatum
     */
    public static UpDownloadDatum createDownloadData(byte[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("data");
        }
        UpDownloadDatum res = new UpDownloadDatum();
        // 这里长度最长是0xD0，即208，对应最长是240
        res.length = data.length;
        res.unknownBytes = 0x00FB;
        res.data = data;
        return res;
    }
}
