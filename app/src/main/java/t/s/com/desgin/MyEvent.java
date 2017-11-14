package t.s.com.desgin;

/**
 * Created by Administrator on 2017/10/30.
 */

public class MyEvent {
    private String msg;//需要传递的数据(可以是复杂bean对象)

    public MyEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
