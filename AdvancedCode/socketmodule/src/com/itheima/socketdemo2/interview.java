package com.itheima.socketdemo2;

public class interview {
    public static void main(String[] args) {
        //insertNode(root_node,node_1);
    }

    private class node{
        node left;
        node right;
        int value;
    }

    public node insertNode(node root, node nd){
        int value = nd.value;
        node root_dup = root;
        while((root.left != null && value < root.value) || (root.right != null && value > root.value)){
            if(value < root.value){
                root = root.left;
            }else(value > root.value){
                root = root.right;
            }
        }
        if(value < root.value){
            root.left = nd;
        }else{
            root.right = nd;
        }
        return root_dup;
    }
}
//代码能力有待提高，算法要更熟悉一些，实习和社招不一样（更重视基础），尤其是经历和岗位不匹配
//编程语言和框架分个主次，操作系统基础还是多看看
//我是8.23的机票，7+3隔离，9.3，家在北京，六个月-一年
//L4还是要一段时间，短时期不会，要先解决伦理问题，技术上达到了也会有很多其他阻碍（比如法律法规）
//实际上，国内自动驾驶L4更像是广告，赚钱的是和车企合作的L2, L3
//momenta，自动驾驶，感知：雷达+视觉，和车企合作还是要看成本
//客户端岗位，机器训练需要数据，做一个标注