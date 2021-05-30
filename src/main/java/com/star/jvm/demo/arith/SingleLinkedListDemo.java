package com.star.jvm.demo.arith;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(4, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(6, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(7, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(2, "林冲", "豹子头");

        // 创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //SingleLinkedList singleLinkedList1 = new SingleLinkedList();

        // 加入
        /*
         * singleLinkedList.add(hero1); singleLinkedList.add(hero2);
         * singleLinkedList.add(hero3); singleLinkedList.add(hero4);
         */
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();
        singleLinkedList.reversetList();
        System.out.println();
        singleLinkedList.list();
//        singleLinkedList1.addByOrder(hero5);
//        singleLinkedList1.addByOrder(hero6);
//        singleLinkedList1.addByOrder(hero7);
//        singleLinkedList1.addByOrder(hero8);
        // 测试一下单链表的反转功能
//        System.out.println("原来链表1的情况~~");
//        singleLinkedList.list();
//
//        System.out.println("原来链表2的情况~~");
//        singleLinkedList1.list();

		/*System.out.println("原来链表的情况~~");
		singleLinkedList1.list();*/


        /*
         * System.out.println("size=" + singleLinkedList.getLength());
         * System.out.println("倒数第2个=" + singleLinkedList.findLastIndexNode(2));
         */

        // 测试删除
		/*singleLinkedList.delete(2);
		System.out.println("删除节点后的链表");*/
        //测试反转
		/*System.out.println("反转链表后~");
		singleLinkedList.reversetList();*/

//        System.out.println("连接两个列表后~");
//        singleLinkedList.mergeSingleLinkedList(singleLinkedList.getHead(), singleLinkedList1.getHead());


    }


}

/**
 * HeroNode节点
 *
 * @author CHTW
 *
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        super();
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
    }

}

/**
 * 创建单链表
 *
 * @author CHTW
 *
 */
class SingleLinkedList {
    // 先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    // 返回头节点
    public HeroNode getHead() {
        return head;
    }

    /** 添加节点的方法-->在链表的最后面添加*/
    public void add(HeroNode heroNode) {
        // 头节点不能动，创建一个局部临时的辅助变量（指针）
        HeroNode temp = head;
        // 遍历链表
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后, 将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    /**添加节点的方法-->按照no进行排序*/
    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        // 因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {// 说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { // 位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {// 说明希望添加的heroNode的编号已然存在
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next; // 后移，遍历当前链表
        }
        // 判断flag 的值
        if (flag) { // 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            // 插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //[ 0 next=null] [ 0 next=[5 next=null]]] [ 5 next=[ 8 next = null]]]

    // 遍历链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        // 头节点不能动，创建一个局部临时的辅助变量（指针）
        HeroNode temp = head.next;
        while (true) {
            // 判断是否为空
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }

    /**
     * 获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
     *
     *            链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public int getLength() {
        if (head.next == null) { // 空链表
            return 0;
        }
        int length = 0;
        // 定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next; // 遍历
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个结点 【新浪面试题】
     *  思路
     *  1. 接收一个index
     *  2. index 表示是倒数第index个节点
     * 	3.先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 	4. 得到size 后，我们从链表的第一个开始遍历(size-index)个，就可以得到
     *  5. 如果找到了，则返回该节点，否则返回null
     */
    public HeroNode findLastIndexNode(int index) {
        // 判断如果链表为空，返回null
        if (head.next == null) {
            return null;// 没有找到
        }
        // 第一个遍历得到链表的长度(节点个数)
        int size = getLength();
        // 第二次遍历 size-index 位置，就是我们倒数的第K个节点
        // 先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义给辅助变量， for 循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 删除节点函数
     * 1. 判断链表是否为空
     * 2. 遍历链表，查找到no一直的节点 创建一个辅助变量cur，cur辅助节点找到待删除节点的前一个节点
     * 3.删除节点操作
     * 	1)先找到该节点
     * 	2)cur.next = cur.next.next;
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode cur = head;
        boolean flag = false;
        while (true) {
            // 到达链表尾部
            if (cur.next == null) {
                break;
            }
            if (cur.next.no == no) {
                flag = true;
                break;
            }
            cur = cur.next;// 后移，遍历
        }
        if (flag) {
            // 删除节点
            cur.next = cur.next.next;
        } else {
            System.out.println("要删除的节点不存在！");
        }

    }

    /** 修改节点的信息, 根据no编号来修改，即no编号不能改.
     *  说明
     *  1. 根据 newHeroNode 的 no 来修改即可
     */
    public void update(HeroNode newHeroNode) {
        // 判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        // 找到需要修改的节点, 根据no编号
        // 定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; // 已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else { // 没有找到
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 单链表的反转
     */
    public void reversetList() {
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next;// 先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;// 将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; // 将cur 连接到新的链表上
            cur = next;// 让cur后移
        }
        // 将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }


    /**
     * 我的翻转链表实现
     */
    public void resList(){
        // 如果当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //临时变量，用来遍历位置
        HeroNode cur = head.next;
        //临时temp，用来临时存储引用
        HeroNode next = null;
        //新链表，用于接收数据，反转链表
        HeroNode resData = new HeroNode(0,"","");
        while (cur!=null){
            //临时存储cur的引用
            next = cur.next;
            //链表引用指向新链表头节点
            cur.next = resData.next;
            //每次cur数据都插入新链表头结点，形成链表反转
            resData.next = cur;
            //cur往后移
            cur = next;
        }
        //链表接入反转后的数据
        head.next = resData.next;
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     * @param oldNode1
     * @param oldNode2
     * @return
     */
    public void mergeSingleLinkedList(HeroNode oldNode1, HeroNode oldNode2) {
        HeroNode temp1 = oldNode1.next;
        HeroNode temp2 = oldNode2.next;

        HeroNode newHead = new HeroNode(0, "", "");

        if(oldNode1.next == null){
            newHead.next = oldNode2.next;
        }else if(oldNode2.next == null){
            newHead.next = oldNode1.next;
        }

        HeroNode temp3 = newHead;

        while(temp1 != null || temp2 != null){

            //链表1为空
            if(temp1 == null && temp2 != null){
                temp3.next = temp2;
                temp2 = temp2.next;
            }else if(temp2 == null && temp1 != null){//链表2为空
                temp3.next = temp1;
                temp1 = temp1.next;
            }else {//链表都不为空
                if (temp1.no <= temp2.no) {
                    temp3.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp3.next = temp2;
                    temp2 = temp2.next;
                }
            }
            temp3 = temp3.next;
        }
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //singleLinkedList.show(newHead);


    }


}
