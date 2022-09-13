package work.lichong.funcode.webmvc.demo.common.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.Getter;
import lombok.Setter;
import work.lichong.funcode.webmvc.demo.common.enumeration.ResponseStatus;

/**
 * 统一返回结果
 *
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Schema(name = "带数量的统一返回结果",title = "带数量的统一返回结果")
public class ApiResponseWithCount<T> extends ApiResponse<T> {

    @Getter
    @Setter
    @SchemaProperty(name = "数量")
    private long count;

    public ApiResponseWithCount(ResponseStatus status, T data) {
        super(status.getStatus(), status.getMessage(), data);
    }

}
