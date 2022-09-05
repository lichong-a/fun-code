package work.lichong.funcode.webmvc.demo.common.bean;

import work.lichong.funcode.webmvc.demo.common.enumeration.ResponseStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回结果
 *
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@ApiModel(value = "带数量的统一返回结果", parent = ApiResponse.class)
public class ApiResponseWithCount<T> extends ApiResponse<T> {

    @Getter
    @Setter
    @ApiModelProperty(value = "数量")
    private long count;

    public ApiResponseWithCount(ResponseStatus status, T data) {
        super(status.getStatus(), status.getMessage(), data);
    }

}
