package domain;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private int status;//后端返回结果正常为true，发生异常返回false
    private Object data;//后端返回结果数据对象
    private String message;//发生异常的错误消息

    //无参构造方法
    public ResultInfo() {
    }
    public ResultInfo(int status) {
        this.status = status;
    }

    public ResultInfo(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResultInfo(int  status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public int getstatus() {
        return status;
    }

    public void setstatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }
}
