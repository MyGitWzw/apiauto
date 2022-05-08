package abstracttest;

import interfaceImp.IWorker;

/**
 * @Author: Wzw
 * @Date: 2021/7/4 14:48
 */
public abstract class AbstractWorker {
    public abstract void work();// 抽象方法，加上abstract

    public void showDaily(){//在抽象类中定义非抽象
        System.out.println("起床");
        System.out.println("上班");
        work();
        System.out.println("下班");
        System.out.println("睡觉");
    }
}
