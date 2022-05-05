package approve;

public class ChainTest {
    public static void main(String[] args) {
        Leader a =new Director("主任");
        Leader b =new Director("经理");
        Leader c =new GeneralManager("总经理");


        // 责任链对象
        a.setNextLeader(b);
        b.setNextLeader(c);

        // 测试
        LeaveRequest leaveRequest = new LeaveRequest("cxx", 2, "回家看病");
        a.handleRequest(leaveRequest);
        System.out.println("================================");
        LeaveRequest leaveRequest2 = new LeaveRequest("cxx", 15, "回家看病");
        a.handleRequest(leaveRequest2);
        System.out.println("================================");
        LeaveRequest leaveRequest3 = new LeaveRequest("cxx", 40, "回家看病");
        a.handleRequest(leaveRequest3);
    }
}
