import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Numbers{
	static String[] Log = new String[4000];
	static int t = 0;
    public static void main(String []args){
    	Start();
		subMain();
    }
    static String Reader(){
        String str = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            if(str.equals("white")){
            	t = 2;
            }
            else if(str.equals("log")){
            	t = 3;
            }
        }
        catch(Exception e){
            str = "error";
            System.out.println("予期せぬエラー");
        }
        return str;
    }
    static long Change(String a){
        long i = 0;
        try{
        	i = Integer.parseInt(a);
        	createFile(a);
        }
        catch(NumberFormatException e){
        		t = 1;
        }
        return i;
    }
    static boolean Prime(long num) {
        if (num < 2) return false;
        else if (num == 2) return true;
        else if (num % 2 == 0) return false;
        double sqrtNum = Math.sqrt(num);
        for (int i = 3; i <= sqrtNum; i += 2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    static void subMain(){
    	readFile();
    	System.out.println("対象となる数値を入力");
    	String b = Reader();
    	if(t == 2){
    		whiteFile();
    	}
    	else if(t == 3){
    		for(int th = 0;!(Log[th] == null);th++){
    			System.out.println(Log[th]);
    		}
    	}
    	else{
    		if(!(b == "error")){
    			long m = Change(b);
    			if(t == 1){
    				System.out.println("数値のみ入力可能");
    			}
    			else{
    				if(Prime(m)){
    					System.out.println("素数");
    				}
    				else{
    					System.out.println("合成数");
    				}
    			}
    		}
    	}
    	System.out.println("Enterキーで終了");
    	String a = Reader();
    }
    static void Start(){
    	System.out.println("Numbersへようこそ");
    	System.out.println("ここでは入力された数が素数かどうかなどの解析をします。");
    }
    static void createFile(String a){
    	try{
    		File file = new File("Files\\log.txt");
    		FileWriter filewriter = new FileWriter(file,true);
    		filewriter.write(a + "\r\n");
    		filewriter.close();
    		readFile();
    	}
    	catch(IOException e){
    		System.out.println("ファイルの操作でエラーが発生");
    	}
    }
    static void readFile(){
    	String str;
    	int t = 0;
    	for(int a = 0;a < 4000;a++){
    		Log[a] = null;
    	}
    	File file = new File("Files\\log.txt");
    	try(Scanner sc = new Scanner(file)){
    		while(sc.hasNextLine()){
    			str = sc.nextLine();
    			Log[t] = str;
    			t++;
    		}
    	}
    	catch(FileNotFoundException e){
    		System.out.println("ファイルの読み込みでエラーが発生");
    	}
    }
    static void whiteFile(){
    	File file = new File("Files\\log.txt");
    	try{
    		FileWriter filewriter = new FileWriter(file);
    		filewriter.write(" ");
    		filewriter.close();
    	}
    	catch(IOException e){
    		System.out.println("ファイルの初期化に失敗");
    	}
    	for(int i = 0;i < 4000;i++){
    		Log[i] = null;
    	}
    }
}