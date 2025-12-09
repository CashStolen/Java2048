import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainFrame extends JFrame implements KeyListener{
    //本身对象继承自JFrame类！！！
    //构造方法（创建对象的时候执行）
    public static void main(String[] args) {
    //初始数组设置
    int[][]arr={
        {0,2,4,8},
        {8,16,16,64},
        {2,4,4,2},
        {4,4,8,0}
        };
    //把0右移和把数据左移合并
    for(int i=0;i<arr.length;i++){
        int[]newArr=new int[4];
        int index=0;
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j] != 0){
                newArr[index]=arr[i][j];
                index++;
            }
        }
        arr[i]=newArr;
    //System.out.println(arr[0][2]);
    //数据左移完毕，接下来进行合并、补零
        for(int k=0;k<arr.length-1;k++){
            if(arr[i][k]==arr[i][k+1]){
                arr[i][k]*=2;
                for(int l=k+1;l<arr[i].length-1;l++){
                    arr[i][l]=arr[i][l+1];
                }
                arr[i][3]=0;
            }
        }
    
    }
    for(int i=0;i<arr.length;i++){//二维数组的外循环得用整体的行数来表示！！！
        for(int j=0;j<arr[i].length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}

    int[][] arr=new int[4][4];
    int Lose=0;
    int score=0;
    //构造方法
    public MainFrame(){
        //Init_arr();
        //init_22_arr();
        init_arr();
        initFrame();
        paintFrame();
        //添加键盘监听
        this.addKeyListener(this);
        setVisible(true);
    }
    public void initFrame(){
        setAlwaysOnTop(true);
        setSize(600, 614);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setTitle("2048");
        setLayout(null);
    }
    public void paintFrame(){
        getContentPane().removeAll();

        JLabel Score=new JLabel("scored："+score);
        Score.setBounds(20, 0, 80, 60);
        getContentPane().add(Score);

        if(Lose==1){
            JLabel Lose_image=new JLabel(new ImageIcon("images/lose.png"));
            Lose_image.setBounds(0, 0, 600, 614);
            getContentPane().add(Lose_image);
        }

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                JLabel Region_r=new JLabel(new ImageIcon("images/title_" + arr[i][j] + ".png"));
                Region_r.setBounds(67+130*j, 55+131*i, 120, 120);
                getContentPane().add(Region_r);
            }
        }
        JLabel background =new JLabel(new ImageIcon("images/background.png"));
        background.setBounds(0,0,600,614);
        getContentPane().add(background);

        getContentPane().repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int Keycode=e.getKeyCode();
        if(Keycode==37){
            //System.out.println("left");
            Move_Left(1);
            numRandom();
        }
        else if(Keycode==38){
            //System.out.println("up");
            Rotate_clk();
            Move_Right(1);
            Rotate_anticlk();
            numRandom();
        }
        else if(Keycode==39){
            //System.out.println("right");
            Move_Right(1);
            numRandom();
        }
        else if(Keycode==40){
            //System.out.println("down");
            Rotate_clk();
            Move_Left(1);
            Rotate_anticlk();
            numRandom();
        }
        else{
            return;
        }
        check();
        paintFrame();
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    //左移动
    public void Move_Left(int act){
        for(int i=0;i<arr.length;i++){
        int[]newArr=new int[4];
        int index=0;
        for(int j=0;j<arr[i].length;j++){
            if(arr[i][j] != 0){
                newArr[index]=arr[i][j];
                index++;
            }
        }
        arr[i]=newArr;
    //System.out.println(arr[0][2]);
    //数据左移完毕，接下来进行合并、补零
        for(int k=0;k<arr.length-1;k++){
            if(arr[i][k]==arr[i][k+1]){
                arr[i][k]*=2;
                if(act==1){
                    score+=arr[i][k];
                }
                for(int l=k+1;l<arr[i].length-1;l++){
                    arr[i][l]=arr[i][l+1];
                }
                arr[i][3]=0;
            }
        }
    
    }
    //paintFrame();
    }
    //反转行
    public void Rev_arr(){
        for(int i=0;i<4;i++){
            int []newarr=new int[4];
            for(int j=0;j<4;j++){
                newarr[j]=arr[i][3-j];
            }
            arr[i]=newarr;
        }

    }
    //右移动
    public void Move_Right(int a){
        Rev_arr();
        Move_Left(a);
        Rev_arr();
        //paintFrame();
    }
    //顺时针旋转
    public void Rotate_clk(){
        int[][]Newarr=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Newarr[j][3-i]=arr[i][j];
            }
        }
        arr=Newarr;
    }
    //逆时针旋转
    public void Rotate_anticlk(){
        int[][]Newarr=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Newarr[3-j][i]=arr[i][j];
            }
        }
        arr=Newarr;
    }
    //数组拷贝
    public void copyArr(int [][]arr_1,int [][]arr_2){
        //arr_1=new int[4][4];
        //arr_2=new int[4][4];
        for (int i = 0; i < arr_1.length; i++) {
            for (int j = 0; j < arr_1[i].length; j++) {
                arr_2[i][j]=arr_1[i][j];
            }
        }
    }
    //失败判定
    public void check(){
        if(checkD()==false & checkL()==false & checkR()==false & checkU()==false){
            Lose=1;
        }
        else{
            Lose=0;
        }
    }
    //左移动检查
    public boolean checkL(){
        int[][]newArray=new int[4][4];
        copyArr(arr, newArray);
        Move_Left(2);
        boolean flag=false;
        wai:for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=newArray[i][j]){
                    flag=true;
                    break wai;//命名以跳出外层循环
                }
            }
        }
        copyArr(newArray, arr);
        return flag;  
    }
    //右移动检查
    public boolean checkR(){
        int[][]newArray=new int[4][4];
        copyArr(arr, newArray);
        Move_Right(0);
        boolean flag=false;
        wai:for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=newArray[i][j]){
                    flag=true;
                    break wai;//命名以跳出外层循环
                }
            }
        }
        copyArr(newArray, arr);
        return flag;  
    }
    //上移动检查
    public boolean checkU(){
        int[][]newArray=new int[4][4];
        copyArr(arr, newArray);
        Rotate_clk();
        Move_Right(0);
        Rotate_anticlk();
        boolean flag=false;
        wai:for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=newArray[i][j]){
                    flag=true;
                    break wai;//命名以跳出外层循环
                }
            }
        }
        copyArr(newArray, arr);
        return flag;  
    }
    //下移动检查
    public boolean checkD(){
        int[][]newArray=new int[4][4];
        copyArr(arr, newArray);
        Rotate_clk();
        Move_Left(2);
        Rotate_anticlk();
        boolean flag=false;
        wai:for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=newArray[i][j]){
                    flag=true;
                    break wai;//命名以跳出外层循环
                }
            }
        }
        copyArr(newArray, arr);
        return flag;  
    }
    //随机产生2
    public void numRandom(){
        int index=0;
        int[]array_1={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[]array_2={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==0){
                    array_1[index]=i;
                    array_2[index]=j;
                    index++;
                }
            }
        }
        if(index!=0){
            Random rand=new Random();
            int num=rand.nextInt(index);
            arr[array_1[num]][array_2[num]]=2;
        }
    }
    //初始化(所有数都有可能)
    public void Init_arr(){
        int []Arr={0,2,4,8,16,32,64,128,256,512,1024,2048};
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int Num=random.nextInt(12);
                arr[i][j]=Arr[Num];
            } 
        }
    }
    //2初始化
    public void init_arr(){
        int []Arr={2,2,0,0,0,0,0,0,0,0,0,0};
        Random random=new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int Num=random.nextInt(12);
                arr[i][j]=Arr[Num];
            } 
        }
    }
    //2初始化变体
    public void init_22_arr(){
        numRandom();
        numRandom();
    }
}