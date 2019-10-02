package cn.likeyiyy.todoweb.web.presentation;

public class Response {
    private boolean status = true;
    private Long id = 0L;
    private String message = "";

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
