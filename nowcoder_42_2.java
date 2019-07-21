public static void Encrypt(char aucPassword[], char aucResult[]){
        //使用循环处理
        for (int i = 0; i < aucPassword.length ; i++) {
            //数字
            if(48<=aucPassword[i] && aucPassword[i]<=57){
                if(aucPassword[i] == '9'){
                    aucResult[i] = '0';
                    continue;
                }
                aucResult[i] = (char)(aucPassword[i]+1);
                //字母  小写
            }else if(Character.isLowerCase(aucPassword[i])) {
                if (aucPassword[i] == 'z') {
                    aucResult[i] = 'A';
                    continue;
                }
                aucResult[i] = Character.toUpperCase(new Character((char)(aucPassword[i] + 1)));

                //大写
            }else if(Character.isUpperCase(aucPassword[i])){
                if(aucPassword[i] == 'Z'){
                    aucResult[i] = 'a';
                    continue;
                }
                aucResult[i] = (char)(aucPassword[i]+1);
                aucResult[i] = Character.toLowerCase(new Character((char)(aucPassword[i] + 1)));
            }else {
                aucResult[i] = aucPassword[i];
            }
        }
    }
    //解密
    public static void unEncrypt(char result[], char password[]){
        for (int i = 0; i < result.length ; i++) {
            //数字
            if(48<=result[i] && result[i]<=57){
                if(result[i] == '0'){
                    password[i] = '9';
                    continue;
                }
                password[i] = (char)(result[i]-1);
                //字母  小写
            }else if(Character.isLowerCase(result[i])) {
                if (result[i] == 'a') {
                    password[i] = 'Z';
                    continue;
                }
                password[i] = Character.toUpperCase(new Character((char)(result[i] - 1)));

                //大写
            }else if(Character.isUpperCase(result[i])){
                if(result[i] == 'A'){
                    password[i] = 'z';
                    continue;
                }
                password[i] = (char)(result[i]+1);
                password[i] = Character.toLowerCase(new Character((char)(result[i] - 1)));
            }else {
                password[i] = result[i];
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            char[] c = s.toCharArray();
            char[] c1 = s1.toCharArray();
            char[] ret = new char[c.length];
            char[] ret1 = new char[c1.length];
            Encrypt(c,ret);
            unEncrypt(c1,ret1);
            for (int i = 0; i < ret.length; i++) {
                if(i == ret.length-1){
                    System.out.println(ret[i]);
                    break;
                }
                System.out.print(ret[i]);
            }
            /*System.out.println();*/
            for (int i = 0; i < ret1.length; i++) {
                System.out.print(ret1[i]);
            }
            System.out.println();
        }
    }