package work.lichong.funcode.webmvc.demo.common.enumeration;

/**
 * http api 状态码
 *
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
public enum ResponseStatus {

    // [GET]：服务器成功返回用户请求的数据
    RESPONSE_2XX_OK(200, "Ok"),
    // [POST/PUT/PATCH]：用户新建或修改数据成功。
    RESPONSE_2XX_CREATE(201, "Created"),
    RESPONSE_2XX_UPDATED(201, "Updated"),
    // 表示一个请求已经进入后台排队（异步任务）
    RESPONSE_2XX_ACCEPTED(202, "Accepted"),
    // [DELETE]：用户删除数据成功。
    RESPONSE_2XX_NO_CONTENT(204, "No Content"),

    // [GET/POST/PUT/PATCH]：语义有误，当前请求无法被服务器理解
    RESPONSE_4XX_INVALID_REQUEST(400, "Invalid Request"),
    // 表示用户没有权限（令牌、用户名、密码错误）
    RESPONSE_4XX_UNAUTHORIZED(401, "Unauthorized"),
    // 表示用户得到授权（与401错误相对），但是访问是被禁止的
    RESPONSE_4XX_FORBIDDEN(403, "Forbidden"),
    // 用户发出的请求针对的是不存在的记录，服务器没有进行操作等的。
    RESPONSE_4XX_NOT_FOUND(404, "Not Found"),
    // 请求格式正确，但是由于含有语义错误，无法响应
    RESPONSE_4XX_UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    // 重复校验未通过
    RESPONSE_409_REPEAT(409, "重复校验未通过, 不能执行操作！"),

    // 服务器发生错误，用户将无法判断发出的请求是否成功。
    RESPONSE_5XX_INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    // 服务器不支持实现请求所需要的功能
    RESPONSE_5XX_NOT_IMPLEMENTED(501, "该接口已废弃,请参照文档及时更换");

    private final int status;

    private final String message;

    ResponseStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseStatus getRequestStatus(int status) {
        for (ResponseStatus msgPlatformStatus : values()) {
            if (msgPlatformStatus.status == status) {
                return msgPlatformStatus;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + status + "]");
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
