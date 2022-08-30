/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.demo.common.bean;

import work.lichong.demo.common.enumeration.ResponseStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 统一返回结果
 *
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@ApiModel(value = "统一返回结果")
public class ApiResponse<T> {

    @ApiModelProperty(value = "状态码")
    private Integer status;

    @ApiModelProperty(value = "响应信息")
    private String message;

    @ApiModelProperty(value = "响应体数据")
    private T data;
    /**
     * 是否压缩数据  gzip
     */
    @ApiModelProperty(value = "是否gzip压缩数据")
    private boolean compressData;

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(Integer code, String message) {
        this(code, message, null);
    }

    public ApiResponse(ResponseStatus status, String message) {
        this(status.getStatus(), message, null);
    }

    public ApiResponse(Integer status, T data) {
        this(ResponseStatus.getRequestStatus(status), data);
    }

    public ApiResponse(ResponseStatus status, T data) {
        this(status.getStatus(), status.getMessage(), data);
    }

    public ApiResponse(ResponseStatus status) {
        this(status.getStatus(), status.getMessage(), null);
    }

    public boolean isCompressData() {
        return compressData;
    }

    public void setCompressData(boolean compressData) {
        this.compressData = compressData;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
