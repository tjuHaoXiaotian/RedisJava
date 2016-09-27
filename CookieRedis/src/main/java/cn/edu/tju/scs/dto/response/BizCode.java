package cn.edu.tju.scs.dto.response;

/**
 * Created by catold on 15/12/19.
 */
public enum BizCode {
    // 全局错误码
    SUCCESS(200, "操作成功"),
    FAIL(101,"服务器操作失败"),


    // 待议...根据后台逻辑分类
    ;

    private int state;
    private String message;

    BizCode(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
