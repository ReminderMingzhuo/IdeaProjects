package intern.any;

public class teasureProblem {
    public static void main(String[] args) {

    }
    //前面是宝藏且无人保护且当前是空仓：加一个保安
    //前面是宝藏且无人保护且当前是宝藏：检查前前是否为空仓，若是则加个保安，不是则返回-1
    //前面是宝藏且有人保护且当前是空仓：继续下一个
    //前面是宝藏且有人保护且当前是宝藏：继续下一个

    //前面是空仓且有保安且当前是宝藏：继续下一个
    //前面是空仓且有保安且当前是空仓：继续下一个
    //前面是空仓且无保安且当前是宝藏：继续下一个
    //前面是空仓且有保安且当前是空仓：继续下一个

    int findPosition(String treasureStr){

        if(treasureStr.length() == 1 && treasureStr.charAt(0) == 'T') return -1;
        if(treasureStr.length() == 1 && treasureStr.charAt(0) == 'B') return 0;
        int num = 0;
        //T未被保护的宝藏，B空仓（无保安），P有保安的仓库，S被保护的宝藏
        //构建字符数组，前后加S，保证边际条件
        char[] original = treasureStr.toCharArray();
        char[] chars = new char[original.length+2];
        chars[0] = 'S';
        chars[chars.length-1] = 'S';
        for(int i = 1; i < chars.length-1; i++){
            chars[i] = original[i-1];
        }
        //遍历字符数组
        for(int i = 1; i < chars.length; i++){
            if(chars[i-1] == 'T' && chars[i] == 'B'){
                num++;
                chars[i] = 'P';
                chars[i-1] = 'S';
                if(chars[i+1] == 'T') chars[i+1] = 'S';
            }else if(chars[i-1] == 'T'){
                if(i>1 && chars[i-2] == 'B'){
                    num++;
                    chars[i-2] = 'P';
                    chars[i-1] = 'S';
                }else{
                    return -1;
                }
            }
        }
        return num;
    }
}
