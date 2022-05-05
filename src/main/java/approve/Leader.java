package approve;

public abstract class Leader {

    protected String name;

    protected Leader nextLeader;

    public Leader() {
    }

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader){
        this.nextLeader=nextLeader;
    }

    // 处理请求的核心业务方法
    public abstract void handleRequest(LeaveRequest leaveRequest);
}
