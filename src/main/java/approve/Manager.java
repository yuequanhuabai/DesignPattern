package approve;

public class Manager extends Leader{
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getDays()>3 && leaveRequest.getDays()<10){
            System.out.println("经理审批成功");
        }else {
            this.nextLeader.handleRequest(leaveRequest);
        }
    }
}
