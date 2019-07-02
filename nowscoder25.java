//25次题1   学分绩点
    /**
     * 要求： 输入：学生总的科目
     *              每门科目的学分
     *              每门科目得到的成绩
     *     总分为所有科目的绩点之和/学分之和
     *
     *  问题：一个学生的得到的总分
     *
     *
     */
    public static void studentGPA(int n, int[] credit, int[] score){
        //算出每们科目的绩点
        double allCredit = 0;
        double sum = 0;
        for (int i = 0; i < n ; i++) {
            allCredit +=(peKingGPA(score[i]) * credit[i]);  //所有的绩点
            sum += credit[i];
        }
        //总分
        double ret = allCredit/sum;
        System.out.println(String.format("%.2f",ret));
    }
    public static double peKingGPA(int score){
        if (90<=score && score<=100){
            return 4.0;
        }
        if (85<=score && score<=89){
            return 3.7;
        }
        if (82<=score && score<=84){
            return 3.3;
        }
        if (78<=score && score<=81){
            return 3.0;
        }if (75<=score && score<=77){
            return 2.7;
        }if (72<=score && score<=74){
            return 2.3;
        }if (68<=score && score<=71){
            return 2.0;
        }if (64<=score && score<=67){
            return 1.5;
        }if (60<=score && score<=63){
            return 1.0;
        }
        return 0;
    }