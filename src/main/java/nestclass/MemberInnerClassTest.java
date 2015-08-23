package nestclass;

/**
 * Created by yonney.yang on 2015/8/21.
 */
public class MemberInnerClassTest {
    public static void main(String[] args) {
        // 任何地方都可以创建
        MemberInnerClass t = new MemberInnerClass();

        // 可以创建，pmic里面保存对t的引用
        MemberInnerClass.PublicMemberInnerClass pmic = t.new PublicMemberInnerClass();

        // 可以在同一package下创建，dmic保存对t的引用
        MemberInnerClass.DefaultMemberInnerClass dmic = t.new DefaultMemberInnerClass();

        // 编译错误，无法访问内部内
        // MemberInnerClass.PrivateMemberInnerClass pmic = t.new.PrivateMemberInnerClass();

        // 下面验证一下outterClass是同一个对象
        System.out.println(pmic.getOutterClass() == t);
        System.out.println(dmic.getOutterClass() == t);

    }
}
