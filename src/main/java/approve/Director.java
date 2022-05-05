package approve;

public class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getDays()<3){
            System.out.println("主任审批通过...");
        }else {
            // 处理不了，给下处理
            this.nextLeader.handleRequest(leaveRequest);
        }
    }
}
