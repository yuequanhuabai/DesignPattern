package approve;

public class GeneralManager extends Leader{

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if(leaveRequest.getDays()<30){
            System.out.println("总经理审批通过...");
        }else {
            System.out.println(leaveRequest.getName()+":想辞职吧！");
        }
    }


}
